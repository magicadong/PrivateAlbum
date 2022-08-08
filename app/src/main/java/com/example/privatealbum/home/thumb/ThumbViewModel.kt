package com.example.privatealbum.home.thumb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ThumbViewModel(application:Application): AndroidViewModel(application){
    var menuList = emptyList<FloatingActionButton>()
}