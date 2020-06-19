package com.kneipenrallye.kneipenrallye

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.MAP_TYPE_SATELLITE
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.Livemap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setMapType(MAP_TYPE_SATELLITE)

        // Add a marker in Regensburg and move the camera
        val RegensburgDom = LatLng(49.019587, 12.097515)

        mMap.setMyLocationEnabled(true);

        mMap.addMarker(MarkerOptions().position(RegensburgDom).title("Treffpunkt am Dom"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(RegensburgDom))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RegensburgDom, 17.0f))
    }

}


