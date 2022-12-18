package com.example.tms.view.fragment

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.InstaUploadImageBinding

class InstaUploadFragment : Fragment() {
    private lateinit var binding: InstaUploadImageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InstaUploadImageBinding.inflate(layoutInflater)

        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instauploadpage_to_instapostpage)
        })
        binding.buttonChooseImage.setOnClickListener({})
        return binding.root


    }
}




