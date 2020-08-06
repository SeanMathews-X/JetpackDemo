package com.sean.demo.data

import com.sean.demo.data.model.LoggedInUser
import com.sean.demo.network.LoginApi
import com.sean.library.network.Result
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        return Retrofit.Builder().baseUrl("https://www.baidu.com")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoginApi::class.java)
            .login(
                mapOf(
                    username to "username",
                    password to "password"
                )
            )
    }

    fun logout() {
    }
}