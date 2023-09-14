import kotlin.time.measureTime

fun funcionSuma(op1: Int, op2: Int) : Int{

    var suma = op1+op2
    //println("el resultado de sumar $op1 + $op2 es $suma")
    return suma;
}

fun funcionOptativos(param1: String, param2: Int=0){
    println("El parametro uno es: $param1 , y el parametro dos es $param2")
}

fun funcionOptativos(param1: String, param2: Int?){
    println("El parametro uno es: $param1 , y el parametro dos es $param2")
}

fun imprimirMensaje(mensaje: String){
    var nombre = pedirNombre()
    println(mensaje)
}

fun pedirNombre(): String{
    println("por favor introduce el nombre que quieres acompañar en el mensaje")
    var nombre = readln()
    return nombre
}

fun funcionParametroFuncion(param: (()->String)?,param2: String){
    var nombre = param?.invoke() ?: "defecto"
    println("$param2 $nombre")
}

var funcionSumaFlecha: ((Int,Int) ->Int) = {num1: Int, num2: Int -> num1+num2 }
var funcionSumaFlechaAsync: ((Int,Int) -> Int) =
    {num1: Int,num2: Int -> num1 +num2}
fun main(){
    //Parametros posicionales
    //println(funcionSuma(4,8))

    //Parametros nominales
    //println(funcionSuma(op2 = 4, op1 = 2))

    //parametros optativos
    //funcionOptativos("uno",null)

    //imprimirMensaje("esto es un ejemplo de mensaje ")
    //Parametrofuncion
    //funcionParametroFuncion({ pedirNombre() },"Ejemplo")

    println(funcionSumaFlecha(4,8))
}