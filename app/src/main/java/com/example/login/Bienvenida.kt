package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
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

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            val id = item.itemId
            if (id == R.id.action_opcion2) {
                val intent1 = Intent(this, registro::class.java)
                startActivity(intent1)
                return true
            }
            if (id == R.id.action_opcion3) {
                val intent2 = Intent(this, login::class.java)
                startActivity(intent2)
                return true
            }
            if (id == R.id.action_opcion4) {
                val checkBoxTerminos = findViewById<CheckBox>(R.id.checkBoxTerminos)
                if (checkBoxTerminos.isChecked) {
                    val intent3 = Intent(this, pantalla_principal::class.java)
                    startActivity(intent3)
                    return true
                } else {
                    Toast.makeText(this, "Es necesario aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
                }
            }
            return super.onOptionsItemSelected(item)
        }

    }
}



