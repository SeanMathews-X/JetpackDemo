package com.sean.library.exts

import android.content.ContentValues
import android.view.View
import com.sean.library.R
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

/**
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/6 17:23
 * @description:  View's ext fun
 */

/**
 * 点击防抖动，间隔[duration]毫秒,默认1s,逻辑[block]
 */
@JvmOverloads
inline fun View.clickFirst(duration: Long = 1000, crossinline block: () -> Unit) {
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        val lastTime = getTag(R.id.last_click)?.let { l ->
            l as Long
        } ?: 0
        if (currentTime - lastTime > duration) {
            block.invoke()
            setTag(R.id.last_click, currentTime)
        }
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

/**
 *
 */
fun View.saveAsImage() {
    val contentValues: ContentValues
}