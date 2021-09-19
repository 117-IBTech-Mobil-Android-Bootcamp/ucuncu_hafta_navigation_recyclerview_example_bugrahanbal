package com.balbugrahan.week3

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Bottom Navigation Matching Layout
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        //val appBarConfiguration = AppBarConfiguration(setOf(
        //R.id.navigation_battle, R.id.navigation_decklerim, R.id.navigation_profile))
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Bottom NavBar setting for Visible or Gone
        //We should control navbar in activity because of fragments
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.fragmentSplash -> nav_view.visibility = View.GONE
                R.id.navigation_battle -> nav_view.visibility = View.VISIBLE
                R.id.navigation_decklerim -> nav_view.visibility = View.VISIBLE
                R.id.navigation_profile -> nav_view.visibility = View.VISIBLE
                R.id.fragmentProfileDetails -> nav_view.visibility = View.GONE
            }
        }

        //Handling back press button
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {

                // Handle the back button event
            }
        }
        this.getOnBackPressedDispatcher().addCallback(this, callback)
        // The callback can be enabled or disabled here or in handleOnBackPressed()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        //when we re press back button pop up alert dialog
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Alert !! ") //Alert dialog title
        alert.setMessage("Are You Sure to Go Out?") //Alert dialog title  message

        alert.setPositiveButton("Yes") { dialog, which -> // Alert dialog button Yes
            finish()
        }
        alert.setNegativeButton("No") { dialog, which -> //Alert dialog button NO
            Toast.makeText(applicationContext, "Not Sure I Want To Stay In", Toast.LENGTH_LONG).show()
        }
        alert.show()

    }
}