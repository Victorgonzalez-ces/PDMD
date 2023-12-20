package com.example.compras.model

import java.io.Serializable

class Producto(val title: String, val price: Int,val stock: Int, val description: String, val thumbnail: String,val images: ArrayList<String>): Serializable {

}