package com.example.privatealbum.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlbumDao {
    //创建相册
    @Insert
    fun insertAlbum(album: Album)
    //删除一个相册
    @Delete
    fun deleteAlbum(album: Album)
    //删除多个相册
    @Delete
    fun deleteAlbums(vararg albums:Album)
    //更新相册
    @Update
    fun updateAlbum(album: Album)
    /**查询所有相册信息 查询方法不要使用suspend修饰*/
    @Query("select * from Album where type = :type")
    fun getAllAlumsWithType(type:Int):List<Album>
    /**------------------相片----------------*/
    //插入一张图片
    @Insert
    fun insertImage(thumbImage: ThumbImage)
    //插入多张图片
    @Insert
    fun insertImages(vararg images:ThumbImage)
    //删除一张图片
    @Delete
    fun deleteImage(thumbImage: ThumbImage)
    //删除多张图片
    @Delete
    fun deleteImages(vararg images:ThumbImage)

    /**
     * 相册和缩略图的关系
     * 1 vs N
     * List<>
     */
}