package com.example.tms.view.fragment

import android.Manifest
import android.app.AlertDialog
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tms.R
import com.example.tms.databinding.NavigationPageBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.OnCompleteListener
import kotlin.system.exitProcess


//AIzaSyCXPxzAnc8icMuBAYqWnbtw5S2eaT5opMg

class NavigationPageFragment : Fragment(), OnMapReadyCallback {
//    private lateinit var REQUEST_LOCATION
    private lateinit var binding: NavigationPageBinding
    private lateinit var mMap: GoogleMap
    private lateinit var locationManager: LocationManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NavigationPageBinding.inflate(layoutInflater)
        Log.d("TAG"," vagyok")
        val alertDialog: AlertDialog
        val permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                Log.d("TAG","bent vagyok")
            }
            else {
                Log.d("TAG","kint vagyok")
                val builder = AlertDialog.Builder(context)
                builder.setTitle("You cant access the maps")
                builder.setMessage("You have to allow your location.")

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    Toast.makeText(context,
                        android.R.string.yes, Toast.LENGTH_SHORT).show()
                    Manifest.permission.ACCESS_FINE_LOCATION
                             }

                builder.setNegativeButton(android.R.string.no) { dialog, which ->
                    Toast.makeText(context,
                        android.R.string.no, Toast.LENGTH_SHORT).show()
                    exitProcess(1)
                }
                builder.show()

            }
        }

        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)




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



}

















