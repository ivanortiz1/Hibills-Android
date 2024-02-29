package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class creargasto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creargasto)
        val buttonCrearGasto = findViewById<Button>(R.id.buttoncreargasto)
        buttonCrearGasto.setOnClickListener {
            val intent = Intent(this, pantalla_principal::class.java)
            startActivity(intent)
        }
    }



}