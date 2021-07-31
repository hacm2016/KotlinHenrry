package com.example.productofinal.ui.signup.presenter

import com.example.productofinal.R
import com.example.productofinal.database.AppDatabase
import com.example.productofinal.database.Usuario
import com.example.productofinal.ui.BasePresenter
import com.example.productofinal.ui.signup.views.SignUpView
import org.jetbrains.anko.doAsync

class SignUpPresenter : BasePresenter<SignUpView> {
    lateinit var view: SignUpView
   // lateinit var interact: SignUpInteract

    override fun init(view: SignUpView) {
        this.view = view
      //  interact = SignUpInteract()
    }

    fun validateFields() {
        val username = view.getUsername()
        val name = view.getName()
        val lastName = view.getLastName()
        val address = view.getAddress()
        val password = view.getPassword()
        val mail = view.getMail()
        val phone = view.getPhone()

        view.showLoading("")
      //  interact.signUp(this, username, name, lastName, mail, password, phone, address)

        doAsync {
            val database = AppDatabase.getInstance(view.getContext())
            val person = Usuario()
            person.username = username
            person.name = name
            person.lastName = lastName
            person.address = address
            person.password = password
            person.email = mail
            person.phone = phone
            database.usuarioDao().insert(person)

        }
        view.signUpSuccess(
            view.getContext().getString(R.string.str_title_sign_up),
            view.getContext().getString(R.string.msg_sign_up_success)
        )
    }

    fun goToHome() {
        view.goToHome()
    }


/*
    override fun onSignUpError(message: String) {
        view.hideLoading()
        view.showErrorMessage(message)
    }
*/
}