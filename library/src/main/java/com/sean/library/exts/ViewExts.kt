package com.sean.library.exts

import android.view.View
import com.sean.library.R

/**
 * Copyright (C), 2020
 * <p>
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/6 17:23
 * @description:  View's ext fun
 */


/**
 * 点击防抖动,默认设置间隔一秒
 * @param interval 点击间隔，默认1s
 * @param f 点击执行的方法
 */
@JvmOverloads
fun View.clickFirst(interval: Int = 1000, f: () -> Unit) {
    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        val lastTime = getTag(R.id.last_click)?.let { l ->
            l as Long
        } ?: 0
        if (lastTime == currentTime || currentTime - lastTime > interval) {
            f.invoke()
        }
        setTag(R.id.last_click, currentTime)
    }
}


fun View.saveAsImage() {
    TODO("view直接保存为图片")
}