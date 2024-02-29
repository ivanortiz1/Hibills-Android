package com.example.login

data class estructuraBBDD(
    var correo: String? = null,
    var nombre: String? = null,
    var contrasenya: String? = null,
)

data class estructuraGastos(
    var idcategoria: String? = null,
    var idmes: String? = null,
    var cantidad: String? = null,
    var nombre: String? = null
)

data class categorias(
    var nombreCat: String? = null,
    var idGasto: Int? = null
)


