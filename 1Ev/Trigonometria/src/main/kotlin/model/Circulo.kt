package model

import java.lang.Math.PI
import java.lang.Math.pow
import kotlin.math.pow

class Circulo(var radio: Double) {

    fun calcularArea() :Double{
        return PI * radio.pow(2.0)
    }

    fun calcularDiametro() :Double{
        return 2 * radio
    }

}