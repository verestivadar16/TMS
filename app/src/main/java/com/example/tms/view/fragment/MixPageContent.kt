package com.example.tms.view.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.tms.R
import com.example.tms.databinding.MixContentPageBinding


class MixPageContent : Fragment() {
    private lateinit var binding: MixContentPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref =requireActivity().getPreferences(Context.MODE_PRIVATE)
        val default = sharedPref.getBoolean("switchValue", true)



    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        binding = MixContentPageBinding.inflate(layoutInflater)
        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            getActivity()?.onBackPressed()
        })


        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val sw1 = getView()?.findViewById<Switch>(R.id.posts_switch)
        val sw2 = getView()?.findViewById<Switch>(R.id.market_switch)
        val sw3 = getView()?.findViewById<Switch>(R.id.event_switch)
        val sw4 = getView()?.findViewById<Switch>(R.id.warning_switch)

        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val default = sharedPref.getBoolean("switchValue", true)
        val default2 = sharedPref.getBoolean("switchValue2", true)
        val default3 = sharedPref.getBoolean("switchValue3", true)
        val default4 = sharedPref.getBoolean("switchValue4", true)
        val editor = sharedPref.edit()

        sw1?.setChecked(default)
        sw2?.setChecked(default2)
        sw3?.setChecked(default3)
        sw4?.setChecked(default4)

        val response2 : String
        if(sw2?.isChecked == true)
        {
            response2 = "ON"
        }
        else response2 ="OFF"
        Toast.makeText(activity, response2,
                Toast.LENGTH_SHORT).show()


        sw1?.setOnCheckedChangeListener { _, isChecked ->
//            val response = if (isChecked) "ON" else "OFF"
            if (isChecked) {
                editor.putBoolean("switchValue", true).apply();
                Toast.makeText(getActivity(), "On", Toast.LENGTH_SHORT).show()
                val result1 = "ON"
                setFragmentResult("sw1Key", bundleOf("bundle1" to result1))
            } else {
                editor.putBoolean("switchValue", false).apply();
                Toast.makeText(getActivity(), "Off", Toast.LENGTH_SHORT).show()
                val result1 = "OFF"
                setFragmentResult("sw1Key", bundleOf("bundle1" to result1))
            }

        }

        sw2?.setOnCheckedChangeListener { _, isChecked ->
//            val response = if (isChecked) "ON" else "OFF"
            if (isChecked) {
                editor.putBoolean("switchValue2", true).apply();
                Toast.makeText(getActivity(), "On", Toast.LENGTH_SHORT).show()
            } else {
                editor.putBoolean("switchValue2", false).apply();
                Toast.makeText(getActivity(), "Off", Toast.LENGTH_SHORT).show()
            }

        }

        sw3?.setOnCheckedChangeListener { _, isChecked ->
//            val response = if (isChecked) "ON" else "OFF"
            if (isChecked) {
                editor.putBoolean("switchValue3", true).apply();
                Toast.makeText(getActivity(), "On", Toast.LENGTH_SHORT).show()
            } else {
                editor.putBoolean("switchValue3", false).apply();
                Toast.makeText(getActivity(), "Off", Toast.LENGTH_SHORT).show()
            }

        }

        sw4?.setOnCheckedChangeListener { _, isChecked ->
//            val response = if (isChecked) "ON" else "OFF"
            if (isChecked) {
                editor.putBoolean("switchValue4", true).apply();
                Toast.makeText(getActivity(), "On", Toast.LENGTH_SHORT).show()
            } else {
                editor.putBoolean("switchValue4", false).apply();
                Toast.makeText(getActivity(), "Off", Toast.LENGTH_SHORT).show()
            }

        }

//        sw2?.setOnCheckedChangeListener({ _, isChecked ->
//            val response = if (isChecked) "ON" else "OFF"
//            Toast.makeText(activity, response,
//                    Toast.LENGTH_SHORT).show()
//
//        })
//
//        sw3?.setOnCheckedChangeListener({ _, isChecked ->
//            val response = if (isChecked) "ON" else "OFF"
//            Toast.makeText(activity, response,
//                    Toast.LENGTH_SHORT).show()
//
//        })
//        sw4?.setOnCheckedChangeListener({ _, isChecked ->
//            val response = if (isChecked) "ON" else "OFF"
//            Toast.makeText(activity, response,
//                    Toast.LENGTH_SHORT).show()
//
//        })


    }
}