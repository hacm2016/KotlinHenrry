package com.example.productofinal.ui.shopping.activities

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.productofinal.R
import com.example.productofinal.database.Producto
import com.example.productofinal.database.TempPedido
import com.example.productofinal.databinding.FragmentShopingBinding
import com.example.productofinal.helpers.SharedPreferenceHelper
import com.example.productofinal.ui.lateral.DrawerLateralActivity
import com.example.productofinal.ui.shopping.ShoppingListAdapter
import com.example.productofinal.ui.shopping.ShoppingListCallback
import com.example.productofinal.ui.shopping.presenter.ShoppingPresenter
import com.example.productofinal.ui.shopping.views.ShoppingView
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShopingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShopingFragment : Fragment() , ShoppingListCallback, ShoppingView {
    lateinit var binding: FragmentShopingBinding
    lateinit var presenter: ShoppingPresenter
    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = ShoppingPresenter()
        presenter.init(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShopingBinding.inflate(inflater)
        recyclerView= binding.tempshopping

        binding.btnShopping.setOnClickListener {
            val preferences = SharedPreferenceHelper()
            val username=  preferences.getUsername(requireContext())
            presenter.GuardarShopping(username)
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val preferences = SharedPreferenceHelper()
        val username=  preferences.getUsername(requireContext())
        loadTempShopping(username)


    }
    private fun loadTempShopping(username: String) {

        presenter.ListarTempShopping(username)


    }


    override fun getTempShopping(pedido: TempPedido, producto: ArrayList<Producto>) {

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.hasFixedSize()
        val shoppingAdapter = ShoppingListAdapter()
        shoppingAdapter.setShoppingListCallback(this)
        recyclerView.adapter = shoppingAdapter
        binding.textViewSubTotal.text= pedido.subtotal.toString()
        binding.textViewIgv.text= pedido.igv.toString()
        binding.textViewTotal.text= pedido.total.toString()
        shoppingAdapter.addAll(producto)
    }

    override fun signUpSuccess(title: String, message: String) {

            presenter.goToHome()

    }

    override fun goToHome() {

        requireContext().let{
            it.startActivity(Intent(it, DrawerLateralActivity::class.java))
           // it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
          //  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        //    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }


    }

    override fun getFragmentContext(): Context {
        return requireContext()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        // binding = null
    }

    override fun onItemSelected(producto: Producto) {
        // val intent = Intent(this, ProductoDetailActivity::class.java)
        // intent.putExtra(HomeFragment.KEY_PRODUCTO, producto)
        //startActivity(intent)
    }

}