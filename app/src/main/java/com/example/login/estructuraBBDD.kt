package com.example.login

data class estructuraBBDD(
    var correo: String? = null,
    var nombre: String? = null,
    var contrasenya: String? = null,
    var categoria1: String? = null,
    var categoria2: String? = null,
    var categoria3: String? = null
)

data class estructuraGastos(
    var idcategoria: String? = null,
    var idmes: String? = null,
    var cantidad: String? = null,
    var nombre: String? = null
)

data class categorias(
    var nombrecat: String? = null
)


