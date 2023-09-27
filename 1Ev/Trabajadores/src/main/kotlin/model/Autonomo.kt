package model

import data.Constantes

class Autonomo(nombre: String, apellido: String, dni: String, sueldo: Int = 10000, var cuotaSS: Int, var contratado: Boolean = false) :
    Trabajador(nombre, apellido, dni, sueldo) {


    override fun calcularSueldoNetoMes() {
        var salarioNetoMensual = (sueldo -(cuotaSS * Constantes.MESES))/Constantes.MESES
        println("El salario neto mensual del autónomo es de: $salarioNetoMensual")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Cuota seguridad social: $cuotaSS")
        println("Contratado: $contratado")
    }
}