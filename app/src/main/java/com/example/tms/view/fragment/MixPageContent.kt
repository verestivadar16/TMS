package com.example.tms.view.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        val editor = sharedPref.edit()

        sw1?.setChecked(default)
        sw2?.setChecked(default)
        sw3?.setChecked(default)
        sw4?.setChecked(default)

        val response2 : String
        if(sw2?.isChecked == true)
        {
            response2 = "ON"
        }
        else response2 ="OFF"
        Toast.makeText(activity, response2,
                Toast.LENGTH_SHORT).show()


        sw1?.setOnCheckedChangeListener({ _, isChecked ->
            val response = if (isChecked) "ON" else "OFF"
            if(isChecked){
                editor.putBoolean("switchValue", true).commit();
                Toast.makeText(getActivity(),"On",Toast.LENGTH_SHORT).show()
            }

            else{
                editor.putBoolean("switchValue", false).commit();
                Toast.makeText(getActivity(),"Off",Toast.LENGTH_SHORT).show()
            }

        })

        sw2?.setOnCheckedChangeListener({ _, isChecked ->
            val response = if (isChecked) "ON" else "OFF"
            Toast.makeText(activity, response,
                    Toast.LENGTH_SHORT).show()

        })
        sw2?.setOnCheckedChangeListener({ _, isChecked ->
            val response = if (isChecked) "ON" else "OFF"
            Toast.makeText(activity, response,
                    Toast.LENGTH_SHORT).show()

        })
        sw3?.setOnCheckedChangeListener({ _, isChecked ->
            val response = if (isChecked) "ON" else "OFF"
            Toast.makeText(activity, response,
                    Toast.LENGTH_SHORT).show()

        })
        sw4?.setOnCheckedChangeListener({ _, isChecked ->
            val response = if (isChecked) "ON" else "OFF"
            Toast.makeText(activity, response,
                    Toast.LENGTH_SHORT).show()

        })


    }
}