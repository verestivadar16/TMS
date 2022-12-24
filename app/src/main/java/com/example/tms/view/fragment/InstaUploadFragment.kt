package com.example.tms.view.fragment

import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.InstaUploadImageBinding
import com.firebase.ui.auth.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class InstaUploadFragment : Fragment() {
    private lateinit var binding: InstaUploadImageBinding
    private lateinit var imageUri: Uri
    private lateinit var mAuth : FirebaseAuth
    private lateinit var currentUser : User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InstaUploadImageBinding.inflate(layoutInflater)
        mAuth= FirebaseAuth.getInstance()

        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instauploadpage_to_instapostpage)
        })
        binding.buttonChooseImage.setOnClickListener(View.OnClickListener{

            selectImage()

        })

        binding.buttonUpload.setOnClickListener(){

            uploadImage()
            findNavController().navigate(R.id.action_instauploadpage_to_instapostpage)

        }
        return binding.root


    }



    private fun uploadImage() {

        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Uploading file ...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val db = Firebase.firestore

        val user = hashMapOf(
            "name" to "asd",
            "picture" to imageUri.toString(),

        )

// Add a new document with a generated ID
        val city = hashMapOf(
            "name" to "tivadar",
            "image" to imageUri
        )

        db.collection("users").document("Tivadar")
            .set(city)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }


    }
    private fun selectImage() {

        val intent = Intent()
        intent.type= "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent,100)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 100 && resultCode == RESULT_OK){
            imageUri=data?.data!!
            binding.uploadedImage.setImageURI(imageUri)
        }

    }
}




