package com.example.tms.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.tms.R
import com.example.tms.data.FriendListData
import com.example.tms.view.fragment.ChatPageFragment

class FriendListAdapter(private val context: Activity, private val arrayList: ArrayList<FriendListData>) :
        ArrayAdapter<FriendListData>(context, R.layout.item_contact, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_contact, null)

        val imageView: ImageView = view.findViewById(R.id.iv_image)
        val username: TextView = view.findViewById(R.id.tv_name)

        imageView.setImageBitmap(arrayList[position].profImage)
        username.text = arrayList[position].username

        val currentUser = arrayList[position]

        view.setOnClickListener(View.OnClickListener {
            val intent = Intent(context,ChatPageFragment::class.java)

            intent.putExtra("name",currentUser.username)
            intent.putExtra("uid",arrayList[position].toString())

        })

        return view
    }
}