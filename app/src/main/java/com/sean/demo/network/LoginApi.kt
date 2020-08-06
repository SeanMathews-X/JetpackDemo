package com.sean.demo.network

import com.sean.demo.data.model.LoggedInUser
import com.sean.library.network.Result
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Copyright (C), 2020
 * <p>
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/6 15:33
 * @description:  Login Api
 */
interface LoginApi {

    @POST("/login")
    suspend fun login(@Body params: Map<String, String>): Result<LoggedInUser>
}