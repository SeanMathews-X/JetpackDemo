package com.sean.library.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * Copyright (C), 2020
 * <p>
 * @author: Sean
 * @version: 1.0
 * @create-date:  2020/8/7 16:51
 * @description:  base Activity with MVVM,you should convert layout.xml to dataBinding
 */
open class BaseActivity<B : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    private val annotation: BindLayout = javaClass.getAnnotation(BindLayout::class.java)
        ?: throw Exception("please set layout by @BindLayout(R.layout.xxx)")

    /**
     * if use java,you can use view by[binding].viewId
     */
    protected lateinit var binding: B

    /**
     *
     */
    protected lateinit var vm: VM

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, annotation.layoutId)
        binding.lifecycleOwner = this
        val clazz =
            (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1] as Class<VM>
        vm = ViewModelProvider(this)[clazz]
    }
}