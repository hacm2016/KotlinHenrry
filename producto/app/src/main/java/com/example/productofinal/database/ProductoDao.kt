package com.example.productofinal.database

import androidx.room.*

@Dao
interface ProductoDao {

    @Insert
    fun insert(prod: Producto)

    @Update
    fun update(prod: Producto)

    @Query("select * from producto where id=:id")
    fun getproductoid(id: Int): Producto

    @Query("select * from producto")
    fun getAllProducto(): List<Producto>


}