package model

class Triangulo(base: Double, altura: Double) : Figura(base, altura) {

    override fun calcularArea(): Double {
        return (base*altura)/2
    }

    
}