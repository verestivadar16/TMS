package com.example.tms.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tms.R
import com.example.tms.data.ImageAdapter
import com.example.tms.data.RetrofitInstance
import com.example.tms.databinding.InstaPostBinding
import com.example.tms.view.activity.MainActivity
import okio.IOException
import retrofit2.HttpException


class InstaPostFragment : Fragment() {
    private lateinit var binding: InstaPostBinding
    val TAG = "mokus"
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
        binding.notificationButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_instapostpage_to_inboxpage)
        })

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getImages()
            } catch (e: IOException) {
                Log.d(TAG, e.toString())
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.d(TAG, "Http")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                val url =
                    "https://i.ytimg.com/vi/-k5VTUfRaK0/maxresdefault.jpg"
                val url2 = RetrofitInstance.api.getImages().body()?.imageUrl
                val temp = RetrofitInstance.api.getImages().body()?.imageUrl
                binding.textview1.text = RetrofitInstance.api.getImages().body()?.name
                val imagePath = binding.image1
                Glide.with(binding.root)
                    .load(url)
                    .into(imagePath)
                val imagePath2 = binding.image2
                Glide.with(binding.root)
                    .load(url2)
                    .into(imagePath2)
            }
        }

        return binding.root
    }
}