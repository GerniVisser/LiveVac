package com.livevac

import android.os.Bundle
import android.view.Window
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.livevac.databinding.ActivityMainBinding
import com.livevac.ui.herd.AddHerdFragment
import com.livevac.ui.herd.HerdFragment
import com.livevac.ui.home.HomeFragment
import com.livevac.ui.home.VaccinateEventFragment

import java.util.*

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main2)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}






/*package com.livevac

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.livevac.databinding.ActivityMainBinding
import com.livevac.ui.herd.AddHerdFragment
import com.livevac.ui.herd.HerdFragment
import com.livevac.ui.home.HomeFragment
import com.livevac.ui.home.VaccinateEventFragment

import java.util.*

class MainActivity : AppCompatActivity(),
    HomeFragment.Callbacks,HerdFragment.Callbacks{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main2)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onVaccinateSelected() {
        val fragment = VaccinateEventFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main2, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onAddHerdSelected() {
        val fragment = AddHerdFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_activity_main2, fragment)
            .addToBackStack(null)
            .commit()
    }
}
*/
