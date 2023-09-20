package model

//constructor primario
abstract class Usuario(var nombre: String?, var apellido: String?) {

    var dni: String? = null

    //Constructor secundario
    constructor(nombre: String, apellido: String, dni: String) : this(nombre, apellido){
        this.dni = dni
    }
    open fun mostrardatos(){
        println("nombre: $nombre")
        println("apellido: $apellido")
        println("dni: ${dni ?: "sin dni"}")
    }

    abstract fun metodoAbs()

    /*override fun toString(): String {
        return "Usuario(nombre='$nombre', apellido='$apellido', dni=$dni)"
    }*/
    /*lateinit var nombre: String
    lateinit var apellido: String
    var edad: Int=0*/


}