package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.Button
import android.widget.Toast
import android.util.Log

class registro() : AppCompatActivity() {
    private lateinit var btngrabaregistro: Button
    private lateinit var nombreU: EditText
    private lateinit var correoU: EditText
    private lateinit var passU: EditText
    private lateinit var passU2: EditText
    private lateinit var database: DatabaseReference

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        nombreU = findViewById(R.id.Rnombre)
        correoU = findViewById(R.id.Remail)
        passU = findViewById(R.id.Rpassword)
        passU2 = findViewById(R.id.Rpassword2)
        btngrabaregistro = findViewById(R.id.botonbrabaregistro)

        database = FirebaseDatabase.getInstance().getReference("Usuarios")

        btngrabaregistro.setOnClickListener {
            guardaDatosUsuarios()
        }

    }

    private fun guardaDatosUsuarios() {

        val usuarioNombre = nombreU.text.toString()
        val usuarioCorreo = correoU.text.toString()
        val usuarioPass = passU.text.toString()
        val usuarioPass2 = passU2.text.toString()

        if (usuarioNombre.isEmpty() || usuarioCorreo.isEmpty() || usuarioPass.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        if(usuarioPass != usuarioPass2) {
            val pass2UsuarioEditText = findViewById<EditText>(R.id.Rpassword2)
            pass2UsuarioEditText.requestFocus()
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }



        val usuarioId = database.push().key!!


        val usuarioColeccion = FirebaseDatabase.getInstance().getReference("Usuarios/$usuarioNombre")


        val categoria1 = "Ocio"
        val categoria2 = "Transporte"
        val categoria3 = "Compras"
        val uBBDD = estructuraBBDD(usuarioCorreo, usuarioNombre, usuarioPass, categoria1, categoria2, categoria3)

        usuarioColeccion.setValue(uBBDD)


        database.child(usuarioId).setValue(uBBDD)
            .addOnCompleteListener {
                Log.d("Firebase", "Datos insertados correctamente")
                Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_LONG).show()

                nombreU.text.clear()
                correoU.text.clear()
                passU.text.clear()
                val intent = Intent(this@registro, Bienvenida::class.java)
                startActivity(intent)

            }.addOnFailureListener(){err ->
                Log.e("Firebase", "Error al insertar datos: ${err.message}")
                Toast.makeText(this, "Error: ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}

