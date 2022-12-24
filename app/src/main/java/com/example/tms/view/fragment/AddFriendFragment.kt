package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.AddEventPageBinding
import com.example.tms.databinding.AddFriendPageBinding

class AddFriendFragment : Fragment() {
    private lateinit var binding: AddFriendPageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddFriendPageBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.add_friend_page_to_friend_list_page)
        })
        binding.confirmButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.confirm_button)
        })
        binding.profileButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.profile_page)
        })
        return binding.root
    }
}