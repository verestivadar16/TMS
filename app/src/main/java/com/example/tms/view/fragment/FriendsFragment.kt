package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.FriendListBinding

class FriendsFragment : Fragment(){
    private lateinit var binding: FriendListBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FriendListBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.friend_list_to_profile_page)
        })
        binding.addFriendButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.friend_list_to_add_friend)
        })
        binding.profileButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.friend_list_to_profile_page)
        })
        return binding.root
    }
}