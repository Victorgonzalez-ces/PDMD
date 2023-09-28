package model

class Jugador(var id: Int, var nombre: String, var posicion: String, var valor: Int, var puntuacion: Int) {

    fun mostrarDatos(){
        println("Id: $id")
        println("Nombre: $nombre")
        println("Posicion: $posicion")
        println("Valor: $valor")
        println("Puntuación: $puntuacion")
    }

}