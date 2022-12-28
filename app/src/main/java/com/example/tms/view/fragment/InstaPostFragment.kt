package com.example.tms.view.fragment

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Bitmap
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
import com.example.tms.adapter.InstaAdaptor
import com.example.tms.data.InstaPostData
import com.example.tms.data.Posts
import com.example.tms.databinding.InstaPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.io.File


class InstaPostFragment : Fragment() {
    private lateinit var binding: InstaPostBinding
    private lateinit var postArrayList: ArrayList<InstaPostData>
    private lateinit var mAuth: FirebaseAuth

    lateinit var rootView: View
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InstaPostBinding.inflate(layoutInflater)

        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_loginpage)
        })
        binding.imageButtonToUploadImage.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_instauploadpage)
        })
        binding.inboxButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_inboxpage)
        })
//        binding.navigationAvatarInsta.setOnClickListener(View.OnClickListener {
//            findNavController().navigate(R.id.action_instapostpage_to_profilepage)
//        })

        binding.profileButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_profile_page)
        })


        val db = Firebase.firestore
       // val postRef = db.collection("users").document("tivadar3")

        postArrayList = ArrayList()


        db.collection("users")
            .get()
            .addOnSuccessListener { users ->
                for(snapshot in users){
                    val name = snapshot.getString("name")!!
                    val imageName = snapshot.getString("image")!!
                    val description = snapshot.getString("description")!!
                    val profilePicture = R.drawable.avatar_button
                    val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName")
                    val localFile = File.createTempFile("tempImage","jpg")
                    //lateinit var bitmap : Bitmap
                    storageRef.getFile(localFile).addOnSuccessListener {
                        val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)

                        val post = InstaPostData(name,description,bitmap,profilePicture)
                        postArrayList.add(post)
                        binding.listview.adapter = activity?.let { InstaAdaptor(it, postArrayList) }

                    }

                }
            }
            .addOnFailureListener { e -> Log.w(TAG, "Transaction failure.", e) }



//        db.runTransaction { transaction ->
//            val snapshot = transaction.get(postRef)
//
//            val name = snapshot.getString("name")!!
//            val imageName = snapshot.getString("image")!!
//            val description = snapshot.getString("description")!!
//            val profilePicture = R.drawable.avatar_button
//            val storageRef = FirebaseStorage.getInstance().reference.child("images/$imageName")
//            val localFile = File.createTempFile("tempImage","jpg")
//            //lateinit var bitmap : Bitmap
//            storageRef.getFile(localFile).addOnSuccessListener {
//               val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
//
//                val post = InstaPostData(name,description,bitmap,profilePicture)
//                postArrayList.add(post)
//                binding.listview.adapter = activity?.let { InstaAdaptor(it, postArrayList) }
//
//            }
//
//
//
//            null
//        }.addOnSuccessListener { Log.d("mokus", "Transaction success!")
//
//
//        }
//            .addOnFailureListener { e -> Log.w(TAG, "Transaction failure.", e) }



//        val profImageId = intArrayOf(
//            R.drawable.avatar_button,
//            R.drawable.avatar_button,
//            R.drawable.avatar_button,
//            R.drawable.avatar_button
//        )
//
//        val name = arrayOf(
//            "Balazs", "Roli", "Tomi", "Tivadar"
//        )
//
//        val postDescription = arrayOf(
//            "ez egy rs4 b5",
//            "ez egy rs4 b6",
//            "ez egy variant r32",
//            "ez egy golf r32"
//        )
//
//        val imageId = intArrayOf(
//            R.drawable.audib5, R.drawable.audib6, R.drawable.variantr32, R.drawable.golfr32
//        )

//        postArrayList = ArrayList()

//        for (i in name.indices) {
//            val post = InstaPostData(name[i], postDescription[i], imageId[i], profImageId[i])
//            postArrayList.add(post)
//        }


//        binding.listview.adapter.add(InstaAdaptor())
        return binding.root
    }


}