package com.example.productofinal.ui.lateral.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductoModel(

    var id: Int,
    var name: String,
    var description: String,
    var price : String,
    var urlImage : String
): Parcelable