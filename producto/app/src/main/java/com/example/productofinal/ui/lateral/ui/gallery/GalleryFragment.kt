package com.example.productofinal.ui.lateral.ui.gallery

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
import com.example.productofinal.database.Pedido
import com.example.productofinal.databinding.FragmentGalleryBinding
import com.example.productofinal.databinding.FragmentHomeBinding
import com.example.productofinal.net.producto.response.ProductoDataResponse
import com.example.productofinal.ui.lateral.adapter.PedidoListAdapter
import com.example.productofinal.ui.lateral.adapter.PedidoListCallback
import com.example.productofinal.ui.lateral.adapter.ProductoListAdapter
import com.example.productofinal.ui.lateral.model.ProductoModel
import com.example.productofinal.ui.lateral.presenter.PedidoPresenter
import com.example.productofinal.ui.lateral.presenter.ProductoPresenter
import com.example.productofinal.ui.lateral.views.PedidoView
import com.example.productofinal.ui.lateral.views.ProductoView
import com.example.productofinal.ui.product_detail.activities.ProductoDetailActivity

//import com.example.productofinal.ui.lateral.R
//import com.example.productofinal.ui.lateral.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() , PedidoView,PedidoListCallback {

    lateinit var binding: FragmentGalleryBinding
    lateinit var presenter: PedidoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PedidoPresenter()
        presenter.init(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGalleryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadListaPedidos()
    }
    private fun loadListaPedidos() {

        presenter.ListarPedidos()


    }


    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun traerLista(lista: List<Pedido>) {

    }

    override fun getPedidosAll(listPedido: ArrayList<Pedido>) {
        val pedidos = ArrayList<Pedido>()

        val pedidoAdapter = PedidoListAdapter()
        pedidoAdapter.setPedidoListCallback(this)
        binding.frmpedidos.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.frmpedidos.adapter = pedidoAdapter
        pedidoAdapter.addAll(listPedido)
    }

    override fun getFragmentContext(): Context {
        return requireContext()
    }

    override fun onItemSelected(pedido: Pedido) {
      //  val intent = Intent(requireContext(), ProductoDetailActivity::class.java)
     //   intent.putExtra(KEY_PRODUCTO, pedido)
    //    startActivity(intent)
    }
    companion object {
        const val KEY_PRODUCTO = "prod"
    }
}
