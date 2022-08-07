package com.example.privatealbum.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.privatealbum.DEFAULT_COVER_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel(application: Application)
    :AndroidViewModel(application) {
    //保存所有相册信息
    var imageAlbumList = MutableLiveData<List<Album>>(emptyList())
    var videoAlbumList = MutableLiveData<List<Album>>(emptyList())
    //仓库对象
    val repository = Repository(application.applicationContext)
    //保存当前需要添加的相册是什么类型
    var type = ALBUM_TYPE_IMAGE

    //获取相册
    fun loadAlbumsWithType(type:Int){
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.loadAlbumWithType(type)
            result.collect{
                if (type == ALBUM_TYPE_IMAGE) {
                    imageAlbumList.postValue(it)
                }else{
                    videoAlbumList.postValue(it)
                }
            }
        }
    }
    //插入相册
    fun addAlbum(name:String,type: Int){
        viewModelScope.launch(Dispatchers.IO){
            val album = Album(0,name, getApplication<Application>().DEFAULT_COVER_URL,0)
            repository.addAlbum(album)
        }
    }
}
















