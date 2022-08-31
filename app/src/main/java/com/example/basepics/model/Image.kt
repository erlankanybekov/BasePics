package com.example.basepics.model

import java.io.Serializable

data class Image(
    val image: String,
    var bool: Boolean,
) : Serializable
