package com.example.productofinal.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class,Producto::class,TempPedido::class,TempDetallePedido::class,Pedido::class,DetallePedido::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun productDao(): ProductoDao
    abstract fun tempPedidoDao(): TempPedidoDao
    abstract fun pedidoDao(): PedidoDao
    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "producto")
                    .build()
            }
            return instance!!
        }
    }
}