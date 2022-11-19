package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.NavigationPageBinding

//AIzaSyCXPxzAnc8icMuBAYqWnbtw5S2eaT5opMg


class NavigationPageFragment : Fragment() {

    private lateinit var binding: NavigationPageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NavigationPageBinding.inflate(layoutInflater)
//        binding.homeButton.setOnClickListener(View.OnClickListener {
//        findNavController().navigate(R.id.action_navigation_to_instapostpage)
//        })
        binding.addEventButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_navigation_to_ad_event_page)
        })
        return binding.root
    }

}