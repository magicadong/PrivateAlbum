package com.example.privatealbum.file

import android.annotation.SuppressLint
import android.content.Context
import com.example.privatealbum.db.Album

class FileMananger private constructor(val context: Context){

    //文件操作对象
    private val fileDao = FileDao(context)

    companion object{
        @SuppressLint("StaticFieldLeak")
        private var INSTANCE:FileMananger? = null

        fun getInstance(context: Context):FileMananger{
            if (INSTANCE != null){
                return INSTANCE!!
            }
            synchronized(this){
                if (INSTANCE == null){
                    INSTANCE = FileMananger(context)
                }
                return INSTANCE!!
            }
        }
    }

    //创建相册
    suspend fun createAlbum(album: Album){
        fileDao.createAlbum(album)
    }

    //删除相册
    suspend fun deleteAlbums(albums: List<Album>){
        fileDao.deleteAlbums(albums)
    }
}
















