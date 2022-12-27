package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.adapter.FriendListAdapter
import com.example.tms.data.FriendListData
import com.example.tms.databinding.FriendsListBinding

class FriendsFragment : Fragment(){
    private lateinit var binding: FriendsListBinding
    private lateinit var friendArrayList: ArrayList<FriendListData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FriendsListBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_friends_page_to_profile_page)
        })
        binding.addFriend.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_friends_page_to_add_friend_page)
        })
        binding.profileButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_friends_page_to_profile_page)
        })



    val profImage = intArrayOf(
        R.drawable.avatar3,
        R.drawable.avatar2,
        R.drawable.avatar,
        R.drawable.avatar4
    )

    val username = arrayOf(

        "Tomi",
        "Roli",
        "Balazs",
        "Tivadar"
    )

    val car_name = arrayOf(
        "Audi rs4 b5",
        "Audi rs4 b6",
        "Volkswagen variant r32",
        "Volkswagen golf r32"
    )

 friendArrayList = ArrayList()

        for (i in username.indices){
            val contact = FriendListData(username[i],car_name[i],profImage[i])
            friendArrayList.add(contact)
        }


        friendArrayList.sortBy { it.username }
        binding.listview.adapter = activity?.let { FriendListAdapter(it, friendArrayList) }

        return binding.root
    }
}