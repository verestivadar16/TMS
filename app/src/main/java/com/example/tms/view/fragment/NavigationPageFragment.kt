//package com.example.tms.view.fragment
//
//import android.R
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.replace
//import androidx.lifecycle.viewmodel.CreationExtras.Empty.map
//import androidx.navigation.fragment.findNavController
//import com.example.tms.BuildConfig
//import com.example.tms.BuildConfig.MAP_API_KEY
//import com.example.tms.databinding.NavigationPageBinding
//import com.google.android.gms.maps.MapFragment
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.tomtom.online.sdk.map.ApiKeyType
//import com.tomtom.online.sdk.map.MapProperties
//import com.tomtom.online.sdk.map.TomtomMap
//import com.tomtom.online.sdk.map.TomtomMapCallback
//
////AIzaSyCXPxzAnc8icMuBAYqWnbtw5S2eaT5opMg
//
//abstract class NavigationPageFragment : Fragment(),OnMapReadyCallback,TomtomMapCallback.OnMapLongClickListener{
//    private val APIKEY = "I8bisoI4hzRq69wRj24PCV7dmvUdPmtm"
//    private lateinit var binding: NavigationPageBinding
//
//    private lateinit var locationEngine :
//    private lateinit var tomtomMap: TomtomMap
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = NavigationPageBinding.inflate(layoutInflater)
////        binding.homeButton.setOnClickListener(View.OnClickListener {
////        findNavController().navigate(R.id.action_navigation_to_instapostpage)
////        })
////        DirectionAPI.openGoogleMapsNavigationFromAToB(this, -34.0, 151.0, -30.0, 150.0)
//        //Add map fragment
//
//
//        val mapOptions = MapOptions(mapKey = APIKEY)
//        val mapFragment = MapFragment.newInstance(mapOptions)
//        getParentFragmentManager()
//            .beginTransaction().replace(R.id.map_container, mapFragment)
//            .commit()
//
//
//
//
//        binding.addEventButton.setOnClickListener(View.OnClickListener {
////            findNavController().navigate(R.id.action_navigation_to_ad_event_page)
//        })
//        return binding.root
//    }
//
//    private fun enableUserLocation(){
//        locationEngine = AndroidLocationEngine(context = this)
//    }
//
//    private fun initTomTomServices() {
//        val mapKeys = mapOf(
//            ApiKeyType.MAPS_API_KEY to BuildConfig.MAP_API_KEY
//        )
//        val mapProperties = MapProperties.Builder()
//            .keys(mapKeys)
//            .build()
//        val mapFragment = MapFragment.newInstance()
//        parentFragmentManager
//            .beginTransaction()
//            .replace(R.id.mapFragment, mapFragment)
//            .commit()
//        mapFragment.getAsyncMap(this)
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
