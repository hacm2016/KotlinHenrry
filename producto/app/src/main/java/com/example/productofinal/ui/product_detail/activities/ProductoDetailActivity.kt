package com.example.productofinal.ui.product_detail.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.productofinal.R
import com.example.productofinal.databinding.ActivityProductoDetailBinding
import com.example.productofinal.helpers.SharedPreferenceHelper
import com.example.productofinal.ui.lateral.DrawerLateralActivity
import com.example.productofinal.ui.lateral.model.ProductoModel
import com.example.productofinal.ui.product_detail.presenter.ProductoDetailPresenter
import com.example.productofinal.ui.product_detail.views.ProductoDetailView
import com.example.productofinal.ui.shopping.activities.ShoppingActivity

class ProductoDetailActivity : AppCompatActivity() , ProductoDetailView{
    lateinit var binding: ActivityProductoDetailBinding
    lateinit var presenter: ProductoDetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = ProductoDetailPresenter()
        presenter.init(this)

        if (intent.hasExtra("prod")) {

            val preferences = SharedPreferenceHelper()
            val username=  preferences.getUsername(this)

            val producto = intent.getParcelableExtra<ProductoModel>("prod")
            binding.textViewNombreProd.text = producto?.name
            binding.textViewDescripcion.text = producto?.description
            binding.textViewDescripcion.justificationMode
            binding.textViewPrecio.text = producto?.price
           // Glide.with(itemView).load(producto.urlImage).into(binding.imageViewIcono)
            Glide.with(this).load(producto?.urlImage).into(binding.imageViewIcono)

            binding.btnagregar.setOnClickListener {
                presenter.crearShopping(producto,username)
            }


        } else {

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun goToShopping() {

        val intent = Intent(this, ShoppingActivity::class.java)
        startActivity(intent)


    }

    override fun getContext(): Context {
        return this
    }

    override fun showLoading(message: String) {

    }
    override fun hideLoading() {

    }
}