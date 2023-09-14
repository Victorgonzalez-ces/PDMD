
var ej1 = {num1: Int,num2:Int -> num1+num2}

fun ej2(lista: ArrayList<Int>): Int{
    var numMax=0
    for (i in 0 until lista.size){
        if (numMax<lista[i]){
            numMax = lista[i]
        }
    }
    return numMax
}
fun ej3(num1: Int) :Boolean{
    return num1%2==0
}
//funcion de flecha
var ej3Flecha = {x: Int-> x%2==0}

var ej4 = {cadena: String? -> println(cadena?.length ?:"nada") }
//funcion de linea
fun ej6(x: Int) = (1..x).forEach { println(it) }

fun main() {
    //println(ej1(readLine()!!.toInt(), readLine()!!.toInt()))
    //println("introduce un numero")
    //println(ej3(readLine()!!.toInt()))
    //ej6(6)
    /*val list = ArrayList<Int>()
    list.add(6)
    list.add(2)
    list.add(9)
    list.add(1)
    list.add(14)
    println(ej2(list))*/
    ej4(readln())
}