package model

class UsuarioExtendido(nombre: String, apellido: String, dni: String, var telefono: Int, var sueldo: Int) : Usuario(nombre, apellido, dni) {

    override fun mostrardatos() {
        super.mostrardatos()
        println("telefono: $telefono")
        println("sueldo: $sueldo")
    }
}