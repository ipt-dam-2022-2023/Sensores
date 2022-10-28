package com.example.android.exemplofragmentos

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.exemplofragmentos.fragmentos.Fragment1
import com.example.android.exemplofragmentos.fragmentos.Fragment2
import com.example.android.exemplofragmentos.fragmentos.Fragment3

class MyViewPagerAdapter : FragmentStateAdapter {

    private var parent: AppCompatActivity

    constructor(parent: AppCompatActivity) : super(parent) {
        this.parent = parent
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return Fragment1(parent)
            1 -> return Fragment2()
            2 -> return Fragment3(parent)
            else -> return Fragment1(parent)
        }
    }
}