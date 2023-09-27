package model

class LLamadaLocal(nOrigen: Int, nDestino: Int,duracion: Int) :
    LLamada(nOrigen, nDestino,duracion) {
    var coste: Int = 0
    override fun calcularCoste(): Int {
        return coste
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Coste: ${calcularCoste()}")
    }
}