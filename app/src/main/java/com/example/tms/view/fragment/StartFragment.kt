package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.StartPageBinding
import com.google.firebase.auth.FirebaseAuth

class StartFragment : Fragment() {
    private lateinit var binding: StartPageBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        mAuth=FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        if (user != null) {
            // User is signed in
            Toast.makeText(requireContext(), "Loggid in as:\n"+ (user.email.toString() ), Toast.LENGTH_SHORT).show()
           // findNavController().navigate(R.id.action_startFragment_to_InstaFragment)

        }

        binding = StartPageBinding.inflate(layoutInflater)

        binding.loginButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_loginFragment)
        })
        binding.registerButton.setOnClickListener {
            findNavController().navigate((R.id.action_startFragment_to_registerFragment))
        }
        return binding.root
    }

}