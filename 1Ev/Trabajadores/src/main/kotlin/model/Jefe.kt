package model

class Jefe(nombre: String, apellido: String, dni: String, sueldo: Int = 10000, var acciones: Int, var beneficio: Int) :
    Trabajador(nombre, apellido, dni, sueldo) {

    override fun calcularSueldoNetoMes() {
        var salarioNetoMensual = sueldo/12
        println("El salario neto mensual del jefe es de: $salarioNetoMensual")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Acciones: $acciones")
        println("Beneficio: $beneficio")
    }
}