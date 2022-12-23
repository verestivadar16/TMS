package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.AddEventPageBinding
import com.example.tms.databinding.ProfilePageBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: ProfilePageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfilePageBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.profile_page_to_navigation_page)
        })
//        binding.friendsButton.setOnClickListener(View.OnClickListener {
//            findNavController().navigate(R.id.action_addEventPage_to_navigationPage)
//        })
        return binding.root
    }
}