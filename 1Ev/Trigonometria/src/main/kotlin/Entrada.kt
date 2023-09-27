import controller.FigurasController
import model.Figura
import model.Rectangulo
import model.Triangulo

fun main() {
    var o: Int = 0
    var figurasController = FigurasController()
    do {
        println("Seleccione 0 para cerrar el menú")
        println("Seleccione 1 para crear figuras")
        println("Seleccione 2 para listarlas")
        println("Seleccione 3 para calcular area de la que desee")
        println("Seleccione 4 para calcular perimetro del rectangulo que desee")
        o = readln().toInt()

        when(o){
            1-> {
                println("introduzca su base:")
                var base: Double = readln().toDouble()
                println("introduzca su altura:")
                var altura: Double = readln().toDouble()

                println("Introduzca 1 si desea crear un rectangulo y 2 si desea un triangulo")
                var u: Int = readln().toInt()
                if (u==1){
                    println("Ha seleccionado la opción crear un rectangulo")
                    figurasController.agregarFigura(Rectangulo(base, altura))
                }else if (u==2){
                    println("Ha seleccionado la opción crear un triangulo")
                    figurasController.agregarFigura(Triangulo(base, altura))
                }else{
                    println("Opcion no valida por favor introduzca una opcion valida")
                }
            }
            2-> {
                println("ha seleccionado la opcion listar figuras")
                figurasController.listarFiguras()
            }
            3-> {
                println("introduzca la base de la figura que desee calcular su area")
                var base: Double = readln().toDouble()
                figurasController.calculosArea(base)
            }

            4-> {
                println("introduzca la base de la figura que desee calcular su area")
                var base: Double = readln().toDouble()
                figurasController.calculosPerimetro(base)
            }
        }
    }while (o!=0)
}