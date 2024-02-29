package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class pantalla3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla3)

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
