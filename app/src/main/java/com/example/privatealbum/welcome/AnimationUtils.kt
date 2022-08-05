package com.example.privatealbum.welcome

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import java.time.Duration

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


//左右摆动的动画效果
fun View.startShakeAnimation(offsetX:Float,time:Long){
    ObjectAnimator.ofFloat(
        this,
        "translationX",
        0f,
        -offsetX,
        2 * offsetX,
        0f
    ).apply {
        duration = time
        repeatCount = 2
        repeatMode = ObjectAnimator.RESTART
        interpolator = AccelerateInterpolator()
        start()
    }
}





