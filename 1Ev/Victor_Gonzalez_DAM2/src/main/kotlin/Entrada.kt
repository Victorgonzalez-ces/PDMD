import model.Fantasy
import model.Jugador
import model.Participante

fun main() {

    var fantasy: Fantasy = Fantasy()

    fantasy.jugadoresFichables.add(Jugador(1,"Marc-André ter Stegen", "Portero",3000000,10))
    fantasy.jugadoresFichables.add(Jugador(2,"Ronald Araújo", "Defensa",4000000,0))
    fantasy.jugadoresFichables.add(Jugador(3,"Eric García", "Defensa",1000000,3))
    fantasy.jugadoresFichables.add(Jugador(4,"Pedri", "Mediocentro",5000000,23))
    fantasy.jugadoresFichables.add(Jugador(5,"Robert Lewandowski", "Delantero",8000000,15))
    fantasy.jugadoresFichables.add(Jugador(6,"Courtois", "Portero",3000000,1))
    fantasy.jugadoresFichables.add(Jugador(7,"David Alaba", "Defensa",4000000,5))
    fantasy.jugadoresFichables.add(Jugador(8,"Jesús Vallejo", "Defensa",500000,10))
    fantasy.jugadoresFichables.add(Jugador(9,"Luka Modric", "Mediocentro",5000000,5))
    fantasy.jugadoresFichables.add(Jugador(10,"Karim Benzema", "Delantero",8000000,10))
    fantasy.jugadoresFichables.add(Jugador(11,"Ledesma", "Portero",500000,6))
    fantasy.jugadoresFichables.add(Jugador(12,"Juan Cala", "Defensa",300000,3))
    fantasy.jugadoresFichables.add(Jugador(13,"Zaldua", "Defensa",400000,6))
    fantasy.jugadoresFichables.add(Jugador(14,"Alez Fernández", "Mediocentro",700000,9))
    fantasy.jugadoresFichables.add(Jugador(15, "Choco Lozano", "Delantero", 800000,4))
    fantasy.jugadoresFichables.add(Jugador(16,"Rajković", "Portero",300000,3))
    fantasy.jugadoresFichables.add(Jugador(17,"Raíllo", "Defensa",200000,6))
    fantasy.jugadoresFichables.add(Jugador(18,"Maffeo", "Defensa",300000,0))
    fantasy.jugadoresFichables.add(Jugador(19,"Ruiz de Galarreta", "Mediocentro",400000,7))
    fantasy.jugadoresFichables.add(Jugador(25,"Ángel", "Delantero", 300000,4))
    fantasy.jugadoresFichables.add(Jugador(20,"Remiro", "Portero",1000000,3))
    fantasy.jugadoresFichables.add(Jugador(21,"Elustondo", "Defensa",900000,5))
    fantasy.jugadoresFichables.add(Jugador(22,"Zubeldia", "Defensa",800000,6))
    fantasy.jugadoresFichables.add(Jugador(23,"Zubimendi", "Mediocentro",1000000,7))
    fantasy.jugadoresFichables.add(Jugador(24,"Take Kubo", "Delantero", 800000,4))
    var id = 0
    var participante1: Participante = Participante(1,"pepe")
    for (i in 0..5){
        println("introduzca el id de un jugador")
        id = readln().toInt()
        var jug = fantasy.jugadoresFichables.find { it.id == id }
        if (participante1.validacionPlantillaPortero() && participante1.validacionPlantillaDefensa() && participante1.validacionPlantillaMedio() && participante1.validacionPlantillaDelantero() && participante1.validacionPresupuesto()){
            participante1.plantilla.add(jug!!)
        }
    }

    var participante2: Participante = Participante(2,"Juan")
    for (i in 0..5){
        println("introduzca el id de un jugador")
        id = readln().toInt()
        var jug = fantasy.jugadoresFichables.find { it.id == id }
        if (participante2.validacionPlantillaPortero() && participante2.validacionPlantillaDefensa() && participante2.validacionPlantillaMedio() && participante2.validacionPlantillaDelantero() && participante2.validacionPresupuesto()){
            participante2.plantilla.add(jug!!)
        }
    }
    var participante3: Participante = Participante(3,"Luis")
    for (i in 0..5){
        println("introduzca el id de un jugador")
        id = readln().toInt()
        var jug = fantasy.jugadoresFichables.find { it.id == id }
        if (participante3.validacionPlantillaPortero() && participante3.validacionPlantillaDefensa() && participante3.validacionPlantillaMedio() && participante3.validacionPlantillaDelantero() && participante3.validacionPresupuesto()){
            participante3.plantilla.add(jug!!)
        }
    }
    var participante4: Participante = Participante(4,"Pedro")
    for (i in 0..4){
        println("introduzca el id de un jugador")
        id = readln().toInt()
        var jug = fantasy.jugadoresFichables.find { it.id == id }
        if (participante4.validacionPlantillaPortero() && participante4.validacionPlantillaDefensa() && participante4.validacionPlantillaMedio() && participante4.validacionPlantillaDelantero() && participante4.validacionPresupuesto()){
            participante4.plantilla.add(jug!!)
        }
    }


}