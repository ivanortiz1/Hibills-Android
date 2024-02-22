package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    private lateinit var btnregistro:Button
    private lateinit var btnlogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnregistro=findViewById(R.id.btnregistro)
        btnlogin=findViewById(R.id.btnlogin)
        btnregistro.setOnClickListener{
            val intent=Intent(this@MainActivity,login::class.java)
            Toast.makeText(applicationContext,"login", Toast.LENGTH_LONG).show()
            startActivity(intent)
        }

        btnregistro.setOnClickListener{
            val intent=Intent(this@MainActivity,registro::class.java)
            Toast.makeText(applicationContext,"registro", Toast.LENGTH_LONG).show()
            startActivity(intent)
    }
        btnlogin.setOnClickListener {
            val intent=Intent(this@MainActivity,login::class.java)
            Toast.makeText(applicationContext,"Login",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }




}}