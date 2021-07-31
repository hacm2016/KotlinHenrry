package com.example.productofinal.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDao {

    @Insert
    fun insert(user: Usuario)

    @Query("select * from usuario where username=:user and password=:pass")
    fun validateUser(user: String, pass: String): Usuario

    @Query("select * from usuario where username=:username")
    fun existsUser(username: String): Usuario

    @Query("select * from usuario")
    fun getAllPerson(): List<Usuario>

}