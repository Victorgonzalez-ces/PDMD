package model

abstract class Figura(var base: Double, var altura: Double) {

    abstract fun calcularArea(): Double

    open fun mostrarDatos(){
        println("Base: $base")
        println("Altura: $altura")
    }
}