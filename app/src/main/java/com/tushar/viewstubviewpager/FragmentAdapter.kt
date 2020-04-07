package com.tushar.viewstubviewpager

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val titles = arrayOf("Fragment 1", "Fragment 2", "Fragment 3", "Fragment 4", "Fragment 5")

    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        var f: androidx.fragment.app.Fragment? = null
        when(position){
            0 -> f = Heavy1Fragment()
            1 -> f = Heavy2Fragment()
            2 -> f = Heavy3Fragment()
            3 -> f = Heavy4Fragment()
            4 -> f = Heavy5Fragment()
        }
        val bundle = Bundle()
        bundle.putString("title", titles[position])
        f!!.arguments = bundle
        return f
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}