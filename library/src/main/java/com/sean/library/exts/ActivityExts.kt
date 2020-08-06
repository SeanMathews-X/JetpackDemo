package com.sean.library.exts

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable

/**
 * Copyright (C), 2020
 * <p>
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/6 11:00
 * @description: Activity's ext fun
 */

/**
 * start activity
 * @param bundle params,nullable
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
 * @param params params,nullable
 */
inline fun <reified TARGET : Activity> Activity.startWithParams(params: Map<String, Any>? = null) {
    if (null == params)
        startActivity(Intent(this, TARGET::class.java))
    else {
        val intent = Intent(this, TARGET::class.java)
        params.forEach {
            when (it.value) {
                is Int -> intent.putExtra(it.key, it.value as Int)
                is Long -> intent.putExtra(it.key, it.value as Long)
                is String -> intent.putExtra(it.key, it.value as String)
                is Parcelable -> intent.putExtra(it.key, it.value as Parcelable)
                is String -> intent.putExtra(it.key, it.value as String)
                is String -> intent.putExtra(it.key, it.value as String)
                is String -> intent.putExtra(it.key, it.value as String)
                is String -> intent.putExtra(it.key, it.value as String)
                is String -> intent.putExtra(it.key, it.value as String)
            }
        }
    }
}

/**
 * start activity for result
 * @param requestCode request code
 * @param bundle params,nullable
 */
@JvmOverloads
inline fun <reified TARGET : Activity> Activity.startForResult(
    requestCode: Int = 0,
    bundle: Bundle? = null
) {
    if (null == bundle)
        startActivityForResult(Intent(this, TARGET::class.java), requestCode)
    else
        startActivityForResult(Intent(this, TARGET::class.java).putExtras(bundle), requestCode)
}

/**
 * 设置结果并返回
 * @param intent 返回数据
 */
fun Activity.finishWithResult(intent: Intent) {
    setResult(Activity.RESULT_OK, intent)
    finish()
}

