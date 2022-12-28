package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.R
import com.example.tms.databinding.MarketPageBinding


class MarketPageFragment : Fragment() {

    private lateinit var binding: MarketPageBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MarketPageBinding.inflate(layoutInflater)
        binding.profileButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_marketpage_to_profilpage)
        })
        binding.imageButtonBack.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_marketpage_to_homepage)
        })
        binding.searchButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_marketpage_to_searchitempage)
        })
        binding.newItemButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_marketpage_to_newlistingpage)
        })

        return binding.root
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val recyclerview = getView()?.findViewById<RecyclerView>(R.id.market_items_list)
        if (recyclerview != null) {
            recyclerview.layoutManager = LinearLayoutManager(getContext())
        }
        val data = ArrayList<MarketData>()
        data.add(
            MarketData(
                R.drawable.tire,
                R.drawable.avatar4,
                "Kiss Elemer ",
                "Anvelope 195X65XR18",
                "Nearly new bought them last year...",
                "230 LEI"
            )
        )
        data.add(
            MarketData(
                R.drawable.tire,
                R.drawable.avatar,
                "Lakatos Brendon",
                "Anvelope 195X65XR18",
                "Nearly new bought them last year...",
                "230 LEI"
            )
        )
        data.add(
            MarketData(
                R.drawable.tire,
                R.drawable.avatar_button,
                "Kiss Elemer ",
                "Anvelope 195X65XR18",
                "Nearly new bought them last year...",
                "230 LEI"
            )
        )

        val adapter = MarketAdaptor(data)
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
        if (recyclerview != null) {
            recyclerview.adapter = adapter
        }
        adapter.onItemClick = {
            findNavController().navigate(R.id.action_marketpage_to_chatpage)
        }
    }
}