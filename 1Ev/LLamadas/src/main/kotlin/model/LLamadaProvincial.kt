package model

class LLamadaProvincial(nOrigen: Int, nDestino: Int, duracion: Int) : LLamada(nOrigen, nDestino, duracion) {

    var coste: Int = 15
    override fun calcularCoste(): Int {
        return coste * duracion
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Coste: ${calcularCoste()}")
    }
}