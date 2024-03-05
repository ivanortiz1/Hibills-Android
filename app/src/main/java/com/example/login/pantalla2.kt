package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class pantalla2 : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(this, pantalla_principal::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_dashboard -> {
                    val intent = Intent(this, pantalla2::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_notifications -> {
                    val intent = Intent(this, pantalla3::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        val buttonPantallaCsesion = findViewById<Button>(R.id.buttonpantallacsesion)
        buttonPantallaCsesion.setOnClickListener {
            val intent = Intent(this, pantalla3::class.java)
            startActivity(intent)
        }
    }
}