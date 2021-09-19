package com.balbugrahan.week3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.balbugrahan.week3.R

class FragmentDecklerim : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_decklerim, container, false)
        //Only we are creating view this page not func
        return root
    }
}