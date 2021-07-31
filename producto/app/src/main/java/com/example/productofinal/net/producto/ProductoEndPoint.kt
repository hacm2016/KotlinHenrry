package com.example.productofinal.net.producto

import com.example.productofinal.net.EndPoint
import com.example.productofinal.net.producto.response.ProductoResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductoEndPoint {

    @GET(EndPoint.GET_PRODUCTOS)
    fun getProductos(): Call<ProductoResponse>
}