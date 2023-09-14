fun main() {

    val lista = ArrayList<String?>()
    lista.add("uno")
    lista.add("dos")
    lista.add("tres")
    lista.add(null)

    lista[0] = "nuevo"
    println(lista[0])

    lista.forEach{ println(it?.length ?:0) }
}