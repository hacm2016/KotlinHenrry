package com.example.productofinal.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface PedidoDao {

    @Insert
    fun insert(tempped: Pedido): Long

    @Update
    fun update(tempped: Pedido)

    @Query("select * from Pedido where username=:username")
    fun getpedidouser(username: String): Pedido

    @Query("select * from detallepedido where idpedido=:idpedido")
    fun getdetalle(idpedido: Int): List<DetallePedido>

    @Query("select * from pedido ")
    fun getpedido(): List<Pedido>

    @Insert
    fun insertDetalle(tempdetalle: DetallePedido)
}