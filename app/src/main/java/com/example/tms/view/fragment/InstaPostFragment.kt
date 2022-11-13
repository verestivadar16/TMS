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
            }catch (e: IOException){
                Log.d(TAG, "Interet error")
                return@launchWhenCreated
            }catch (e: HttpException){
                Log.d(TAG, "Http")
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body() != null){
                val url = "https://blog.ecstuning.com/wp-content/uploads/2018/08/DH_ECS_BMW_M3_540_ROADTRIP_020.jpg"
                val url2 = RetrofitInstance.api.getImages().body()?.imageUrl
                binding.textview1.text= url2
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

    private fun setupTextView() = binding.textview1.apply {

    }

}

