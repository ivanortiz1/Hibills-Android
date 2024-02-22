package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class Bienvenida : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_opcion2) {
            val intent1 = Intent(this, registro::class.java)
            this.startActivity(intent1)
            return true
        }
        if (id == R.id.action_opcion3) {
            val intent2 = Intent(this, login::class.java)
            this.startActivity(intent2)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val nombreUsuario1 = intent.getStringArrayExtra("nombreUsuario")

        val txtSaludo = findViewById<TextView>(R.id.txtSaludo)
        txtSaludo.text = "!Hola, $nombreUsuario1!"
    }
}



