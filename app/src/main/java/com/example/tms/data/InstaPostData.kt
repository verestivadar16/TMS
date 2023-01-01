package com.example.tms.data

import android.graphics.Bitmap
import java.util.Date

data class InstaPostData(
    var name: String,
    var postDescription: String,
    var imageId: Bitmap,
    var profImageId: Bitmap,
//    var nrLikes: Int,
//    var date: Date
)
