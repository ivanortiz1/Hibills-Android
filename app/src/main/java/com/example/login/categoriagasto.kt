package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class categoriagasto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categoriagasto)

        val ircreargasto = findViewById<Button>(R.id.ircreargastos)
        ircreargasto.setOnClickListener {
            val intent = Intent(this, creargasto::class.java)
            startActivity(intent)
        }
        val ircrearcategoria = findViewById<Button>(R.id.ircrearcategoria)
        ircrearcategoria.setOnClickListener {
            val intent = Intent(this, crearcategoria::class.java)
            startActivity(intent)
        }
    }

}