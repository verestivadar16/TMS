package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.InstaPostBinding


class InstaPostFragment : Fragment() {
    private lateinit var binding: InstaPostBinding
    private lateinit var postArrayList : ArrayList<InstaPostData>

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

        val profImageId = intArrayOf(
            R.drawable.avatar_button, R.drawable.avatar_button, R.drawable.avatar_button, R.drawable.avatar_button
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
            val post = InstaPostData(name[i], postDescription[i],imageId[i], profImageId[i])
            postArrayList.add(post)
        }

        binding.listview.adapter = activity?.let { InstaAdaptor(it, postArrayList) }

        return binding.root
    }


}