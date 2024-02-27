package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pantalla_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)
        val buttonPantallaCsesion = findViewById<Button>(R.id.buttoncalendario)
        buttonPantallaCsesion.setOnClickListener {
            val intent = Intent(this, pantalla2::class.java)
            startActivity(intent)
        }
    }
}