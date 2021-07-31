package com.example.productofinal.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Pedido {

    @PrimaryKey(autoGenerate = true)
    var idpedido: Int = 0

    @ColumnInfo(name = "username")
    var username: String = ""

    @ColumnInfo(name = "subtotal")
    var subtotal: Double = 0.0

    @ColumnInfo(name = "igv")
    var igv:  Double = 0.0

    @ColumnInfo(name = "total")
    var total:  Double = 0.0

}