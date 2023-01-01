package com.example.tms.view.fragment

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.R
import com.example.tms.adapter.MixPageAdapter
import com.example.tms.data.MixPageData
import com.example.tms.databinding.MixPageBinding
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.tms.data.ContentConstants

class MixPageFragment : Fragment() {
    private lateinit var binding: MixPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MixPageBinding.inflate(layoutInflater)
        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            getActivity()?.onBackPressed()
        })
        binding.inboxButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_mix_page_to_inboxpage)
        })
        binding.profileButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_mix_page_to_profilepage)
        })
        binding.searchButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_mix_page_to_mix_content_page)
        })
        return binding.root
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        var default = sharedPref.getBoolean("switchValue", true)
        val default2 = sharedPref.getBoolean("switchValue2", true)
        val default3 = sharedPref.getBoolean("switchValue3", true)
        val default4 = sharedPref.getBoolean("switchValue4", true)
        val editor = sharedPref.edit()

        loadLayout(default.toString(), default2.toString(), default3.toString(), default4.toString())

        setFragmentResultListener("switches") { key, bundle ->
            // Any type can be passed via to the bundle
            var response = bundle.getString("switch1")
            var response2 = bundle.getString("switch2")
            var response3 = bundle.getString("switch3")
            var response4 = bundle.getString("switch4")

            // Do something with the result...
            editor.putBoolean("switchValue", response.toBoolean()).apply()
            editor.putBoolean("switchValue2", response2.toBoolean()).apply()
            editor.putBoolean("switchValue3", response3.toBoolean()).apply()
            editor.putBoolean("switchValue4", response4.toBoolean()).apply()
            loadLayout(response!!, response2!!, response3!!, response4!!)
        }
    }

    private fun loadLayout(response : String, response2 : String, response3 : String, response4 : String)
    {
        val recyclerview = getView()?.findViewById<RecyclerView>(R.id.post_list)

        val bitmap0 = BitmapFactory.decodeResource(getResources(), R.drawable.golfr32);
        val bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.eventimage1);
        val bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.warningimage1);

        if (recyclerview != null) {
            recyclerview.layoutManager = LinearLayoutManager(getContext())
        }
        val data = ArrayList<MixPageData>()

        data.add(MixPageData(R.drawable.avatar_button, "Pasiunea ne uneste","Va invitam sambata 25.01.2023 incepand cu ora 13:00, locatie:..",bitmap1, "3",response3))

        data.add(MixPageData( R.drawable.tire,
            R.drawable.avatar4,
            "Kiss Elemer ",
            "Anvelope 195X65XR18",
            "Nearly new bought them last year...",
            "230 LEI",
            "2",response2))
        data.add(MixPageData( R.drawable.tire,
            R.drawable.avatar,
            "Lakatos Brendon",
            "Anvelope 195X65XR18",
            "Nearly new bought them last year...",
            "230 LEI",
            "2",response2))

        data.add(MixPageData("Tamas","got my new car",bitmap0, R.drawable.avatar_button, "1",response))
        data.add(MixPageData(R.drawable.avatar_button, "Pasiunea ne uneste","Va invitam sambata 15.10.2022 incepand cu ora 13:00, locatie:..",bitmap1, "3",response3))
        data.add(MixPageData(R.drawable.avatar_button, "Traffic Jam Warning!",bitmap2, "4",response4))
        data.add(MixPageData("Tamas","got my new car",bitmap0, R.drawable.avatar_button, "1",response))
        data.add(MixPageData(R.drawable.tire,
            R.drawable.avatar_button,
            "Kiss Elemer ",
            "Anvelope 195X65XR18",
            "Nearly new bought them last year...",
            "230 LEI",
            "2",response2))
        val bitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.audib5);
        data.add(MixPageData("Tamas","got my new car",bitmap, R.drawable.avatar_button, "1",response))
        data.add(MixPageData("Balazs","got my new car",bitmap, R.drawable.avatar_button, "1",response))

        val adapter = context?.let { MixPageAdapter(it, data) }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
    }
}