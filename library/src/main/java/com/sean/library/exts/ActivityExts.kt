package com.sean.library.exts

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * Copyright (C), 2020
 * <p>
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/6 11:00
 * @description: Activity's ext fun
 */

/**
 * 带参数[bundle]跳转到[TARGET]
 */
@JvmOverloads
inline fun <reified TARGET : Activity> Activity.startWithBundle(bundle: Bundle? = null) {
    if (null == bundle)
        startActivity(Intent(this, TARGET::class.java))
    else
        startActivity(Intent(this, TARGET::class.java).putExtras(bundle))
}

/**
 * start activity
 * @param params [Pair]
 */
inline fun <reified TARGET : Activity> Activity.startWithParams(vararg params: Pair<String, Any?>) {
    val intent = Intent(this, TARGET::class.java)
    intent.fillWithParams(params)
    startActivity(intent)
}

/**
 * 将键值对填充到Intent
 * @throws [ClassNotFoundException]
 */
fun Intent.fillWithParams(params: Array<out Pair<String, Any?>>) {
    params.forEach {
        when (val value = it.second) {
            null -> putExtra(it.first, null as Serializable?)
            is Int -> putExtra(it.first, value)
            is Long -> putExtra(it.first, value)
            is CharSequence -> putExtra(it.first, value)
            is String -> putExtra(it.first, value)
            is Float -> putExtra(it.first, value)
            is Double -> putExtra(it.first, value)
            is Char -> putExtra(it.first, value)
            is Short -> putExtra(it.first, value)
            is Boolean -> putExtra(it.first, value)
            is Serializable -> putExtra(it.first, value)
            is Bundle -> putExtra(it.first, value)
            is Parcelable -> putExtra(it.first, value)
            is Array<*> -> when {
                value.isArrayOf<CharSequence>() -> putExtra(it.first, value)
                value.isArrayOf<String>() -> putExtra(it.first, value)
                value.isArrayOf<Parcelable>() -> putExtra(it.first, value)
                else -> throw ClassCastException("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
            }
            is IntArray -> putExtra(it.first, value)
            is LongArray -> putExtra(it.first, value)
            is FloatArray -> putExtra(it.first, value)
            is DoubleArray -> putExtra(it.first, value)
            is CharArray -> putExtra(it.first, value)
            is ShortArray -> putExtra(it.first, value)
            is BooleanArray -> putExtra(it.first, value)
            else -> throw ClassCastException("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
        }
    }
}

/**
 * start activity with [params] for result,request code is [requestCode]
 */
@JvmOverloads
inline fun <reified TARGET : Activity> Activity.startForResult(
    requestCode: Int = 0,
    vararg params: Pair<String, Any?>
) {
    val intent = Intent(this, TARGET::class.java)
    intent.fillWithParams(params)
    startActivityForResult(intent, requestCode)
}

/**
 * 设置结果并返回
 * @param intent 返回数据
 */
fun Activity.finishWithResult(intent: Intent) {
    setResult(Activity.RESULT_OK, intent)
    finish()
}

