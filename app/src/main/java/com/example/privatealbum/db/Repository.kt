package com.example.privatealbum.db

import android.content.Context
import androidx.lifecycle.LiveData

class Repository(context: Context) {
    private var albumDao:AlbumDao

    init {
        albumDao = AlbumDatabase.getInstance(context).albumDao()
    }

    //加载相册
    suspend fun loadAlbumWithType(type: Int):List<Album>{
        return albumDao.getAllAlumsWithType(type)
    }

    //添加相册
    suspend fun addAlbum(album: Album){
        albumDao.insertAlbum(album)
    }
}