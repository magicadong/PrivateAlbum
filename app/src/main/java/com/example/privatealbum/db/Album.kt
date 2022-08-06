package com.example.privatealbum.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val ALBUM_TYPE_IMAGE = 0
const val ALBUM_TYPE_VIDEO = 1

/**默认表名就是类名*/
//@Entity(tableName = "album_table")
@Entity
data class Album(
    @PrimaryKey(autoGenerate = true)/**主键*/
    val id:Int,
    var albumName:String,
    //@ColumnInfo(name = "cover_url") 设置字段在表里面的名字
    var coverUrl:String,
    val type:Int = ALBUM_TYPE_IMAGE
)

@Entity
data class ThumbImage(
    @PrimaryKey(autoGenerate = false)
    val imageName:String,
    val albumId:Int
)