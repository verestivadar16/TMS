package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.StartPageBinding

class StartFragment : Fragment() {
    private lateinit var binding: StartPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = StartPageBinding.inflate(layoutInflater)

        binding.loginButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_loginFragment)
        })
        binding.registerButton.setOnClickListener {
            findNavController().navigate((R.id.action_startFragment_to_registerFragment))
        }
        return binding.root
    }

}