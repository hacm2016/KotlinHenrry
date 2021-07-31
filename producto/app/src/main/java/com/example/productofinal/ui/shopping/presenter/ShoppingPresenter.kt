package com.example.productofinal.ui.shopping.presenter

import com.example.productofinal.R
import com.example.productofinal.database.*
import com.example.productofinal.helpers.SharedPreferenceHelper
import com.example.productofinal.ui.BasePresenter
import com.example.productofinal.ui.lateral.model.ProductoModel
import com.example.productofinal.ui.lateral.views.ProductoView
import com.example.productofinal.ui.shopping.views.ShoppingView
import org.jetbrains.anko.doAsync

class ShoppingPresenter : BasePresenter<ShoppingView> {
    lateinit var view: ShoppingView

    override fun init(view: ShoppingView) {
        this.view = view
    }


    fun ListarTempShopping(username: String) {

       // view.showLoading("")
        doAsync {
            val database = AppDatabase.getInstance(view.getFragmentContext())
            var producto = Producto()
            var tempprod = Producto()

            //buscando si existe el pedido en la tabla temporal
            var tempPedido = TempPedido()
            var tempDetPedido = TempDetallePedido()
            var tempListDetPedido = ArrayList<TempDetallePedido>()
            val productos = ArrayList<Producto>()
            tempPedido=database.tempPedidoDao().gettemppedidouser(username)

            if(tempPedido!=null)
            {
                // buscando detalle del  temppedido
                tempListDetPedido= database.tempPedidoDao().gettempdetalle(tempPedido.idtemppedido) as ArrayList<TempDetallePedido>

                if(!tempListDetPedido.isEmpty())
                {    //buscando los productos del pedido
                    for(item in tempListDetPedido) {

                        val prod= database.productDao().getproductoid(item.idproducto)

                        if (prod != null) {
                            productos.add(prod)
                        }

                    }


                }

            }

        view.getTempShopping(tempPedido,productos)

        }

    }



    fun GuardarShopping(username: String) {

        // view.showLoading("")
        doAsync {
            val database = AppDatabase.getInstance(view.getFragmentContext())
            var producto = Producto()
            var tempprod = Producto()

            //buscando si existe el pedido en la tabla temporal
            var tempPedido = TempPedido()
            var pedido = Pedido()
            var pedidoaux = Pedido()
            var tempDetPedido = TempDetallePedido()
            var tempListDetPedido = ArrayList<TempDetallePedido>()
            val productos = ArrayList<Producto>()
            //buscamos el pedido
            tempPedido=database.tempPedidoDao().gettemppedidouser(username)

            if(tempPedido!=null)
            {
                //grabamos el pedido
                pedidoaux.igv=tempPedido.igv
                pedidoaux.subtotal=tempPedido.subtotal
                pedidoaux.total=tempPedido.total
                pedidoaux.username=tempPedido.username
                var id=database.pedidoDao().insert(pedidoaux)
                // buscando detalle del  temppedido
                tempListDetPedido= database.tempPedidoDao().gettempdetalle(tempPedido.idtemppedido) as ArrayList<TempDetallePedido>

                if(!tempListDetPedido.isEmpty())
                {    //
                    for(item in tempListDetPedido) {

                        var detpedidoaux = DetallePedido()
                        detpedidoaux.idpedido= id.toInt()
                        detpedidoaux.idproducto=item.idproducto
                        database.pedidoDao().insertDetalle(detpedidoaux)


                    }


                }

            }

           //eliminando las tablas temporales
            database.tempPedidoDao().delete(tempPedido)
            for(item in tempListDetPedido) {

                database.tempPedidoDao().deletedetalle(item)


            }
            view.signUpSuccess(
                view.getFragmentContext().getString(R.string.str_title_sign_up),
                view.getFragmentContext().getString(R.string.msg_sign_up_success)
            )


        }

    }

    fun goToHome() {
        view.goToHome()
    }
}