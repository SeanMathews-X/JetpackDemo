package com.sean.demo.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sean.demo.R
import com.sean.demo.login.ui.login.LoginActivity
import com.sean.library.exts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        `startWithPara,s`<LoginActivity>()
    }
}