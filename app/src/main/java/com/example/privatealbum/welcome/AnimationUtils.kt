package com.example.privatealbum.welcome

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

fun Animation.setAnimationStatusChangeListener(
    onStart:(Animation?)->Unit = {},
    onEnd:(Animation?)->Unit = {},
    onRepeat:(Animation?)->Unit = {}
){
    this.setAnimationListener(object:Animation.AnimationListener{
        override fun onAnimationStart(animation: Animation?) {
            onStart(animation)
        }

        override fun onAnimationEnd(animation: Animation?) {
            onEnd(animation)
        }

        override fun onAnimationRepeat(animation: Animation?) {
            onRepeat(animation)
        }
    })
}

fun View.startAnimationWithListener(
    resId: Int,
    onStart:(Animation?)->Unit = {},
    onEnd:(Animation?)->Unit = { },  //声明方法  给默认实现
    onRepeat:(Animation?)->Unit = {}
){
    val animation = AnimationUtils.loadAnimation(this.context,resId)
    animation.setAnimationListener(object:Animation.AnimationListener{
        override fun onAnimationStart(animation: Animation?) {
            onStart(animation)
        }
        override fun onAnimationEnd(animation: Animation?) {
            //调用方法
            onEnd(animation)
        }
        override fun onAnimationRepeat(animation: Animation?) {
            onRepeat(animation)
        }
    })
    this.startAnimation(animation)

}






