package com.example.productofinal.ui.login.presenter

import com.example.productofinal.R
import com.example.productofinal.helpers.SharedPreferenceHelper
import com.example.productofinal.net.security.callback.LoginCallback
import com.example.productofinal.net.security.interact.LoginInteract
import com.example.productofinal.net.security.response.Data
import com.example.productofinal.net.security.response.UserResponse
import com.example.productofinal.ui.BasePresenter
import com.example.productofinal.ui.login.views.LoginView

class LoginPresenter : BasePresenter<LoginView> , LoginCallback {
    private lateinit var view: LoginView
    lateinit var interact: LoginInteract
    override fun init(view: LoginView) {
        this.view = view
        interact = LoginInteract()
      //  validateFields()
    }

    fun validateFields() {
        if (!isFieldsNotValid()) {
            view.showLoading("")
           // view.goToHome()
            interact.login(this, view.getUsername(), view.getPassword())
            /*
            doAsync {
                val database = AppDatabase.getInstance(view.getContext())
                val user = database.personDao().validateUser(view.getUsername(), view.getPassword())
                if (user != null) {
                    val preferences = SharedPreferenceHelper()
                    preferences.saveUsername(view.getContext(), view.getUsername())
                    uiThread {
                        view.goToHome()
                    }
                } else {
                    uiThread {
                        view.showErrorMessage("No existe el usuario.")
                    }
                }
            }

             */
        }
    }

    private fun isFieldsNotValid(): Boolean {
        var isNotValid = false
        val username = view.getUsername()
        val password = view.getPassword()

        if (username.isBlank()) {
            view.showUsernameErrorMessage(view.getContext().getString(R.string.err_username))
            isNotValid = true
        } else {
            view.hideUsernameErrorMessage()
        }
        if (password.isBlank()) {
            view.showPasswordErrorMessage(view.getContext().getString(R.string.err_password))
            isNotValid = true
        } else {
            view.hidePasswordErrorMessage()
        }
        return isNotValid
    }

    fun goToSignUp() {
        view.goToSignUp()
    }

    override fun onLoginSuccess(response: UserResponse) {
        view.hideLoading()
        if (response.status) {
            val user = response.data
            saveUsername(user)
            view.goToHome()
        } else {
            view.showErrorMessage("No existe el usuario")
        }
    }

    private fun saveUsername(user: Data) {
       val preferences = SharedPreferenceHelper()
        preferences.saveUsername(view.getContext(), user.user)
    }

    override fun onLoginError(message: String) {
        view.hideLoading()
        view.showErrorMessage("Error: $message")
    }


}