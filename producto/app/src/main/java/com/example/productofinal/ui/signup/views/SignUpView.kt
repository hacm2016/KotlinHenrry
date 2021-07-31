package com.example.productofinal.ui.signup.views

import com.example.productofinal.ui.BaseView

interface SignUpView : BaseView {
    fun getUsername(): String
    fun getName(): String
    fun getLastName(): String
    fun getAddress(): String
    fun getPassword(): String
    fun getMail(): String
    fun getPhone(): String
    fun signUpSuccess(title: String, message: String)
    fun goToHome()
    fun showErrorMessage(message: String)
}
