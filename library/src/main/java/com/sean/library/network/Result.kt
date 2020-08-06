package com.sean.library.network

/**
 * Copyright (C), 2020
 * <p>
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/6 15:23
 * @description:  Base business http result
 */
sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val e: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success->$data"
            is Error -> "Error->$e"
        }
    }
}