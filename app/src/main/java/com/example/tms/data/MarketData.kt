package com.example.tms.data

import android.graphics.Bitmap

data class MarketData(val productimage: Bitmap,
                      val sellerimage: Bitmap,
                      val sellername: String,
                      val productname: String,
                      val productdescription: String,
                      val location: String,
                      val price: String)
