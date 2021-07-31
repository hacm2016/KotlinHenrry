package com.example.productofinal.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Producto {

    @PrimaryKey(autoGenerate = true)
    var idproducto: Int = 0

    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "description")
    var description: String = ""

    @ColumnInfo(name = "urlImage")
    var urlImage: String = ""

    @ColumnInfo(name = "price")
    var price:  Double = 0.0



}