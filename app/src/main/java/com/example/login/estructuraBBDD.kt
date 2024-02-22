package com.example.login

data class estructuraBBDD(
    var correo: String? = null,
    var nombre: String? = null,
    var contrasenya: String? = null,
)

data class estructuraGastos(
    var numGasto: String? = null,
    var categoriaGasto: String? = null,
)