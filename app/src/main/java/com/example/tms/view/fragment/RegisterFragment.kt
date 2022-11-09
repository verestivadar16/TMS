package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.RegistrationPageBinding

class RegisterFragment:Fragment() {
    private lateinit var binding : RegistrationPageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RegistrationPageBinding.inflate(layoutInflater)
        binding.imageButtonBack.setOnClickListener(View.OnClickListener{
            findNavController().navigate(R.id.action_registerPage_to_startPage)
        })

        binding.buttonRegister.setOnClickListener(View.OnClickListener{
            findNavController().navigate(R.id.action_registerPage_to_startPage)
        })
        return binding.root
    }
}