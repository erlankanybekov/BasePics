package com.example.basepics.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding,VM:ViewModel>:AppCompatActivity() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    protected abstract fun inflateVB(layoutInflater: LayoutInflater):VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateVB(layoutInflater)
        setContentView(binding.root)
        checkInternet()
        initViews()
        initViewModel()
        initListener()

    }
    open fun checkInternet(){}
    open fun initViews(){}
    open fun initViewModel(){}
    open fun initListener(){}
}