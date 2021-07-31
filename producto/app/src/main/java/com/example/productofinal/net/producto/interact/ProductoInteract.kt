package com.example.productofinal.net.producto.interact

import com.example.productofinal.net.RetrofitConfiguration
import com.example.productofinal.net.producto.ProductoEndPoint
import com.example.productofinal.net.producto.callback.ProductoCallback
import com.example.productofinal.net.producto.response.ProductoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductoInteract {

    private val retrofit =
        RetrofitConfiguration.getConfiguration().create(ProductoEndPoint::class.java)

    fun getProductosList(callback: ProductoCallback) {
        val call = retrofit.getProductos()
        call.enqueue(object : Callback<ProductoResponse> {
            override fun onResponse(call: Call<ProductoResponse>, response: Response<ProductoResponse>) {
                val body = response.body()
                if (body != null) {
                    callback.getProductoOtherSuccess(body)
                }
            }

            override fun onFailure(call: Call<ProductoResponse>, t: Throwable) {
                callback.getProductoOtherError("Error: ${t.message}")
            }
        })
    }
}