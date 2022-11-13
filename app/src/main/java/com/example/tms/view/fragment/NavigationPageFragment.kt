package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        return binding.root
    }
}