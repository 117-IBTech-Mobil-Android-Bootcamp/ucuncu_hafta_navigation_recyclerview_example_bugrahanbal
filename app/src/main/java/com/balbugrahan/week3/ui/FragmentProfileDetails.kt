package com.balbugrahan.week3.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.balbugrahan.week3.R
import com.balbugrahan.week3.model.AvatarData.Companion.ImageData
import com.balbugrahan.week3.ui.adapter.Adapter
import kotlinx.android.synthetic.main.fragment_profile_details.*
import java.io.Serializable


class FragmentProfileDetails : Fragment() ,Serializable{

    private lateinit var adapter1: Adapter
    private var layoutManager1 : GridLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Back Button Click
        backButton.setOnClickListener(View.OnClickListener {

            val action = FragmentProfileDetailsDirections.actionFragmentProfileDetailsToNavigationProfile()
            Navigation.findNavController(view).navigate(action)

        })

        //ADAPTER MANAGER
        adapter1 = Adapter(ImageData())
        //Layout manager setting
        //Recyclerview we are customing layout
        layoutManager1 = GridLayoutManager(context, 3)
        layoutManager1!!.orientation = LinearLayoutManager.VERTICAL
        layoutManager1!!.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter1.getItemViewType(position)) {
                    Adapter.TITLE_ROW ->3 //if we are in title row , row collapse 3 block and visible for one row
                    Adapter.AVATAR_ROW -> 1
                    else -> 0
                }
            }
        }

        //rcyler and layout setting
        recyclerview.layoutManager = layoutManager1
        //rcyler and adapter setting
        recyclerview.adapter = adapter1


    }


}