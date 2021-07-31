package com.example.productofinal.ui.lateral.presenter

import com.example.productofinal.ui.BasePresenter
import com.example.productofinal.ui.lateral.views.SettingView

class SettingPresenter: BasePresenter<SettingView> {
    lateinit var view: SettingView

    override fun init(view: SettingView) {
        this.view = view
    }

    fun logout() {
       // val preferences=SharedPreferenceHelper()
    //    preferences.clearAll(view.getFragmentContext())

        view.goToLogin()
    }

}