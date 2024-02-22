package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class login : AppCompatActivity() {
    private lateinit var Btn_buscarRegistro: Button
    private lateinit var correoL: EditText
    private lateinit var passL: EditText
    private lateinit var dataset: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        correoL = findViewById(R.id.emailLogin)
        passL = findViewById(R.id.passlogin)
        Btn_buscarRegistro = findViewById(R.id.btnEnviarLogin)

        dataset = FirebaseDatabase.getInstance().getReference("Usuarios")

        Btn_buscarRegistro.setOnClickListener{
            verificaDatosLogin ()
        }
    }


    private fun verificaDatosLogin(){
        val correo = correoL.text.toString().trim()
        val password = passL.text.toString().trim()

        if(correo.isEmpty()||password.isEmpty()){
            Toast.makeText(this, "Por favor, ingrese el correo electronico y contraseña",Toast.LENGTH_LONG)
            return
        }
        dataset.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var usuarioEncontrado = false
                for (usuarioSnapshot in snapshot.children) {
                    val correoDB = usuarioSnapshot.child("nombre").value.toString()
                    if (correoDB.equals(correo, ignoreCase = true)) {
                        usuarioEncontrado = true
                        val dbPassword = usuarioSnapshot.child("contrasenya").value.toString()
                        if (dbPassword == password) {
                            val nombreUsuario = usuarioSnapshot.child("correo").value.toString()
                            Toast.makeText(
                                applicationContext,
                                "Inicio de sesion exitoso",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(this@login, Bienvenida::class.java)
                            intent.putExtra("nombreUsuario", nombreUsuario)
                            startActivity(intent)
                            break
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Contraseña incorrecta",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
                if (!usuarioEncontrado) {
                    Toast.makeText(applicationContext, "Usuario no encontrado", Toast.LENGTH_LONG)
                        .show()
                    val intent = Intent(this@login, registro::class.java)
                    startActivity(intent)
                }
            }
                override fun onCancelled(error: DatabaseError){
                    Toast.makeText(applicationContext," Error al acceder a la base de datos", Toast.LENGTH_LONG).show()
                }

        })
    }
    }


