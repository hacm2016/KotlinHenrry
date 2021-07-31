package com.example.productofinal.ui

interface BasePresenter <T> {
    fun init(view: T)
}