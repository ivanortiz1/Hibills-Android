package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast

class pantalla_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            Toast.makeText(this, "Fecha seleccionada: $dayOfMonth/${month + 1}/$year", Toast.LENGTH_SHORT).show()
        }
        val buttonPantallaCsesion = findViewById<Button>(R.id.buttoncalendario)
        buttonPantallaCsesion.setOnClickListener {
            val intent = Intent(this, pantalla2::class.java)
            startActivity(intent)
        }
        val buttonpantallacreargasto = findViewById<Button>(R.id.buttoncrear)
        buttonpantallacreargasto.setOnClickListener {
            val intent = Intent(this, creargasto::class.java)
            startActivity(intent)
        }
    }
}