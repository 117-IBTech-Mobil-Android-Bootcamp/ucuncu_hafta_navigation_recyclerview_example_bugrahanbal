package com.balbugrahan.week3.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.balbugrahan.week3.R

class FragmentSplash : Fragment() {



    private val DELAY  :  Long = 2 * 1000 //Splash delay time



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_splash, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            //val action = FragmentSplashDirections.actionFragmentSplashToNavigationBattle()
            //Navigation.findNavController(requireActivity(),R.id.nav_host_fragment_container).navigate(action)
            //findNavController().navigate(R.id.action_fragmentSplash_to_navigation_battle)
            //findNavController().popBackStack(R.id.navigation_battle,true)

            //Navigation control for direction, we settting direction after splash
            findNavController().navigate(FragmentSplashDirections.actionFragmentSplashToNavigationBattle())

        }, DELAY)


        return root
    }
}