package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tms.databinding.InstaUploadImageBinding

class InstaUploadFragment:Fragment() {
    private lateinit var binding: InstaUploadImageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InstaUploadImageBinding.inflate(layoutInflater)

        return binding.root
    }
}