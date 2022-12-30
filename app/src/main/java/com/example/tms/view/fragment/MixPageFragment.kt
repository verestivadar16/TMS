package com.example.tms.view.fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.R
import com.example.tms.adapter.MixPageAdapter
import com.example.tms.data.MixPageData
import com.example.tms.databinding.MixPageBinding

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
        val recyclerview = getView()?.findViewById<RecyclerView>(R.id.post_list)

        val bitmap0 = BitmapFactory.decodeResource(getResources(), R.drawable.golfr32);
        val bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.eventimage1);
        val bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.warningimage1);

        if (recyclerview != null) {
            recyclerview.layoutManager = LinearLayoutManager(getContext())
        }
        val data = ArrayList<MixPageData>()

        data.add(MixPageData(R.drawable.avatar_button, "Pasiunea ne uneste","Va invitam sambata 25.01.2023 incepand cu ora 13:00, locatie:..",bitmap1, "3"))

        data.add(MixPageData( R.drawable.tire,
            R.drawable.avatar4,
            "Kiss Elemer ",
            "Anvelope 195X65XR18",
            "Nearly new bought them last year...",
            "230 LEI",
            "2"))
        data.add(MixPageData( R.drawable.tire,
            R.drawable.avatar,
            "Lakatos Brendon",
            "Anvelope 195X65XR18",
            "Nearly new bought them last year...",
            "230 LEI",
            "2"))



        data.add(MixPageData("Tamas","got my new car",bitmap0, R.drawable.avatar_button, "1"))
        data.add(MixPageData(R.drawable.avatar_button, "Pasiunea ne uneste","Va invitam sambata 15.10.2022 incepand cu ora 13:00, locatie:..",bitmap1, "3"))
        data.add(MixPageData(R.drawable.avatar_button, "Traffic Jam Warning!",bitmap2, "4"))
        data.add(MixPageData("Tamas","got my new car",bitmap0, R.drawable.avatar_button, "1"))
        data.add(MixPageData(R.drawable.tire,
            R.drawable.avatar_button,
            "Kiss Elemer ",
            "Anvelope 195X65XR18",
            "Nearly new bought them last year...",
            "230 LEI",
            "2"))
        val bitmap = BitmapFactory.decodeResource(getResources(),
            R.drawable.audib5);
        data.add(MixPageData("Tamas","got my new car",bitmap, R.drawable.avatar_button, "1"))
        data.add(MixPageData("Balazs","got my new car",bitmap, R.drawable.avatar_button, "1"))




        val adapter = context?.let { MixPageAdapter(it, data) }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }

    }
}