package com.example.productofinal.net.security.response

data class UserResponse (
    val data: Data,
    val status: Boolean,
    val message: String
)

data class Data (
    val id: Long,
    val name: String,
    val lastName: String,
    val user: String,
    val password: String,
    val email: String,
    val address: String,
    val phone: String
)
