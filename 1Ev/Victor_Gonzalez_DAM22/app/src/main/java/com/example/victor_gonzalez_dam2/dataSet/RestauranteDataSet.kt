package com.example.victor_gonzalez_dam2.dataSet

import com.example.victor_gonzalez_dam2.model.Restaurante

class RestauranteDataSet {
    companion object{
        var lista: ArrayList<Restaurante> = ArrayList()

        fun obtenerRestaurante(){
            lista.add(Restaurante("Italiano1","Madrid",4,"Italiano",9111))
            lista.add(Restaurante("Italiano2","Alcobendas",7,"Italiano",9222))
            lista.add(Restaurante("Italiano3","Pozuelo",9,"Italiano",9333))
            lista.add(Restaurante("Italiano4","Majadahonda",3,"Italiano",9444))
            lista.add(Restaurante("Italiano5","Madrid",9,"Italiano",9555))
            lista.add(Restaurante("Mediterraneo1","Madrid",6,"Mediterranea",9666))
            lista.add(Restaurante("Mediterraneo2","Alcobendas",7,"Mediterranea",9777))
            lista.add(Restaurante("Mediterraneo3","Pozuelo",5,"Mediterranea",9123))
            lista.add(Restaurante("Mediterraneo4","Majadahonda",2,"Mediterranea",9234))
            lista.add(Restaurante("Chino1","Madrid",10,"Chino",9345))
            lista.add(Restaurante("Chino2","Alcobendas",5,"Chino",9456))
            lista.add(Restaurante("Chino3","Pozuelo",6,"Chino",9567))
            lista.add(Restaurante("Japones1","Alcorcón",10,"Japones",8123))
            lista.add(Restaurante("Japones2","Alcobendas",5,"Japones",7123))
            lista.add(Restaurante("Japones3","Alcorcón",7,"Japones",6123))
        }
    }
}