package com.example.tms.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tms.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.view.fragment.ConversationViewModel
import com.example.tms.view.fragment.CustomAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inbox_page)
        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.conversation_list)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ConversationViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(ConversationViewModel(R.drawable.avatar, "Item " + i,"igen","12:00"))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }

}