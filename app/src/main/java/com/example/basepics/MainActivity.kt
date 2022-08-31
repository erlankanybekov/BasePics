package com.example.basepics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.basepics.base.BaseActivity
import com.example.basepics.base.BaseViewModel
import com.example.basepics.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {
    override fun inflateVB(layoutInflater: LayoutInflater): ActivityMainBinding {
       return ActivityMainBinding.inflate(layoutInflater)
    }

}