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

//        lifecycleScope.launchWhenCreated {
//            val response = try {
//                RetrofitInstance.api.getImages()
//            }catch (e: IOException){
//                Log.d(TAG, "Interet error")
//                return@launchWhenCreated
//            }catch (e: HttpException){
//                Log.d(TAG, "Http")
//                return@launchWhenCreated
//            }
//            if(response.isSuccessful && response.body() != null){
//
//            }
//        }

        return binding.root
    }

    private fun setupRecyclerView() = binding.textview1.apply {

    }

}

