package com.example.productofinal.ui.lateral.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productofinal.database.Pedido
import com.example.productofinal.databinding.ItemPedidoBinding

class PedidoListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var binding: ItemPedidoBinding
    private val pedidos = ArrayList<Pedido>()
    lateinit var callback: PedidoListCallback

    inner class PedidoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val pedido = pedidos[position]

            binding.textViewCodigo.text = pedido.idpedido.toString()
            binding.textViewSubtotal.text = pedido.subtotal.toString()
            binding.textViewigv.text = pedido.igv.toString()
            binding.textViewTot.text = pedido.total.toString()

            binding.root.setOnClickListener {
                callback.onItemSelected(pedido)
            }
        }
    }

    fun setPedidoListCallback(callback: PedidoListCallback) {
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        binding = ItemPedidoBinding.inflate(LayoutInflater.from(parent.context))
        return PedidoListViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PedidoListViewHolder) {
            holder.bind(position)
        }
    }

    override fun getItemCount(): Int {
        return pedidos.size
    }

    fun addAll(pedido: ArrayList<Pedido>) {
        this.pedidos.addAll(pedido)
        notifyDataSetChanged()
    }
}


interface PedidoListCallback {
    fun onItemSelected(pedido: Pedido)
}