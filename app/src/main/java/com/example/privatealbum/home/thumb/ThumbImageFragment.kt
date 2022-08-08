package com.example.privatealbum.home.thumb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.privatealbum.databinding.FragmentThumbImageBinding
import com.example.privatealbum.db.Album

class ThumbImageFragment : Fragment() {
    private lateinit var binding:FragmentThumbImageBinding
    private val albumArgs by navArgs<ThumbImageFragmentArgs>()
    private val album:Album by lazy {
        albumArgs.album
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThumbImageBinding.inflate(inflater)
        return binding.root
    }

}