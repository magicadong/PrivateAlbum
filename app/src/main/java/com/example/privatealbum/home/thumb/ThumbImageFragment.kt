package com.example.privatealbum.home.thumb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.privatealbum.databinding.FragmentThumbImageBinding
import com.example.privatealbum.db.Album
import com.example.privatealbum.dp2pxI
import com.example.privatealbum.home.album.SpacingItemDecoration

class ThumbImageFragment : Fragment() {
    private lateinit var binding:FragmentThumbImageBinding
    private val albumArgs by navArgs<ThumbImageFragmentArgs>()
    private val model:ThumbViewModel by viewModels()

    private val album:Album by lazy {
        albumArgs.album
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThumbImageBinding.inflate(inflater)
        model.menuList = listOf(binding.libraryBtn,binding.cameraBtn)

        binding.model = model
        binding.clickEvents = ThumClickEvents()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            adapter = ThumbAdapter()
            layoutManager = GridLayoutManager(requireActivity(),3)
            addItemDecoration(SpacingItemDecoration(requireActivity().dp2pxI(4)))
        }
    }
}