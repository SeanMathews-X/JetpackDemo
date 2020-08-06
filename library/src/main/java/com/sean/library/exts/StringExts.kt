package com.sean.library.exts

/**
 * Copyright (C), 2020
 * <p>
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/6 10:55
 * @description:
 *      String's ext fun
 */

/**
 * MD5
 * @return 32bit String
 */

external fun md5(src: String): String

fun String.toMD5(): String {
    return md5(this)
}