package com.example.productofinal.ui.shopping

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.productofinal.database.Producto
import com.example.productofinal.databinding.ItemProductoBinding
import com.example.productofinal.databinding.ItemShoppingBinding
import com.example.productofinal.ui.lateral.adapter.ProductoListAdapter
import com.example.productofinal.ui.lateral.adapter.ProductoListCallback
import com.example.productofinal.ui.lateral.model.ProductoModel

class ShoppingListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var binding: ItemShoppingBinding
    private val productos = ArrayList<Producto>()
    lateinit var callback: ShoppingListCallback

    inner class ShoppingListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val producto = productos[position]

            binding.textViewNombreDet.text = producto.name
            binding.textViewDescripcion.text = producto.description
            binding.textViewPrecio.text = producto.price.toString()
            Glide.with(itemView).load(producto.urlImage).into(binding.imageViewIcono)

            binding.root.setOnClickListener {
                callback.onItemSelected(producto)
            }
        }
    }

    fun setShoppingListCallback(callback: ShoppingListCallback) {
        this.callback = callback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemShoppingBinding.inflate(LayoutInflater.from(parent.context))
        return ShoppingListViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ShoppingListAdapter.ShoppingListViewHolder) {
            holder.bind(position)
        }
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    fun addAll(productos: ArrayList<Producto>) {
        this.productos.addAll(productos)
        notifyDataSetChanged()
    }
}

interface ShoppingListCallback {
    fun onItemSelected(producto: Producto)

}