package com.example.productofinal.net.producto.response

class ProductoResponse {
    var data: List<ProductoDataResponse>? = null
    var status: Boolean? = null
    var message: String? = null
}

class ProductoDataResponse {
    var id : Int= 0
    var name : String= ""
    var description : String= ""
    var price : String= ""
    var urlImage : String= ""
}