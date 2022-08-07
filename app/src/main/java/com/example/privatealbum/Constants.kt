package com.example.privatealbum

import android.content.Context
import kotlin.random.Random

//默认图片封面的URL地址
val Context.DEFAULT_COVER_URL:String
    get() {
        val index = Random(System.currentTimeMillis()).nextInt(2)
        return if (index == 0) {
            "${this.filesDir.path}/default_cover/f1.png"
        }else{
            "${this.filesDir.path}/default_cover/f2.png"
        }
    }