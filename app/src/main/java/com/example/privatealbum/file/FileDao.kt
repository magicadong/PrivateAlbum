package com.example.privatealbum.file

import android.content.Context
import android.util.Log
import com.example.privatealbum.db.ALBUM_TYPE_VIDEO
import com.example.privatealbum.db.Album
import java.io.File

class FileDao(val context: Context) {
    //文件的根路径
    private val albumRootPath = "${context.filesDir.path}/albums"
    //缩略图文件名
    private val thumbnailDirName = "thumb"
    //原图文件名
    private val originDirName = "origin"
    //视频文件名
    private val videoDirName = "video"


    //创建相册
    fun createAlbum(album: Album){
        //创建相册目录
        createDirectoryWithPath(getAlbumDirPath(album.albumName))
        //创建缩略图目录
        createDirectoryWithPath(getThumbDirPath(album.albumName))
        //创建原图
        createDirectoryWithPath(getOriginDirPath(album.albumName))
        //判断是否需要创建视频路径
        if (album.type == ALBUM_TYPE_VIDEO){
            createDirectoryWithPath(getVideoDirPath(album.albumName))
        }
    }
    //删除相册
    fun deleteAlbums(albums: List<Album>){
        albums.forEach { album ->
            //thumb
            deleteHoleDirWithPath(getThumbDirPath(album.albumName))
            //origin
            deleteHoleDirWithPath(getOriginDirPath(album.albumName))
            //video
            if (album.type == ALBUM_TYPE_VIDEO){
                deleteHoleDirWithPath(getVideoDirPath(album.albumName))
            }
            //删除相册本身
            deleteHoleDirWithPath(getAlbumDirPath(album.albumName))
        }
    }

    //获取相册对应的路径 files/albums/ios
    private fun getAlbumDirPath(albumName:String) = "${albumRootPath}/$albumName"
    //获取缩略图的路径 files/albums/ios/thumb
    private fun getThumbDirPath(albumName: String) = "${albumRootPath}/$albumName/$thumbnailDirName"
    //获取原图的路径 files/albums/ios/orgin
    private fun getOriginDirPath(albumName: String) = "${albumRootPath}/$albumName/$originDirName"
    //获取视频的路径 files/albums/ios/video
    private fun getVideoDirPath(albumName: String) = "${albumRootPath}/$albumName/$videoDirName"
    //创建一个目录/文件夹
    private fun createDirectoryWithPath(path:String){
        val file = File(path)
        if (!file.exists()){
            file.mkdirs()
        }
    }

    //删除一个目录和目录下面的所有内容
    private fun deleteHoleDirWithPath(path: String){
        //创建path对应的file对象
        val file = File(path)
        if (file.isDirectory){
            //删除目录下所有子文件
            file.list()?.forEach { fileName ->
                //获取文件的完整路径
                File("$path/$fileName").also {
                    it.delete() //删除文件
                }
            }
        }
        file.delete() //删除这个目录
    }
}

















