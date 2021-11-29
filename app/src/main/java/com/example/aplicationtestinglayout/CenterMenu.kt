package com.example.aplicationtestinglayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CenterMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centermenu)

        val botaoDeNavegacao = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val controleDeNav = findNavController(R.id.fragment)

        botaoDeNavegacao.setupWithNavController(controleDeNav)

    }
}