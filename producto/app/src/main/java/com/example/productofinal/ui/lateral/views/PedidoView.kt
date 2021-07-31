package com.example.productofinal.ui.lateral.views

import com.example.productofinal.database.Pedido
import com.example.productofinal.net.producto.response.ProductoDataResponse
import com.example.productofinal.ui.FragmentBaseView

interface PedidoView : FragmentBaseView {

    fun traerLista(lista: List<Pedido>)
    fun getPedidosAll(listPedido: ArrayList<Pedido>)
}