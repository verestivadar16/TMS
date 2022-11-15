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

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getImages()
            } catch (e: IOException) {
                Log.d(TAG, "Interet error")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.d(TAG, "Http")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                val url =
                    "https://scontent.ftgm1-1.fna.fbcdn.net/v/t39.30808-6/315395090_5741168132639387_2015909519419573860_n.jpg?_nc_cat=105&ccb=1-7&_nc_sid=5cd70e&_nc_ohc=r0nFXTjuVasAX8LLnmN&_nc_ht=scontent.ftgm1-1.fna&oh=00_AfCiGKA_yF8oZEVXL4CLaWPMSQqxGB9PwjqxEGtksQH4mg&oe=637655CF"
                val url2 = RetrofitInstance.api.getImages().body()?.imageUrl
                binding.textview1.text = url2
                val imagePath = binding.image1
                Glide.with(binding.root)
                    .load(url)
                    .into(imagePath)
                val imagePath2 = binding.image2
                Glide.with(binding.root)
                    .load(url2)
//                    .apply(RequestOptions.circleCropTransform())
                    .into(imagePath2)
            }
        }

        return binding.root
    }
}