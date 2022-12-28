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
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*

class InstaUploadFragment : Fragment() {
    private lateinit var binding: InstaUploadImageBinding
    private lateinit var imageUri: Uri
    private lateinit var mAuth : FirebaseAuth

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


        }
        return binding.root


    }


    private fun uploadImage() {

        val progressDialog = ProgressDialog(requireContext())
        progressDialog.setMessage("Uploading file ...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val db = Firebase.firestore

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss",Locale.getDefault())
        val now = Date()
        val date = formatter.format(now)

// Add a new document with a generated ID
        val post = hashMapOf(
            "name" to "Tivadar",
            "description" to binding.editTextDescription.text.toString(),
            "image" to imageUri.toString()
        )


        db.collection("users").document(date)
            .set(post)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!")
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

        val fileName =imageUri.toString()

        val storageReference = FirebaseStorage.getInstance().getReference("images/$fileName")

        storageReference.putFile(imageUri).addOnSuccessListener {
            if(progressDialog.isShowing)progressDialog.dismiss()
            findNavController().navigate(R.id.action_instauploadpage_to_instapostpage)
        }.addOnFailureListener {
            if(progressDialog.isShowing)progressDialog.dismiss()
        }

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




