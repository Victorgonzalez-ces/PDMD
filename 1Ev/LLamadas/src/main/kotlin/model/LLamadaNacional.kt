package model

import kotlin.math.cos

class LLamadaNacional(nOrigen: Int, nDestino: Int, duracion: Int, var franja: Int) : LLamada(nOrigen, nDestino, duracion) {

    var coste: Int = 0
    override fun calcularCoste(): Int {
        if (franja == 1){
            coste = 20
        }else if (franja == 2){
            coste = 25
        }else{
            coste = 30
        }
        return coste * duracion
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Franja: $franja")
        println("Coste: ${calcularCoste()}")
    }
}