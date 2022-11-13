package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.ForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: ForgotPasswordBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = ForgotPasswordBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_forgotPage_to_loginPage)
        })

        binding.sendButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_forgotPage_to_loginPage)
        })

        return binding.root
    }
}