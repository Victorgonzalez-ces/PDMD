package model

class Rectangulo(base: Double, altura: Double) : Figura(base, altura) {


    override fun calcularArea(): Double {
        return base * altura
    }

    fun calcularPerimetro(): Double{
        return (2*(base+altura))
    }
}