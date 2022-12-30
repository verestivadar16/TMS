package com.example.tms.view.fragment

import android.content.ContentValues
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.AddEventPageBinding
import com.example.tms.databinding.AddFriendPageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class AddFriendFragment : Fragment() {
    private lateinit var binding: AddFriendPageBinding
    private lateinit var mAuth: FirebaseAuth
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = AddFriendPageBinding.inflate(layoutInflater)
        mAuth = FirebaseAuth.getInstance()

        binding.backButton.setOnClickListener(View.OnClickListener {
            getActivity()?.onBackPressed()
        })
        binding.confirmButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.friend_list_page)
        })

        binding.confirmButton.setOnClickListener(View.OnClickListener {
            addFriend()
        })
        return binding.root
    }

    private fun addFriend(){

        val db = Firebase.firestore

        val docRef = db.collection("users").document(mAuth.currentUser?.uid.toString())
        docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        val userName = document.getString("userName")!!
                        val imageName = document.getString("profileImage")!!
                        val currentfriends = document["friends"] as ArrayList<*>
                        val newfriend = binding.editTextUsername.text.toString()

                        val newFriendList : ArrayList<String> = ArrayList()


                        for(it in currentfriends){
                            newFriendList.add(it.toString())
                        }
                        newFriendList.add(newfriend)

                        val post = hashMapOf(
                                "friends" to newFriendList,
                                "userName" to userName,
                                "profileImage" to imageName
                        )
                        db.collection("users").document(mAuth.currentUser?.uid.toString())
                                .set(post)
                                .addOnSuccessListener {
                                    Toast.makeText(requireContext(), "Friend added successfully!", Toast.LENGTH_SHORT).show()
                                    Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!")
                                }
                                .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }

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