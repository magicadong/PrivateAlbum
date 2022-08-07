package com.example.privatealbum.db

import android.content.Context
import kotlinx.coroutines.flow.Flow

class Repository(context: Context) {
    private var albumDao:AlbumDao

    init {
        albumDao = AlbumDatabase.getInstance(context).albumDao()
    }

    //加载相册
    suspend fun loadAlbumWithType(type: Int):Flow<List<Album>>{
        return albumDao.getAllAlumsWithType(type)
    }

    //添加相册
    suspend fun addAlbum(album: Album){
        albumDao.insertAlbum(album)
    }

    //删除相册
    suspend fun deleteAlbums(albums: List<Album>){
        albumDao.deleteAlbums(albums)
    }
}