package com.example.productofinal.ui.login.activities

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.productofinal.R
import com.example.productofinal.databinding.ActivityLoginBinding
import com.example.productofinal.databinding.LoadingBinding
import com.example.productofinal.ui.lateral.DrawerLateralActivity
import com.example.productofinal.ui.login.presenter.LoginPresenter
import com.example.productofinal.ui.login.views.LoginView
import com.example.productofinal.ui.signup.activities.SignUpActivity

class LoginActivity : AppCompatActivity() , LoginView {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter()
        presenter.init(this)
        hideLoading()
        binding.signUp.setOnClickListener {
            presenter.goToSignUp()
        }
        binding.login.setOnClickListener {
            presenter.validateFields()
        }
    }
    override fun goToHome() {
        val intent = Intent(this, DrawerLateralActivity::class.java)
        startActivity(intent)
    }

    override fun getUsername(): String {
        return binding.username.text.toString()
    }

    override fun getPassword(): String {
        return binding.password.text.toString()
    }

    override fun printMessage(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
    }

    override fun showUsernameErrorMessage(message: String) {
        binding.tilUsername.error = message
    }

    override fun hideUsernameErrorMessage() {
        binding.tilUsername.error = null
    }

    override fun showPasswordErrorMessage(message: String) {
        binding.tilPassword.error = message
    }

    override fun hidePasswordErrorMessage() {
        binding.tilPassword.error = null
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        binding.texerrorlogin.text="Usuario o clave incorrectos"
    }

    override fun getContext(): Context {
        return applicationContext
    }

    override fun showLoading(message: String) {
        val layout = LoadingBinding.bind(binding.loadingLayout.root)
        layout.loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        val layout = LoadingBinding.bind(binding.loadingLayout.root)
        layout.loading.visibility = View.GONE
    }
    override fun goToSignUp() {

        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)


    }


}