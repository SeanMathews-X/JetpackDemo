package com.sean.demo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sean.demo.R
import com.sean.demo.ui.login.LoginActivity
import com.sean.library.exts.clickFirst
import com.sean.library.exts.startWithParams
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*btn.setOnClickListener {
            startWithParams<LoginActivity>()
        }*/


        btn.clickFirst {
            startWithParams<LoginActivity>()
        }
    }
}