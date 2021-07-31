package com .example.productofinal.ui.lateral.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.productofinal.databinding.ActivityLoginBinding
import com.example.productofinal.databinding.FragmentHomeBinding
import com.example.productofinal.net.producto.response.ProductoDataResponse
import com.example.productofinal.ui.lateral.adapter.ProductoListAdapter
import com.example.productofinal.ui.lateral.adapter.ProductoListCallback
import com.example.productofinal.ui.lateral.model.ProductoModel
import com.example.productofinal.ui.lateral.presenter.ProductoPresenter
import com.example.productofinal.ui.lateral.views.ProductoView
import com.example.productofinal.ui.login.presenter.LoginPresenter
import com.example.productofinal.ui.product_detail.activities.ProductoDetailActivity

//import com.example.productofinal.ui.lateral.R
//import com.example.productofinal.ui.lateral.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), ProductoListCallback, ProductoView{

   // private lateinit var homeViewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding
    lateinit var presenter: ProductoPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ProductoPresenter()
        presenter.init(this)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadListaProductos()
    }
    private fun loadListaProductos() {

        presenter.ListarProductosInt()


    }


    override fun onDestroyView() {
        super.onDestroyView()
       // binding = null
    }
    override fun onItemSelected(producto: ProductoModel) {
        val intent = Intent(requireContext(), ProductoDetailActivity::class.java)
        intent.putExtra(KEY_PRODUCTO, producto)
        startActivity(intent)
    }

    override fun traerLista(lista: List<ProductoDataResponse>) {
        val productos = ArrayList<ProductoModel>()
        val productosdata = ArrayList<ProductoDataResponse>()
        val productoAdapter = ProductoListAdapter()
        productoAdapter.setProductoListCallback(this)
        binding.frmproductos.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.frmproductos.adapter = productoAdapter
        productosdata.addAll(lista)
        for(item in productosdata)
        {   val prod= ProductoModel(item.id,item.name,item.description,item.price,item.urlImage)

            if (prod != null) {
                productos.add(prod)
            }
        }

        productoAdapter.addAll(productos)
    }

    override fun getFragmentContext(): Context {
        return requireContext()
    }

    companion object {
        const val KEY_PRODUCTO = "prod"
    }
}