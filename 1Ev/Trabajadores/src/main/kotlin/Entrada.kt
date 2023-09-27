import controller.Empresa
import model.Asalariado
import model.Autonomo
import model.Jefe
import model.Trabajador

fun main() {
    //asalariado
    //nombre: String, apellido: String, dni: String, sueldo: Int = 10000, var numeroPagas: Int, var contratado: Boolean = false
    var empresa = Empresa()
    var o : Int = 0

    do {
        println("0. Cerrar menú")
        println("1. Agregar trabajador")
        println("2. Listar trabajadaores")
        o = readln().toInt()
        when(o){
            1-> {
                println("Introduzca un nombre")
                var nombr: String = readln()
                println("Introduzca un apellido")
                var ape: String = readln()
                println("Introduzca su dni")
                var dn: String = readln()
                println("Introduzca su sueldo")
                var sueld: Int = readln().toInt()
                println("Elija 1 para crear un trabajador asalariado")
                println("Elija 2 para crear un trabajador autonomo")
                println("Elija 3 para crear un trabajador jefe")
                var u : Int = readln().toInt()
                if (u==1){
                    println("ha seleccionado la opción crear asalariado: ")
                    println("Introduzca el número de pagas que tendrá")
                    var numPag: Int = readln().toInt()
                    println("¿Quieres estar contratado ya?")
                    var contrat: Boolean = readln().toBoolean()
                    empresa.agregarTrabajador(Asalariado(nombr,ape,dn,sueld,numPag,contrat))
                }else if (u==2){
                    println("ha seleccionado la opción crear autonomo")
                    println("Introduzca sus cuotas a la seguridad social")
                    var cuotas: Int = readln().toInt()
                    println("¿Quieres estar contratado ya?")
                    var contrat: Boolean = readln().toBoolean()
                    empresa.agregarTrabajador(Autonomo(nombr,ape,dn,sueld,cuotas,contrat))
                }
            }
        }
    }while (o != 0)

}