package com.example.android.exemplofragmentos.fragmentos

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.android.exemplofragmentos.R



class Fragment1 : Fragment, LocationListener {

    private var parent: AppCompatActivity

    constructor(parent: AppCompatActivity) {
        this.parent = parent
    }

    private lateinit var locationManager: LocationManager
    private lateinit var txtGPSLocation: TextView
    private val locationPermissionCode = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_1, container, false)

        val button: Button = view.findViewById(R.id.btnGetLocation)
        button.setOnClickListener {
            getLocation()
        }

        return view
    }

    private fun getLocation() {
        locationManager = parent.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(parent, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(parent, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), locationPermissionCode)
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }

    override fun onLocationChanged(location: Location) {
        txtGPSLocation = parent.findViewById(R.id.txtGPSLocation)
        txtGPSLocation.text = "Lat: " + location.latitude + " , Long: " + location.longitude

    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == locationPermissionCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(parent, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(parent, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

}