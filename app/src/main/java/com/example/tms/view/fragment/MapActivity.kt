//package com.example.tms.view.activity
//
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.os.Bundle
//import android.view.View
//import android.widget.EditText
//import android.widget.ImageButton
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import com.example.tms.BuildConfig
//import com.example.tms.R
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.common.base.Optional
//import com.tomtom.online.sdk.common.location.LatLng
//import com.tomtom.online.sdk.map.*
//import com.tomtom.online.sdk.routing.OnlineRoutingApi
//import com.tomtom.online.sdk.routing.RoutingApi
//import com.tomtom.online.sdk.routing.RoutingException
//import com.tomtom.online.sdk.routing.route.*
//import com.tomtom.online.sdk.routing.route.information.FullRoute
//import com.tomtom.online.sdk.search.OnlineSearchApi
//import com.tomtom.online.sdk.search.SearchApi
//import com.tomtom.online.sdk.search.data.alongroute.AlongRouteSearchQueryBuilder
//import com.tomtom.online.sdk.search.data.alongroute.AlongRouteSearchResponse
//import com.tomtom.online.sdk.search.data.alongroute.AlongRouteSearchResult
//import com.tomtom.online.sdk.search.data.reversegeocoder.ReverseGeocoderSearchQueryBuilder
//import com.tomtom.online.sdk.search.data.reversegeocoder.ReverseGeocoderSearchResponse
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.observers.DisposableSingleObserver
//import io.reactivex.schedulers.Schedulers
//
//
//abstract class MapActivity : AppCompatActivity(), OnMapReadyCallback,
//    TomtomMapCallback.OnMapLongClickListener, com.tomtom.online.sdk.map.OnMapReadyCallback {
//    private lateinit var tomtomMap: TomtomMap
//    private var MAPS_API_KEY = "I8bisoI4hzRq69wRj24PCV7dmvUdPmtm"
//    private lateinit var searchApi: SearchApi
//    private lateinit var routingApi: RoutingApi
//    private var route: Route? = null
//    private var departurePosition: LatLng? = null
//    private var destinationPosition: LatLng? = null
//    private var wayPointPosition: LatLng? = null
//    private var departureIcon: Icon? = null
//    private var destinationIcon: Icon? = null
//    private var btnSearch: ImageButton? = null
//    private var editTextPois: EditText? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.navigate_page)
//        initTomTomServices()
//        initUIViews()
//        setupUIViewListeners()
//        disableSearchButtons()
//    }
//
//    abstract fun disableSearchButtons()
//
//    override fun onMapReady(tomtomMap: TomtomMap) {
//        this.tomtomMap = tomtomMap
//        this.tomtomMap.let {
//            it.isMyLocationEnabled = true
//            it.addOnMapLongClickListener(this)
//            it.markerSettings.setMarkersClustering(true)
////            it.markerSettings.markerBalloonViewAdapter = createCustomViewAdapter()
//        }
//
//
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        tomtomMap.onRequestPermissionsResult(requestCode, permissions, grantResults)
//    }
//
//    private fun initTomTomServices() {
//        val mapKeys = mapOf(
//            ApiKeyType.MAPS_API_KEY to MAPS_API_KEY
//        )
//        val mapProperties = MapProperties.Builder()
//            .keys(mapKeys)
//            .build()
//        val mapFragment = MapFragment.newInstance(mapProperties)
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.mapFragment, mapFragment)
//            .commit()
//        mapFragment.getAsyncMap(this)
//
//        searchApi = OnlineSearchApi.create(this, MAPS_API_KEY)
//        routingApi = OnlineRoutingApi.create(this, MAPS_API_KEY)
//    }
//
//    private fun clearMap() {
//        tomtomMap.clear()
//        departurePosition = null
//        destinationPosition = null
//        route = null
//    }
//
//
//    private fun initUIViews() {
//        departureIcon = Icon.Factory.fromResources(
//            this@MapActivity,
//            com.tomtom.online.sdk.map.R.drawable.ic_map_route_departure
//        )
//        destinationIcon = Icon.Factory.fromResources(
//            this@MapActivity,
//            com.tomtom.online.sdk.map.R.drawable.ic_map_route_destination
//        )
//        btnSearch = findViewById(R.id.btn_main_poisearch)
//        editTextPois = findViewById(R.id.edittext_main_poisearch)
//    }
//
//    private fun setupUIViewListeners() {
//        val searchButtonListener: View.OnClickListener = getSearchButtonListener()
//        btnSearch!!.setOnClickListener(searchButtonListener)
////        btn_main_poisearch.setOnClickListener(searchButtonListener)
//    }
//
//    @JvmName("getSearchButtonListener1")
//    private fun getSearchButtonListener(): View.OnClickListener {
//        return this.searchButtonListener
//    }
//
//    override fun onMapLongClick(latLng: LatLng) {
//        if (isDeparturePositionSet && isDestinationPositionSet) {
//            clearMap()
//        } else {
//            handleLongClick(latLng)
//        }
//    }
//
//    private fun handleLongClick(latLng: LatLng) {
//        searchApi.reverseGeocoding(
//            ReverseGeocoderSearchQueryBuilder(
//                latLng.latitude,
//                latLng.longitude
//            ).build()
//        )
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object : DisposableSingleObserver<ReverseGeocoderSearchResponse?>() {
//                override fun onSuccess(response: ReverseGeocoderSearchResponse) {
//                    processResponse(response)
//                }
//
//                override fun onError(e: Throwable) {
//                    handleApiError(e)
//                }
//
//                private fun processResponse(response: ReverseGeocoderSearchResponse) {
//                    if (response.hasResults()) {
//                        processFirstResult(response.addresses[0].position)
//                    } else {
//                        Toast.makeText(
//                            this@MapActivity,
//                            getString(R.string.geocode_no_results),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//
//                private fun processFirstResult(geocodedPosition: LatLng) {
//                    if (!isDeparturePositionSet) {
//                        setAndDisplayDeparturePosition(geocodedPosition)
//                    } else {
//                        destinationPosition = geocodedPosition
//                        tomtomMap.removeMarkers()
//                        drawRoute(departurePosition, destinationPosition)
//                    }
//                }
//
//                private fun setAndDisplayDeparturePosition(geocodedPosition: LatLng) {
//                    departurePosition = geocodedPosition
//                    createMarkerIfNotPresent(departurePosition, departureIcon)
//                }
//            })
//    }
//
//    private val isDestinationPositionSet: Boolean
//        get() {
//            return destinationPosition != null
//        }
//
//    private val isDeparturePositionSet: Boolean
//        get() {
//            return departurePosition != null
//        }
//
//    @SuppressLint("StringFormatInvalid")
//    private fun handleApiError(e: Throwable) {
//        Toast.makeText(
//            this@MapActivity,
//            getString(R.string.api_response_error, e.localizedMessage),
//            Toast.LENGTH_LONG
//        ).show()
//    }
//
//    private fun createRouteCalculationDescriptor(
//        routeDescriptor: RouteDescriptor,
//        wayPoints: Array<LatLng>?
//    ): RouteCalculationDescriptor? {
//        return if (wayPoints != null) RouteCalculationDescriptor.Builder()
//            .routeDescription(routeDescriptor)
//            .waypoints(listOf(*wayPoints)).build()
//        else RouteCalculationDescriptor.Builder()
//            .routeDescription(routeDescriptor).build()
//    }
//
//    private fun drawRoute(start: LatLng?, stop: LatLng?) {
//        wayPointPosition = null
//        drawRouteWithWayPoints(start, stop, null)
//    }
//
//    private fun createRouteSpecification(
//        start: LatLng,
//        stop: LatLng,
//        wayPoints: Array<LatLng>?
//    ): RouteSpecification? {
//        val routeDescriptor = RouteDescriptor.Builder()
//            .routeType(com.tomtom.online.sdk.routing.route.description.RouteType.FASTEST)
//            .build()
//        val routeCalculationDescriptor =
//            createRouteCalculationDescriptor(routeDescriptor, wayPoints)
//        return RouteSpecification.Builder(start, stop)
//            .routeCalculationDescriptor(routeCalculationDescriptor!!)
//            .build()
//    }
//
//    private fun drawRouteWithWayPoints(start: LatLng?, stop: LatLng?, wayPoints: Array<LatLng>?) {
//        val routeSpecification = createRouteSpecification(start!!, stop!!, wayPoints)
//        showDialogInProgress()
//
//        routingApi.planRoute(routeSpecification!!, object : RouteCallback {
//            override fun onSuccess(routePlan: RoutePlan) {
////                dismissDialogInProgress()
//                displayRoutes(routePlan.routes)
//                tomtomMap.displayRoutesOverview()
//            }
//
//            override fun onError(e: RoutingException) {
//                handleApiError(e)
//                clearMap()
//            }
//
//            private fun displayRoutes(routes: List<FullRoute>) {
//                for (fullRoute in routes) {
//                    route = tomtomMap.addRoute(
//                        RouteBuilder(
//                            fullRoute.getCoordinates()
//                        ).startIcon(departureIcon).endIcon(destinationIcon)
//                    )
//                }
//            }
//        })
//    }
//
//    private fun showDialogInProgress() {
//
//    }
//
//    private fun createMarkerIfNotPresent(position: LatLng?, icon: Icon?) {
//        val optionalMarker: Optional<Marker> = tomtomMap.findMarkerByPosition(position)
//        if (!optionalMarker.isPresent) {
//            tomtomMap.addMarker(
//                MarkerBuilder((position)!!)
//                    .icon(icon)
//            )
//        }
//    }
//
//    private val searchButtonListener: View.OnClickListener
//        get() {
//            return object : View.OnClickListener {
//                override fun onClick(v: View) {
//                    handleSearchClick(v)
//                }
//
//                private fun handleSearchClick(v: View) {
//                    if (isRouteSet) {
//                        val description: Optional<CharSequence> =
//                            Optional.fromNullable(v.contentDescription)
//                        if (description.isPresent) {
//                            editTextPois?.setText(description.get())
////                            deselectShortcutButtons()
//                            v.isSelected = true
//                        }
//                        if (isWayPointPositionSet) {
//                            tomtomMap.clear()
//                            drawRoute(departurePosition, destinationPosition)
//                        }
//                        val textToSearch: String = editTextPois?.text.toString()
//                        if (textToSearch.isNotEmpty()) {
//                            tomtomMap.removeMarkers()
//                            searchAlongTheRoute(route, textToSearch)
//                        }
//                    }
//                }
//
//                private val isRouteSet: Boolean
//                    get() {
//                        return route != null
//                    }
//
//                private val isWayPointPositionSet: Boolean
//                    get() {
//                        return wayPointPosition != null
//                    }
//
//                private fun searchAlongTheRoute(route: Route?, textToSearch: String) {
//                    val maxDetourTime = 1000
//                    val queryLimit = 10
//                    disableSearchButtons()
//                    showDialogInProgress()
//                    searchApi.alongRouteSearch(
//                        AlongRouteSearchQueryBuilder(
//                            textToSearch,
//                            route!!.coordinates,
//                            maxDetourTime
//                        )
//                            .withLimit(queryLimit)
//                            .build()
//                    )
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(object : DisposableSingleObserver<AlongRouteSearchResponse?>() {
//                            override fun onSuccess(response: AlongRouteSearchResponse) {
//                                displaySearchResults(response.results)
////                                dismissDialogInProgress()
////                                enableSearchButtons()
//                            }
//
//                            private fun displaySearchResults(results: List<AlongRouteSearchResult>) {
//                                if (results.isNotEmpty()) {
//                                    for (result: AlongRouteSearchResult in results) {
//                                        createAndDisplayCustomMarker(result.position, result)
//                                    }
//                                    tomtomMap.zoomToAllMarkers()
//                                } else {
//                                    Toast.makeText(
//                                        this@MapActivity,
//                                        String.format(
//                                            getString(R.string.no_search_results),
//                                            textToSearch
//                                        ),
//                                        Toast.LENGTH_LONG
//                                    ).show()
//                                }
//                            }
//
//                            private fun createAndDisplayCustomMarker(
//                                position: LatLng,
//                                result: AlongRouteSearchResult
//                            ) {
//                                val address: String = result.address.freeformAddress
//                                val poiName: String = result.poi.name
//                                val markerBalloonData = BaseMarkerBalloon().apply {
//                                    this.addProperty(getString(R.string.poi_name_key), poiName)
//                                    this.addProperty(getString(R.string.address_key), address)
//                                }
//                                val markerBuilder: MarkerBuilder = MarkerBuilder(position)
//                                    .markerBalloon(markerBalloonData)
//                                    .shouldCluster(true)
//                                tomtomMap.addMarker(markerBuilder)
//                            }
//
//                            override fun onError(e: Throwable) {
//                                handleApiError(e)
//                                handleApiError(e)
////                                enableSearchButtons()
//                            }
//                        })
//                }
//            }
//        }
//
////    private fun createCustomViewAdapter(): SingleLayoutBalloonViewAdapter {
////        return object : SingleLayoutBalloonViewAdapter(R.layout.marker_custom_balloon) {
////            override fun onBindView(view: View, marker: Marker, baseMarkerBalloon: BaseMarkerBalloon) {
////               view textview_balloon_poiname.text = baseMarkerBalloon.getStringProperty(applicationContext.getString(R.string.poi_name_key))
////                textview_balloon_poiaddress.text = baseMarkerBalloon.getStringProperty(applicationContext.getString(R.string.address_key))
////                btn_balloon_waypoint.setOnClickListener(object : View.OnClickListener {
////                    override fun onClick(v: View) {
////                        setWayPoint(marker)
////                    }
////
////                    private fun setWayPoint(marker: Marker) {
////                        wayPointPosition = marker.position
////                        tomtomMap.clearRoute()
////                        drawRouteWithWayPoints(departurePosition, destinationPosition, arrayOf(wayPointPosition!!))
////                        marker.deselect()
////                    }
////                })
////            }
////        }
////    }
//
//}
