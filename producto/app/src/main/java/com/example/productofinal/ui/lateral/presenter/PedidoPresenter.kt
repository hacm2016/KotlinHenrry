package com.example.productofinal.ui.lateral.presenter

import com.example.productofinal.database.*
import com.example.productofinal.net.producto.callback.ProductoCallback
import com.example.productofinal.net.producto.interact.ProductoInteract
import com.example.productofinal.ui.BasePresenter
import com.example.productofinal.ui.lateral.views.PedidoView
import com.example.productofinal.ui.lateral.views.ProductoView
import org.jetbrains.anko.doAsync

class PedidoPresenter : BasePresenter<PedidoView> {
    lateinit var view: PedidoView

    override fun init(view: PedidoView) {
        this.view = view

    }
    fun ListarPedidos() {

        // view.showLoading("")
        doAsync {
            val database = AppDatabase.getInstance(view.getFragmentContext())
            var listPedido = ArrayList<Pedido>()

            listPedido= database.pedidoDao().getpedido() as ArrayList<Pedido>



            view.getPedidosAll(listPedido)

        }

    }
}