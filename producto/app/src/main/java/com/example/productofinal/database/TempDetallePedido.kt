package com.example.productofinal.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TempDetallePedido {

    @PrimaryKey(autoGenerate = true)
    var idtempdetallepedido: Int = 0

    @ColumnInfo(name = "idtemppedido")
    var idtemppedido: Int = 0

    @ColumnInfo(name = "idproducto")
    var idproducto: Int = 0

}