package com.example.productofinal.ui.lateral.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.productofinal.databinding.ItemProductoBinding
import com.example.productofinal.ui.lateral.model.ProductoModel

class ProductoListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: ItemProductoBinding
    private val productos = ArrayList<ProductoModel>()
    lateinit var callback: ProductoListCallback

    inner class ProductoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val producto = productos[position]

            binding.textViewNombre.text = producto.name
            binding.textViewDescripcion.text = producto.description
            binding.textViewPrecio.text = producto.price
            Glide.with(itemView).load(producto.urlImage).into(binding.imageViewIcono)

            binding.root.setOnClickListener {
                callback.onItemSelected(producto)
            }
        }
    }

    fun setProductoListCallback(callback: ProductoListCallback) {
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context))
        return ProductoListViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductoListViewHolder) {
            holder.bind(position)
        }
    }

    override fun getItemCount(): Int {
        return productos.size
    }

    fun addAll(productos: ArrayList<ProductoModel>) {
        this.productos.addAll(productos)
        notifyDataSetChanged()
    }
}


interface ProductoListCallback {
    fun onItemSelected(producto: ProductoModel)
}