package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class creargasto : AppCompatActivity() {
    private lateinit var idcategoria: EditText
    private lateinit var idmes: EditText
    private lateinit var cantidadgasto: EditText
    private lateinit var nombregasto: EditText
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creargasto)
        val buttonCrearGasto = findViewById<Button>(R.id.buttoncreargasto)
        buttonCrearGasto.setOnClickListener {


            // IdGasto = findViewById(R.id.)

            idcategoria = findViewById(R.id.categoria)
            idmes = findViewById(R.id.idmes)
            cantidadgasto = findViewById(R.id.gastocantidad)
            nombregasto = findViewById(R.id.nombregasto)

            database = FirebaseDatabase.getInstance().getReference("Gastos")

            guardaDatosUsuarios()
            val intent = Intent(this, pantalla_principal::class.java)
            startActivity(intent)

        }
    }
    private fun guardaDatosUsuarios() {

        val categoriaid = idcategoria.text.toString()
        val mesid = idmes.text.toString()
        val gastocantidad = cantidadgasto.text.toString()
        val gastonombre = nombregasto.text.toString()

        if (categoriaid.isEmpty() || mesid.isEmpty() || gastocantidad.isEmpty() || gastonombre.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }




        val gastoid = database.push().key!!
        val uBBDD = estructuraGastos(categoriaid, mesid, gastocantidad, gastonombre)

        database.child(gastoid).setValue(uBBDD)
            .addOnCompleteListener {
                Log.d("Firebase", "Datos insertados correctamente")
                Toast.makeText(this, "Gasto insertado correctamente", Toast.LENGTH_LONG).show()

                idcategoria.text.clear()
                idmes.text.clear()
                cantidadgasto.text.clear()
                nombregasto.text.clear()

            }.addOnFailureListener(){err ->
                Log.e("Firebase", "Error al insertar datos: ${err.message}")
                Toast.makeText(this, "Error: ${err.message}", Toast.LENGTH_LONG).show()
            }
    }


}