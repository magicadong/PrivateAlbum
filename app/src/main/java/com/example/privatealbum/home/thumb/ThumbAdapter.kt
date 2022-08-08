package com.example.privatealbum.home.thumb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.privatealbum.R
import com.example.privatealbum.databinding.LayoutThumbItemBinding

class ThumbAdapter: RecyclerView.Adapter<ThumbAdapter.MyViewHodler>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHodler {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutThumbItemBinding.inflate(inflater)
        return MyViewHodler(binding)
    }

    override fun onBindViewHolder(holder: MyViewHodler, position: Int) {

    }

    override fun getItemCount(): Int {
        return 50
    }

    class MyViewHodler(val binding:LayoutThumbItemBinding):RecyclerView.ViewHolder(binding.root){

    }
}