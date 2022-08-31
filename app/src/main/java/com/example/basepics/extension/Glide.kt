package com.example.basepics.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(msg:String){
    Glide.with(this).load(msg).into(this)
}