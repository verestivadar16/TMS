package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.InstaPostBinding


class InstaPostFragment: Fragment() {
    private lateinit var binding: InstaPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InstaPostBinding.inflate(layoutInflater)
        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_loginpage) })
        binding.imageButtonToUploadImage.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_instauploadpage)
        })

        return binding.root
    }
}