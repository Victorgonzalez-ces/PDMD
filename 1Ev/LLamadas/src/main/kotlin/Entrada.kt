import controller.Centralita
import model.LLamada
import model.LLamadaLocal
import model.LLamadaNacional
import model.LLamadaProvincial

fun main(args: Array<String>) {

    var centralita: Centralita = Centralita()
    var o : Int = 0
    do {
        println("Seleccione 0 para cerrar el programa")
        println("Seleccione 1 para agregar llamada")
        println("Seleccione 2 para mostrar costes totales")
        println("Seleccione 3 para mostrar todas las llamadas realizadas")
        o = readln().toInt()

        when(o){
            0->{
                println("cerrando menu...")
            }
            1->{
                println("Introduzca Numero de origen")
                var no: Int = readln().toInt()
                println("Introduzca Numero de destino")
                var nd: Int = readln().toInt()
                println("Introduzca duración de la llamada")
                var dur: Int = readln().toInt()

                println("Seleccione 1 para una llamada local")
                println("Seleccione 2 para una llamada provincial")
                println("Seleccione 3 para una llamada nacional")
                var num: Int = readln().toInt()

                if (num == 1){
                    println("LLamada local")
                    centralita.registrarLLamada(LLamadaLocal(no,nd,dur))
                } else if (num == 2){
                    println("LLamada provincial")
                    centralita.registrarLLamada(LLamadaProvincial(no,nd,dur))
                } else if (num == 3){
                    println("LLamada nacional")
                    var franja: Int = 0
                    do {
                        println("introduzca una franja entre 1 y 3")
                        franja = readln().toInt()
                        if (franja<1 || franja>3){
                            println("numero incorrecto para la franja")
                        }
                    }while (franja !in 1..3)
                    centralita.registrarLLamada(LLamadaNacional(no,nd,dur,franja))
                }
            }
            2->{
                centralita.mostrarCostesTotales()
            }
            3->{
                centralita.mostrarLLamadasRealizadas()
            }
            else->{
                println("Numero incorrecto, porfavor introduzca un número que este dentro del menú")
            }
        }
    }while (o!=0)
}