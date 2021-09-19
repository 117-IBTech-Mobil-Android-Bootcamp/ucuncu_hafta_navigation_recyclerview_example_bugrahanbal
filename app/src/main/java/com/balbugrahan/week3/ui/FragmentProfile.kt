package com.balbugrahan.week3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.balbugrahan.week3.R
import kotlinx.android.synthetic.main.fragment_profile.*

class FragmentProfile : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_profile, container, false)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //we are setting for direction, when click 'pen icon' you are going up avatar selection page
        imageViewEdit.setOnClickListener {
            val action =FragmentProfileDirections.actionNavigationProfileToFragmentProfileDetails()
            Navigation.findNavController(view).navigate(action)



        }

    }
}