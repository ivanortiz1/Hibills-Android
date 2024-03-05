package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class pantalla3 : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla3)

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

        val irsobrenosotros = findViewById<Button>(R.id.sobrenosotros)
        irsobrenosotros.setOnClickListener {
            val intent = Intent(this, sobrenosotros::class.java)
            startActivity(intent)
        }
        val ircontactanos = findViewById<Button>(R.id.contactanos)
        ircontactanos.setOnClickListener {
            val intent = Intent(this, contactanos::class.java)
            startActivity(intent)
        }

        val buttonCsesion = findViewById<Button>(R.id.buttoncsesion)
        buttonCsesion.setOnClickListener {
            // Al hacer clic en el botón, iniciar la actividad MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Mostrar un Toast indicando que la sesión se cerró con éxito
            Toast.makeText(this, "Sesión cerrada con éxito", Toast.LENGTH_SHORT).show()
        }

    }

}
