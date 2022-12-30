package com.example.tms.view.fragment

import android.content.ContentValues
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.adapter.FriendListAdapter
import com.example.tms.data.FriendListData
import com.example.tms.databinding.FriendsListBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class FriendsFragment : Fragment() {
    private lateinit var binding: FriendsListBinding
    private lateinit var friendArrayList: ArrayList<FriendListData>
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mAuth = FirebaseAuth.getInstance()
        binding = FriendsListBinding.inflate(layoutInflater)
        binding.backButton.setOnClickListener(View.OnClickListener {
            getActivity()?.onBackPressed()
        })
        binding.addButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_friends_page_to_add_friend_page)
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

        for (i in username.indices) {
            val contact = FriendListData(username[i], car_name[i], profImage[i])
            friendArrayList.add(contact)
        }


        friendArrayList.sortBy { it.username }
        binding.listview.adapter = activity?.let { FriendListAdapter(it, friendArrayList) }

        return binding.root
    }

    private fun addFriend(){

    }

    private fun requestFriends(){
        val db = Firebase.firestore

        val docRef = db.collection("users").document(mAuth.currentUser?.uid.toString())
        docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        val userName = document.getString("userName")!!
                        val imageName = document.getString("profileImage")!!
                        val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName")
                        val localFile = File.createTempFile("tempImage", "jpg")
                        storageRef.getFile(localFile).addOnSuccessListener {
                            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)

                        }
                        Log.d(ContentValues.TAG, "DocumentSnapshot data: ${document.data}")
                    } else {
                        Log.d(ContentValues.TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d(ContentValues.TAG, "get failed with ", exception)
                }

    }

}