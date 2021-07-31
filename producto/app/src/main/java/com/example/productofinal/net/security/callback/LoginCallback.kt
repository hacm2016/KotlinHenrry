package com.example.productofinal.net.security.callback

import com.example.productofinal.net.security.response.UserResponse

interface LoginCallback {

    fun onLoginSuccess(response: UserResponse)
    fun onLoginError(message: String)
}