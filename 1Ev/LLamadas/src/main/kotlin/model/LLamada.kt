package model

abstract class LLamada(var nOrigen: Int, var nDestino: Int, var duracion: Int) {

    abstract fun calcularCoste(): Int

    open fun mostrarDatos(){
        println("Número de origen: $nOrigen")
        println("Número de destino: $nDestino")
        println("Duración: $duracion")
    }

}