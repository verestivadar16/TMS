package com.example.tms.view.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.adapter.InstaAdaptor
import com.example.tms.data.InstaPostData
import com.example.tms.databinding.InstaPostBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class InstaPostFragment : Fragment() {
    private lateinit var binding: InstaPostBinding
    private lateinit var postArrayList: ArrayList<InstaPostData>
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InstaPostBinding.inflate(layoutInflater)
        val db = Firebase.firestore
        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_loginpage)
        })
        binding.imageButtonToUploadImage.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_instauploadpage)
        })
        binding.inboxButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_inboxpage)
        })

        binding.profileButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_profile_page)
        })

        lateinit var imagefirst : String
        val sfDocRef = db.collection("users").document("Tivadar")

        db.runTransaction { transaction ->
            val snapshot = transaction.get(sfDocRef)

            // Note: this could be done without a transaction
            //       by updating the population using FieldValue.increment()
            val image = snapshot.getString("image")!!
            //transaction.update(sfDocRef, "image", newPopulation)
            imagefirst = image
            // Success
            null
        }.addOnSuccessListener { Log.d(TAG, "Transaction success!") }
            .addOnFailureListener { e -> Log.w(TAG, "Transaction failure.", e) }


        val profImageId = intArrayOf(
            R.drawable.avatar_button,
            R.drawable.avatar_button,
            R.drawable.avatar_button,
            R.drawable.avatar_button
        )

        val name = arrayOf(
            "Balazs", "Roli", "Tomi", "Tivadar"
        )

        val postDescription = arrayOf(
            "ez egy rs4 b5",
            "ez egy rs4 b6",
            "ez egy variant r32",
            "ez egy golf r32"
        )

        val imageId = intArrayOf(
            R.drawable.audib5, R.drawable.audib6, R.drawable.variantr32, R.drawable.golfr32
        )

        postArrayList = ArrayList()

        for (i in name.indices) {
            val post = InstaPostData(name[i], postDescription[i], imageId[i], profImageId[i])
            postArrayList.add(post)
        }

        binding.listview.adapter = activity?.let { InstaAdaptor(it, postArrayList) }
       // binding.listview.adapter.add(InstaAdaptor())

        return binding.root
    }


}