package com.example.tms.view.fragment

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
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
//    private lateinit var REQUEST_LOCATION
    private lateinit var binding: NavigationPageBinding
    private lateinit var mMap: GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Manifest.permission.ACCESS_FINE_LOCATION
        PackageManager.PERMISSION_GRANTED

        binding = NavigationPageBinding.inflate(layoutInflater)
//        DirectionAPI.openGoogleMapsNavigationFromAToB(this, -34.0, 151.0, -30.0, 150.0)

        binding.addEventButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_navigation_to_ad_event_page)
        })
        binding.navigationAvatar.setOnClickListener({
            findNavController().navigate(R.id.action_navigation_to_profile_page)
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == AppConstant.LOCATION_PERMISSION) {

            if (permissions.isEmpty() && grantResults.isEmpty()) {
                return
            }

            if (permissions[0] ==
                Manifest.permission.ACCESS_FINE_LOCATION &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                // do something which you want to do
                // when permission granted
            }
            else if (permissions[0] ==
                Manifest.permission.ACCESS_FINE_LOCATION &&
                grantResults[0] == PackageManager.PERMISSION_DENIED
            ) {
                // if permission denied then check whether never ask
                // again is selected or not by making use of
                !ActivityCompat.shouldShowRequestPermissionRationale(
                    requireActivity(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }

}

















