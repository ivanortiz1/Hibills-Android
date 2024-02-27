package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pantalla2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla2)

        val buttonPantallaCsesion = findViewById<Button>(R.id.buttonpantallacsesion)
        buttonPantallaCsesion.setOnClickListener {
            val intent = Intent(this, pantalla3::class.java)
            startActivity(intent)
        }

    }
}