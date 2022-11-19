package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.LoginPageBinding

class LoginFragment : Fragment() {
    private lateinit var binding: LoginPageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginPageBinding.inflate(layoutInflater)
        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_startPage)
        })
        binding.loginButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_insta_page)
        })
        binding.forgotPasswordButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_loginPage_to_forgot_password_page)
        })
        return binding.root
    }
}