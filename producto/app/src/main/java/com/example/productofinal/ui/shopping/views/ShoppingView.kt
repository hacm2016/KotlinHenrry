package com.example.productofinal.ui.shopping.views

import com.example.productofinal.database.Producto
import com.example.productofinal.database.TempPedido
import com.example.productofinal.ui.BaseView
import com.example.productofinal.ui.FragmentBaseView
import java.util.ArrayList

interface ShoppingView : FragmentBaseView {

    fun getTempShopping(pedido: TempPedido,producto: ArrayList<Producto>)
    fun signUpSuccess(title: String, message: String)
    fun goToHome()
}