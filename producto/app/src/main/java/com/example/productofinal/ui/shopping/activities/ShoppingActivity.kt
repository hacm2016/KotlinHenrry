package com.example.productofinal.ui.shopping.activities

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.productofinal.R
import com.example.productofinal.database.Producto
import com.example.productofinal.database.TempPedido
import com.example.productofinal.databinding.ActivityShoppingBinding
import com.example.productofinal.databinding.ActivitySignUpBinding
import com.example.productofinal.helpers.SharedPreferenceHelper
import com.example.productofinal.ui.lateral.adapter.ProductoListCallback
import com.example.productofinal.ui.shopping.ShoppingListAdapter
import com.example.productofinal.ui.shopping.presenter.ShoppingPresenter
import com.example.productofinal.ui.shopping.views.ShoppingView

class ShoppingActivity : AppCompatActivity(){
    lateinit var binding: ActivityShoppingBinding
    lateinit var presenter: ShoppingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun loadTempShopping(username: String) {

        presenter.ListarTempShopping(username)


    }

    override fun onDestroy() {
        super.onDestroy()

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}