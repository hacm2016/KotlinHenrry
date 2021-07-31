package com.example.productofinal.ui.product_detail.presenter

import com.example.productofinal.R
import com.example.productofinal.database.*
import com.example.productofinal.ui.BasePresenter
import com.example.productofinal.ui.lateral.model.ProductoModel
import com.example.productofinal.ui.product_detail.views.ProductoDetailView
import org.jetbrains.anko.doAsync

class ProductoDetailPresenter : BasePresenter<ProductoDetailView> {
    lateinit var view: ProductoDetailView

    override fun init(view: ProductoDetailView) {
        this.view = view
    }

    fun crearShopping(prod: ProductoModel?,user: String) {


        view.showLoading("")
            doAsync {
            val database = AppDatabase.getInstance(view.getContext())
            var producto = Producto()
            var tempprod = Producto()
            tempprod=database.productDao().getproductoid(prod!!.id)
            if(tempprod==null) {
                //Producto(prod!!.id,prod!!.name,prod!!.description,prod!!.urlImage,prod!!.price.toDouble())
                producto.id = prod!!.id
                producto.name = prod!!.name
                producto.description = prod!!.description
                producto.urlImage = prod!!.urlImage
                producto.price = prod!!.price.toDouble()
                database.productDao().insert(producto)
            }
            else
            {
                producto=  tempprod

            }

            //buscando si existe el pedido en la tabla temporal
                 var tempPedido = TempPedido()
                 var tempPedidoAux = TempPedido()
                 var tempDetPedido = TempDetallePedido()
                 tempPedidoAux=database.tempPedidoDao().gettemppedidouser(user)

                 if(tempPedidoAux==null)
                 {
                     // grabando temppedido
                     tempPedido.username=user
                     tempPedido.subtotal=producto.price
                     tempPedido.igv=producto.price*0.19
                     tempPedido.total=producto.price + producto.price*0.19
                     database.tempPedidoDao().insert(tempPedido)
                    //Grabando detalle
                     tempPedido=database.tempPedidoDao().gettemppedidouser(user)
                     tempDetPedido.idtemppedido=tempPedido.idtemppedido
                     tempDetPedido.idproducto=producto.id
                     database.tempPedidoDao().insertDetalle(tempDetPedido)

                 }
                 else
                 {
                     //Grabando detalle
                     tempDetPedido.idtemppedido=tempPedidoAux.idtemppedido
                     tempDetPedido.idproducto=producto.id
                     database.tempPedidoDao().insertDetalle(tempDetPedido)
                     //calculando valores
                     //buscando los detalle del pedido
                     var listaTempDetPedido: ArrayList<TempDetallePedido>
                     listaTempDetPedido= database.tempPedidoDao().gettempdetalle(tempPedidoAux.idtemppedido) as ArrayList<TempDetallePedido>
                     var subtotal: Double=0.0
                     var igv: Double=0.0
                     var total: Double=0.0
                     for(item in listaTempDetPedido) {

                         val prod= database.productDao().getproductoid(item.idproducto)

                         if (prod != null) {
                             subtotal=subtotal + prod.price
                         }

                     }
                     igv=subtotal*0.19
                     total=subtotal + igv
                     // update shopping
                     tempPedidoAux.subtotal=subtotal
                     tempPedidoAux.total=total
                     tempPedidoAux.igv=igv
                     database.tempPedidoDao().update(tempPedidoAux)


                 }



       }
        goToShopping()
    }

    fun goToShopping() {
        view.goToShopping()
    }


}