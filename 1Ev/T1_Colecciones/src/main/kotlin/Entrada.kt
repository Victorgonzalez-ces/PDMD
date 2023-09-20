fun main(){

    //var arrayVacio: Array<String> = emptyArray()
    var arrayVacio: Array<String?> = arrayOfNulls<String>(10)
    var arrayElementos: Array<Any?> = arrayOf(1,2,3,3,3,"asd",true,null)
    var arrayNumeros = intArrayOf(1,2,3,4,5,6)

    //cambiar elementos
    arrayElementos[2] = "cambio"

    //obtener un dato
    println(arrayElementos[0])

    arrayElementos.forEach {
        println(it ?: "sin dato guardado en la posicion") }

    //sacar todos los 3
    //forma poco eficiente
    var contador = 0
    arrayElementos.forEach {
        if (it == 3){
            contador++
        }
    }
    println("El numero de 3 en el array es de $contador")

    //forma muy eficiente
    var lista: List<Any?> = arrayElementos.filter { it == 3 }

    println("El numero de 3 es ${lista.size}")

    //ARRAYLIST
    var listaElementos = ArrayList<String>()
    //añadir elementos
    listaElementos.add("234")
    listaElementos.add("qrw")
    //te dice el elemento en la posicion
    listaElementos[0]
    //borrar elementos
    listaElementos.remove("234")
    listaElementos.removeAt(0)

    listaElementos.removeIf { it.equals("qwe",true) }
}