package com.example.privatealbum.home

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.privatealbum.DEFAULT_COVER_URL
import com.example.privatealbum.R
import com.example.privatealbum.databinding.AlbumItemBinding
import com.example.privatealbum.db.Album
import java.io.File

class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {
    private var albums:List<Album> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(AlbumItemBinding.inflate(inflater))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(albums[position])
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    class MyViewHolder(val binding:AlbumItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(album:Album){
            //加载图片
            Glide
                .with(itemView)
                .load("https://t7.baidu.com/it/u=852388090,130270862&fm=193&f=GIF")
                .into(binding.coverImageView)
            binding.coverImageView
            binding.nameTextView.text = album.albumName
            binding.countTextView.text = album.number.toString()
            binding.renameBtn.setOnClickListener {
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newData:List<Album>){
        albums = newData
        //刷新界面
        notifyDataSetChanged()
    }
}