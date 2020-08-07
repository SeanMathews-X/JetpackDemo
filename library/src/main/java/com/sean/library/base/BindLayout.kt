package com.sean.library.base

import androidx.annotation.LayoutRes

/**
 * Copyright (C), 2020
 * <p>
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/7 16:53
 * @description:  binding layout
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
annotation class BindLayout(
    /**
     * layout id
     */
    @LayoutRes
    val layoutId: Int = 0
)