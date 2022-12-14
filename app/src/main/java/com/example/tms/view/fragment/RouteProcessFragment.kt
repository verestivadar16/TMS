//package com.example.tms.view.fragment
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import com.example.tms.R
//
//private const val ARG_ADDRESS = "address"
//
//class RouteProcessFragment {
//    // the fragment initialization parameter ARG_ADDRESS
//
//
//    /**
//     * A simple [Fragment] subclass.
//     * Use the [RouteProcessFragment.newInstance] factory method to
//     * create an instance of this fragment.
//     */
//    class RouteProcessFragment(place: Place, navigationInterface: NavigateOptionsInterface) :
//        Fragment() {
//        private var address: String? = null
//        private var listener: NavigateOptionsInterface = navigationInterface
//        private var destination: Place = place
//
//        interface NavigateOptionsInterface {
//            fun onNavigate(destination: GeoPoint)
//            fun onCancel()
//            fun onRoute(destination: GeoPoint)
//            fun removeRoute()
//        }
//
//        fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            arguments?.let {
//                address = it.getString(ARG_ADDRESS)
//            }
//        }
//
//        override fun onCreateView(
//            inflater: LayoutInflater, container: ViewGroup?,
//            savedInstanceState: Bundle?
//        ): View? {
//            // Inflate the layout for this fragment
//            val view: ViewGroup =
//                inflater.inflate(R.layout.fragment_route_process, container, false) as ViewGroup
//            val addressField: TextView = view.findViewById(R.id.address)
//            addressField.setText(address)
//
//            val navigateButton = view.findViewById<Button>(R.id.navigateButton)
//            navigateButton.setOnClickListener {
//                listener.onNavigate(destination.position)
//            }
//
//            val routeButton = view.findViewById<Button>(R.id.routeButton)
//            routeButton.setOnClickListener {
//                navigateButton.visibility = View.VISIBLE
//                routeButton.visibility = View.GONE
//                listener.onRoute(destination.position)
//            }
//
//            val cancelButton = view.findViewById<Button>(R.id.cancelButton)
//            cancelButton.setOnClickListener {
//                if (navigateButton.visibility == View.VISIBLE) {
//                    navigateButton.visibility = View.GONE
//                    routeButton.visibility = View.VISIBLE
//                    listener.removeRoute()
//                } else {
//                    listener.onCancel()
//                }
//            }
//
//            return view
//        }
//
//        companion object {
//
//            @JvmStatic
//            fun newInstance(place: Place, listener: NavigateOptionsInterface) =
//                RouteProcessFragment(place, listener).apply {
//                    arguments = Bundle().apply {
//                        putString(ARG_ADDRESS, place.address)
//                    }
//                }
//        }
//    }