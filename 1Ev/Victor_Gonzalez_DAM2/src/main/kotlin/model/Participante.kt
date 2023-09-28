package model

class Participante(var id: Int, var nombre: String){
    var presupuesto: Int = 0
    var plantilla: ArrayList<Jugador>
    var puntos: Int = 0
    init {
        presupuesto = 10000000
        plantilla = ArrayList()
    }

    fun mostrarDatos(){
        println("Id: $id")
        println("Nombre: $nombre")
        println("Presupuesto: $presupuesto")
        println("Plantilla: ${mostrarPlantilla()}")
        println("Puntos: $puntos")
    }

    fun mostrarPlantilla(){
        plantilla.forEach{it.mostrarDatos()
        "//////////////////////////////////"
        }
    }

    fun validacionPlantillaPortero(): Boolean{
        if (plantilla.find { it.posicion == "Portero" } != null){
            return false
        }
        return true
    }

    fun validacionPlantillaDefensa(): Boolean{
        var contador: Int = 0
        plantilla.forEach{
            if (it.posicion.equals("Defensa")){
                contador++
            }
        }
        return contador<2
    }

    fun validacionPlantillaMedio(): Boolean{
        var contador: Int = 0
        plantilla.forEach {
            if (it.posicion.equals("Mediocentro")) {
                contador++
            }
        }
        return contador<2
    }

    fun validacionPlantillaDelantero(): Boolean{
        if (plantilla.find { it.posicion == "Delantero" } != null){
            return false
        }
        return true
    }

    fun validacionPresupuesto(): Boolean{
        if (presupuesto<0){
            return false
        }
        return true
    }

    fun puntosTotales(): Int{
        var puntTotales: Int = 0
        plantilla.forEach{ puntTotales += it.puntuacion }

        return puntTotales
    }
}