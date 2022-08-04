package com.example.privatealbum.password

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.privatealbum.R
import com.example.privatealbum.databinding.FragmentUnlockBinding

import com.example.privatealbum.getResourceColor

class UnlockFragment : Fragment() {
    lateinit var binding: FragmentUnlockBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnlockBinding.inflate(
            inflater,container,false)
        requireActivity().window.statusBarColor = getResourceColor(
            requireActivity(),R.color.green)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.unlockView.onPasswordFinishListener = { password ->

            PasswordStatus.ERROR
        }
    }
}