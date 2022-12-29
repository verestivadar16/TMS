package com.example.tms.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms.R
import com.example.tms.data.MixPageData

class MixPageAdapter(val context: Context, val postList: ArrayList<MixPageData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val Insta_Post = 1;
    val Market_Post = 2;
    val on = 1;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 2) {
            //inflate marketpost
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.market_item_view, parent, false)
            return MarketPostViewHolder(view)
        } else {
            //inflate instapost
            val view: View =
                LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            return InstaPostViewHolder(view)
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentPost = postList[position]
        if (holder.javaClass ==MarketPostViewHolder::class.java) {


            val viewHolder = holder as MarketPostViewHolder

            currentPost.productimage?.let { holder.prductimage.setImageResource(it) }
            currentPost.sellerimage?.let { holder.sellerimage.setImageResource(it) }
            holder.sellername.text = currentPost.sellername
            holder.productname.text = currentPost.productname
            holder.productdescription.text = currentPost.productdescription
            holder.price.text = currentPost.price


        } else {

            val viewHolder = holder as InstaPostViewHolder

            currentPost.profImageId?.let { holder.profImageid.setImageResource(it) }
            currentPost.imageId?.let{holder.imageId.setImageBitmap(it)}
            holder.personName.text = currentPost.personName
            holder.postDescription.text = currentPost.postDescription

        }


    }

    override fun getItemViewType(position: Int): Int {
        val currentPost = postList[position]


        if (currentPost.postTypeID == "2") {
            return Market_Post
        } else {
            return Insta_Post
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }


    class MarketPostViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val prductimage: ImageView = itemView.findViewById(R.id.product_icon)
        val sellerimage: ImageView = itemView.findViewById(R.id.seller_icon)
        val sellername: TextView = itemView.findViewById(R.id.seller_name)
        val productname: TextView = itemView.findViewById(R.id.product_name)
        val productdescription: TextView = itemView.findViewById(R.id.product_description)
        val price: TextView = itemView.findViewById(R.id.price)

    }

    class InstaPostViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val personName: TextView = itemView.findViewById(R.id.personName)
        val postDescription: TextView = itemView.findViewById(R.id.postDesciption)
        val imageId: ImageView = itemView.findViewById(R.id.postImage)
        val profImageid: ImageView = itemView.findViewById(R.id.profilePic)

    }

}
