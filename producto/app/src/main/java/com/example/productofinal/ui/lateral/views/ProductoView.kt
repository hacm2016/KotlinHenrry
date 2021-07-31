package com.example.productofinal.ui.lateral.views

import com.example.productofinal.net.producto.response.ProductoDataResponse
import com.example.productofinal.ui.FragmentBaseView

interface ProductoView : FragmentBaseView {

    fun traerLista(lista: List<ProductoDataResponse>)
}