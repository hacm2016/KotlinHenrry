package com.example.productofinal.ui.login.views

import com.example.productofinal.ui.BaseView

interface LoginView : BaseView {
    fun goToHome()
    fun goToSignUp()
    fun getUsername(): String
    fun getPassword(): String
    fun printMessage(value: String)
    fun showUsernameErrorMessage(message: String)
    fun hideUsernameErrorMessage()
    fun showPasswordErrorMessage(message: String)
    fun hidePasswordErrorMessage()
    fun showErrorMessage(message: String)
}