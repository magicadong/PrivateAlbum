package com.example.privatealbum.home

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

//删除按钮是否显示
@BindingAdapter("shouldShow")
fun ImageView.shouldShow(show:Boolean){
    visibility = if (show){ //编辑状态时 显示删除按钮
        isEnabled = true
        View.VISIBLE
    }else{
        isEnabled = false
        View.INVISIBLE
    }
}

//编辑状态需要显示黑色遮罩和选中的圆点
@BindingAdapter("shouldShowEdit")
fun View.shouldShowEdit(isEdit:Boolean){
    visibility = if (isEdit){
        View.VISIBLE
    }else{
        View.INVISIBLE
    }
    Log.v("pxd","$visibility")
}