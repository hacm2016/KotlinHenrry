package com.example.productofinal.database

import androidx.room.*


@Dao
interface TempPedidoDao {

    @Insert
    fun insert(tempped: TempPedido)

    @Update
    fun update(tempped: TempPedido)

    @Delete
    fun delete(tempped: TempPedido)

    @Query("select * from TempPedido where username=:username")
    fun gettemppedidouser(username: String): TempPedido

    @Query("select * from tempdetallepedido where idtemppedido=:idtemppedido")
    fun gettempdetalle(idtemppedido: Int): List<TempDetallePedido>

    @Insert
    fun insertDetalle(tempdetalle: TempDetallePedido)

    @Delete
    fun deletedetalle(empdetalle: TempDetallePedido)

}