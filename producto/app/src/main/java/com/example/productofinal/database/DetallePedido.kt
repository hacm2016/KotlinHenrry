package com.example.productofinal.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class DetallePedido {

    @PrimaryKey(autoGenerate = true)
    var iddetallepedido: Int = 0

    @ColumnInfo(name = "idpedido")
    var idpedido: Int = 0

    @ColumnInfo(name = "idproducto")
    var idproducto: Int = 0
}