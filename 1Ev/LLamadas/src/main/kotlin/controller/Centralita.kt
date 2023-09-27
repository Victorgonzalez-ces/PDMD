package controller

import model.LLamada

class Centralita {

    var llamadas: ArrayList<LLamada> = ArrayList()

    fun registrarLLamada(llamada: LLamada): Unit{
        llamadas.add(llamada)
        var llamadaEncontrada: LLamada? = llamadas.find { it == llamada }
        llamadaEncontrada?.mostrarDatos()
    }

    fun mostrarCostesTotales(): Unit{
        var i: Int = 0
        var costeTotal: Int = 0
        llamadas.forEach{
            i++
            println("Coste de llamada $i = ${it.calcularCoste()}")
            println("/////////////////////////////////")
            costeTotal += it.calcularCoste()
        }
        println("El coste total de todas las llamadas realizadas es de = $costeTotal")
    }

    fun mostrarLLamadasRealizadas(): Unit{
        llamadas.forEach{
            it.mostrarDatos()
            println("//////////////////////////////////")
        }
    }
}