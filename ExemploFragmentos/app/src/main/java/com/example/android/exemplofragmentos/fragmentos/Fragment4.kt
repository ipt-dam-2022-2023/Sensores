package com.example.android.exemplofragmentos.fragmentos


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.android.exemplofragmentos.R


class Fragment4 : Fragment {

    private var parent: AppCompatActivity

    constructor(parent: AppCompatActivity) {
        this.parent = parent
    }


    lateinit var smm: SensorManager
    lateinit var sensor: List<Sensor>
    lateinit var lv: ListView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View = inflater.inflate(R.layout.fragment_4, container, false)


        smm = parent.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        lv = view.findViewById(R.id.listView) as ListView
        sensor = smm.getSensorList(Sensor.TYPE_ALL)
        lv.adapter =  ArrayAdapter<Sensor>(parent, android.R.layout.simple_list_item_1, sensor)

        return view
    }


}