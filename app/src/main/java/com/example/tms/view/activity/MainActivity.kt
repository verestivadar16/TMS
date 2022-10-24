package com.example.tms.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tms.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setBackgroundDrawableResource(R.drawable.bacgroundtexture2)
        setContentView(R.layout.insta_post)
        println("Hello");
    }
}