package com.example.gameez


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.gameez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navCTRL = findNavController(R.id.navhost_fragment)
        NavigationUI.setupActionBarWithNavController(this, navCTRL)

        NavigationUI.setupWithNavController(binding.bottomNav , navCTRL)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navCTRL = findNavController(R.id.navhost_fragment)
        return navCTRL.navigateUp()
    }
}