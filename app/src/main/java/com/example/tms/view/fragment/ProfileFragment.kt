package com.example.tms.view.fragment

import android.content.ContentValues.TAG
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.ProfilePageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest


class ProfileFragment : Fragment() {
    private lateinit var binding: ProfilePageBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfilePageBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.profile_page_to_navigation_page)
        })
        binding.friendsButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profile_page_to_friends_page)
        })








        return binding.root
    }



}