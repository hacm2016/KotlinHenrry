package com.example.productofinal.ui.lateral.presenter

import com.example.productofinal.net.producto.callback.ProductoCallback
import com.example.productofinal.net.producto.interact.ProductoInteract
import com.example.productofinal.net.producto.response.ProductoDataResponse
import com.example.productofinal.net.producto.response.ProductoResponse
import com.example.productofinal.net.security.interact.LoginInteract
import com.example.productofinal.ui.BasePresenter
import com.example.productofinal.ui.lateral.views.ProductoView

class ProductoPresenter : BasePresenter<ProductoView> , ProductoCallback{
    lateinit var view: ProductoView
    lateinit var interact: ProductoInteract
    override fun init(view: ProductoView) {
        this.view = view
        interact = ProductoInteract()
    }

    fun ListarProductosInt() {

            interact.getProductosList(this)


    }

    override fun getProductoOtherSuccess(response: ProductoResponse) {
        var productosdata = ArrayList<ProductoDataResponse>()
        if (response.status == true) {

            productosdata = response.data as ArrayList<ProductoDataResponse>

            view.traerLista(productosdata)

        } else {
           ""
        }
    }

    override fun getProductoOtherError(message: String) {
        TODO("Not yet implemented")
    }
}