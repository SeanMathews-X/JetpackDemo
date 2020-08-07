package com.sean.library.exts

import android.content.ContentValues
import android.view.View
import com.sean.library.R

/**
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/6 17:23
 * @description:  View's ext fun
 */

/**
 * 点击防抖动，间隔[interval]秒,默认1s,逻辑[block]
 */
@JvmOverloads
inline fun View.clickFirst(interval: Long = 1000, crossinline block: () -> Unit) {
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        val lastTime = getTag(R.id.last_click)?.let { l ->
            l as Long
        } ?: 0
        if (currentTime - lastTime > interval) {
            block.invoke()
        }
        setTag(R.id.last_click, currentTime)
    }
}

/**
 *
 */
fun View.saveAsImage() {
    val contentValues: ContentValues
}