package model

class Fantasy {

    var participantes: ArrayList<Participante>
    var jugadoresFichables: ArrayList<Jugador>

    init {
        participantes = ArrayList()
        jugadoresFichables = ArrayList()
    }

    fun fichajeJugadores(id: Int){
        var o: Int = 0
        var participanteEncontrado = participantes.find { it.id == id }
        if (participanteEncontrado != null){
            do {
                println("seleccione 0 si desea fichar un jugador")
                println("seleccione 1 si desea cerrar el menú de fichajes")
                o = readln().toInt()
                when(o){
                    0->{
                        println("Porfavor Introduzca el id del jugador que desea fichar")
                        var idJug: Int = readln().toInt()
                        var jugadorEncontrado = jugadoresFichables.find { it.id == idJug }
                        if (jugadoresFichables.find { it.id == idJug } != null){
                            participanteEncontrado.presupuesto -= jugadorEncontrado!!.valor
                            participanteEncontrado.plantilla.add(jugadorEncontrado)
                            println("Jugador añadido a su plantilla correctamente")
                            println("Su presupuesto ahora es de: ${participanteEncontrado.presupuesto}")
                        }else{
                            println("Jugador no encontrado, introduzca un id válido")
                        }
                    }
                    1->{
                        println("cerrando menú de fichajes...")
                    }
                    2->{
                        println("Número incorrecto, porfavor elija solo 0 o 1")
                    }
                }
            }while (o!=1)
        }else{
            println("Lo sentimos el id introducido no corresponde a ningún participante")
        }
    }





}