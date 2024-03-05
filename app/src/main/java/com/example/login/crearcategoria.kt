package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference

class crearcategoria : AppCompatActivity() {
    private lateinit var nombrecat: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crearcategoria)

        val crearcategoria = findViewById<Button>(R.id.buttoncrearcategoria)
        crearcategoria.setOnClickListener {

            val intent = Intent(this, pantalla_principal::class.java)
            startActivity(intent)
        }
    }
}