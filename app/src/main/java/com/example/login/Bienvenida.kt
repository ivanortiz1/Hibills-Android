package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class Bienvenida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)
        Toast.makeText(this, "Es necesario aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()

        val nombreUsuario1 = intent.getStringArrayExtra("nombreUsuario")

        val txtSaludo = findViewById<TextView>(R.id.txtSaludo)
        txtSaludo.text = "!Hola, $nombreUsuario1!"

    }
}



