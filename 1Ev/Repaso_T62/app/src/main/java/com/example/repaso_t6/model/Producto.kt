package com.example.repaso_t6.model

class Producto() {
    var id: Int = 0
    lateinit var nombre: String
    lateinit var descripcion: String
    lateinit var categoria: String
    var precio: Double = 0.0
    lateinit var imagen: String
    constructor(id: Int,
                nombre: String,
                precio: Double,
                descripcion: String,
                categoria: String,
                imagen: String):this(){
                    this.id = id
                    this.nombre = nombre
                    this.precio = precio
                    this.descripcion = descripcion
                    this.categoria = categoria
                    this.imagen = imagen
                }
}