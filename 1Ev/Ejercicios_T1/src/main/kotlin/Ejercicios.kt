fun ej1(): Unit{
    println("introduce un número")
    var num: Int = readLine()!!.toInt()

    if (num%2==0){
        println("El numero es par")
    }else{
        println("El numero es impar")
    }
}

fun ej2(): Unit{
    println("introduce un numero")
    var num: Int = readLine()!!.toInt()

    if (num>0){
        println("El numero es positivo")
    }else if (num<0){
        println("El numero es negativo")
    }else{
        println("El numero es igual a 0")
    }
}

fun ej3(): Unit{
    println("introduzca un numero para saber si es primo o no")
    var num: Int = readLine()!!.toInt()

    if (esPrimo(num)){
        println("el numero es primo")
    }else{
        println("el numero no es primo")
    }
}

fun ej4(): Unit{
    println("introduce un numero para ver sus primos inferiores")
    var num: Int = readLine()!!.toInt();

    (1..num).forEach { item ->
        if (esPrimo(item)) {
            println(item)
        }
    }
}

fun ej5(): Unit{
    println("introduce un numero para calcular su factorial")
    var num: Int = readLine()!!.toInt();
    var result: Int = 0
    (1..num).forEach { item ->
        result = item * item+1
    }
    println(result)
}
fun esPrimo(numero: Int): Boolean{
    if (numero <= 1){
        return false
    }
    for (i in 2 until numero){
        if (numero%i==0){
            return false
        }
    }
    return true
}
fun main(args: Array<String>) {
    //ej1()
    //ej2()
    //ej3()
    //ej4()
    ej5()
}