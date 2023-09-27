package controller

import model.Figura
import model.Rectangulo

class FigurasController {
    var figuras: ArrayList<Figura> = ArrayList()

    fun agregarFigura(figura: Figura): Unit{
        figuras.add(figura)
        println("Figura añadida correctamente")
    }

    fun listarFiguras(): Unit{
        figuras.forEach{
            it.mostrarDatos()
            println("/////////////////////////////////")
        }
    }

    fun eliminarFigura(figura: Figura){
        figuras.remove(figura)
        println("Figura borrada correctamente")
    }

    fun calculosArea(base: Double){

        val figuraEncontrada = figuras.find { it.base == base }

        println("El area de la figura es = ${figuraEncontrada?.calcularArea()}")
    }

    fun calculosPerimetro(base: Double){

        val figuraEncontrada = figuras.find { it.base == base }

        if (figuraEncontrada is Rectangulo){
            println("El perimetro del rectangulo encontrado es de = ${figuraEncontrada.calcularPerimetro()}")
        }else{
            println("La base introducida no corresponde a ningún rectangulo")
        }
    }
}