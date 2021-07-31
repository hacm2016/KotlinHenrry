package com.example.productofinal.ui

import android.content.Context

interface BaseView {

    fun getContext(): Context
    fun showLoading(message: String)
    fun hideLoading()
}