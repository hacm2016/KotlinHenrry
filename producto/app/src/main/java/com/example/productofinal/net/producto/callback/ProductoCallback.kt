package com.example.productofinal.net.producto.callback

import com.example.productofinal.net.producto.response.ProductoDataResponse
import com.example.productofinal.net.producto.response.ProductoResponse

interface ProductoCallback {

    fun getProductoOtherSuccess(response: ProductoResponse)
    fun getProductoOtherError(message: String)
}