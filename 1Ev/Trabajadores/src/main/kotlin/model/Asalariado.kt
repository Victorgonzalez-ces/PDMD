package model

import data.Constantes

class Asalariado(nombre: String, apellido: String, dni: String, sueldo: Int = 10000, var numeroPagas: Int, var contratado: Boolean = false) :
    Trabajador(nombre, apellido, dni, sueldo) {


    override fun calcularSueldoNetoMes() {
        var salarioNetoMensual = (sueldo - (sueldo * Constantes.RETENCIONES))/Constantes.MESES
        println("El salario neto mensual del asalariado es de: $salarioNetoMensual")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Numero de pagas: $numeroPagas")
        println("Contratado: $contratado")
    }
}