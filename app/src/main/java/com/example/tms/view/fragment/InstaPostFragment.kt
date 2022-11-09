package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tms.databinding.InstaPostBinding

class InstaPostFragment: Fragment() {
    private lateinit var bindig: InstaPostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindig = InstaPostBinding.inflate(layoutInflater)
        return bindig.root
    }
}