package controller

import model.Trabajador

class Empresa {

    var listaTrabajadores: ArrayList<Trabajador>

    init {
        listaTrabajadores = ArrayList()
    }

    //agregar trabajador -> no puede haber dos trabajadores con el mismo dni
    fun agregarTrabajador(trabajador: Trabajador): Unit{
        //agrego trabajador directamente si no hay ninguno en la lista
        if (listaTrabajadores.isEmpty()){
            listaTrabajadores.add(trabajador)
        }

        if (listaTrabajadores.find { it.dni == trabajador.dni } == null){
            listaTrabajadores.add(trabajador)
            println("Trabajador añadido correctamente")
        }else{
            println("Error el dni del trabajador introducido ya existe")
        }
    }
    //listar todos
    fun listarTodosTrabajadores(): Unit{
        listaTrabajadores.forEach{it.mostrarDatos()}
    }
    //listar en detalle
    fun listarDetalle(dni : Int): Unit{
        for (i in listaTrabajadores){
            if (listaTrabajadores.find { it.dni == i.dni } == null){
                println("no se ha encontrado el trabajador correspondiente al dni introducido")
            }else{
                i.mostrarDatos()
            }
        }
    }
    //eliminar - despedir
}