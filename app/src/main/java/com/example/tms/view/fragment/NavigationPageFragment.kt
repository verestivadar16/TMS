package com.example.tms.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.NavigationPageBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


//AIzaSyCXPxzAnc8icMuBAYqWnbtw5S2eaT5opMg

class NavigationPageFragment : Fragment(), OnMapReadyCallback {
    private lateinit var binding: NavigationPageBinding
    private lateinit var mMap: GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = NavigationPageBinding.inflate(layoutInflater)
//        DirectionAPI.openGoogleMapsNavigationFromAToB(this, -34.0, 151.0, -30.0, 150.0)

        binding.addEventButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_navigation_to_ad_event_page)
        })
//        onMapReady(mMap)
        return binding.root
    }


    override fun onMapReady(googleMap: GoogleMap) {
        var mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(
            MarkerOptions()
            .position(sydney)
            .title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

}
















