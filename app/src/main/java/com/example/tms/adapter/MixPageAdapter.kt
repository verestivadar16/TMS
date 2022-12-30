package com.example.tms.adapter

import android.content.Context
import android.graphics.Bitmap
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
    val Insta_Post = 1
    val Market_Post = 2
    val Event_Post = 3
    val Warning_Post = 4

    val insta_on = 1
    val market_on = 1
    val event_on = 1
    val warning_on = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> {
                val view: View =
                        LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
                return InstaPostViewHolder(view)
            }

            2 -> {
                //inflate marketpost
                val view: View =
                        LayoutInflater.from(context).inflate(R.layout.market_item_view, parent, false)
                return MarketPostViewHolder(view)
            }

            3 -> {
                //inflate Event_Post
                val view: View =
                        LayoutInflater.from(context).inflate(R.layout.event_item, parent, false)
                return EventPostViewHolder(view)
            }

            else -> {
                //inflate Warning_Post
                val view: View =
                        LayoutInflater.from(context).inflate(R.layout.traffic_info_item, parent, false)
                return WarningPostViewHolder(view)
            }

        }

//        if (viewType == 2) {
//            //inflate marketpost
//            val view: View =
//                LayoutInflater.from(context).inflate(R.layout.market_item_view, parent, false)
//            return MarketPostViewHolder(view)
//        } else if (viewType == 1){
//            //inflate instapost
//            val view: View =
//                LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
//            return InstaPostViewHolder(view)
//        } else if (viewType == 3){
//            //inflate Event_Post
//            val view: View =
//                LayoutInflater.from(context).inflate(R.layout.event_item, parent, false)
//            return EventPostViewHolder(view)
//        } else {
//            //inflate Warning_Post
//            val view: View =
//                LayoutInflater.from(context).inflate(R.layout.traffic_info_item, parent, false)
//            return WarningPostViewHolder(view)
//        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentPost = postList[position]
        when (holder.javaClass) {

            MarketPostViewHolder::class.java -> {
                val viewHolder = holder as MarketPostViewHolder

                currentPost.productimage?.let { holder.prductimage.setImageResource(it) }
                currentPost.sellerimage?.let { holder.sellerimage.setImageResource(it) }
                holder.sellername.text = currentPost.sellername
                holder.productname.text = currentPost.productname
                holder.productdescription.text = currentPost.productdescription
                holder.price.text = currentPost.price
            }

            InstaPostViewHolder::class.java -> {
                val viewHolder = holder as InstaPostViewHolder

                currentPost.profImageId?.let { holder.profImageid.setImageResource(it) }
                currentPost.imageId?.let { holder.imageId.setImageBitmap(it) }
                holder.personName.text = currentPost.personName
                holder.postDescription.text = currentPost.postDescription
            }

            EventPostViewHolder::class.java -> {
                val viewHolder = holder as EventPostViewHolder

                currentPost.organiserPic?.let { holder.organiserPic.setImageResource(it) }
                holder.organiserName.text = currentPost.organiserName
                holder.eventDescription.text = currentPost.eventDescription
                currentPost.locationImage?.let { holder.locationImage.setImageBitmap(it) }
            }

            WarningPostViewHolder::class.java -> {
                val viewHolder = holder as WarningPostViewHolder

                currentPost.warningIcon?.let { holder.warningIcon.setImageResource(it) }
                holder.warningName.text = currentPost.warningName
                currentPost.warningImage?.let { holder.warningImage.setImageBitmap(it) }
            }
        }


//        if (holder.javaClass ==MarketPostViewHolder::class.java) {
//
//
//            val viewHolder = holder as MarketPostViewHolder
//
//            currentPost.productimage?.let { holder.prductimage.setImageResource(it) }
//            currentPost.sellerimage?.let { holder.sellerimage.setImageResource(it) }
//            holder.sellername.text = currentPost.sellername
//            holder.productname.text = currentPost.productname
//            holder.productdescription.text = currentPost.productdescription
//            holder.price.text = currentPost.price
//
//
//        } else {
//
//            val viewHolder = holder as InstaPostViewHolder
//
//            currentPost.profImageId?.let { holder.profImageid.setImageResource(it) }
//            currentPost.imageId?.let{holder.imageId.setImageBitmap(it)}
//            holder.personName.text = currentPost.personName
//            holder.postDescription.text = currentPost.postDescription
//
//        }


    }

    override fun getItemViewType(position: Int): Int {
        val currentPost = postList[position]

        when (currentPost.postTypeID) {
            "1" -> {
                return Insta_Post
            }

            "2" -> {
                return Market_Post
            }

            "3" -> {
                return Event_Post
            }

            "4" -> {
                return Warning_Post
            }

            else -> {
                return Insta_Post
            }
        }

//        if (currentPost.postTypeID == "2") {
//            return Market_Post
//        } else if (currentPost.postTypeID == "1"){
//            return Insta_Post
//        } else if (currentPost.postTypeID == "3") {
//            return Event_Post
//        } else return Warning_Post
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

    class EventPostViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var organiserPic: ImageView = itemView.findViewById(R.id.organiserPic)
        var organiserName: TextView = itemView.findViewById(R.id.organiserName)
        var eventDescription: TextView = itemView.findViewById(R.id.eventDescription)
        var locationImage: ImageView = itemView.findViewById(R.id.locationImage)

    }

    class WarningPostViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        var warningIcon: ImageView = itemView.findViewById(R.id.warningIcon)
        var warningName: TextView = itemView.findViewById(R.id.warningName)
        var warningImage: ImageView = itemView.findViewById(R.id.warningImage)

    }

}
