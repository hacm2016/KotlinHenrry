package com.example.productofinal.ui.signup.activities

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.productofinal.R
import com.example.productofinal.databinding.ActivitySignUpBinding
import com.example.productofinal.ui.lateral.DrawerLateralActivity
import com.example.productofinal.ui.login.activities.LoginActivity
import com.example.productofinal.ui.signup.presenter.SignUpPresenter
import com.example.productofinal.ui.signup.views.SignUpView

class SignUpActivity : AppCompatActivity(), SignUpView {
    lateinit var presenter: SignUpPresenter
    lateinit var binding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = getString(R.string.str_register)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = SignUpPresenter()
        presenter.init(this)

        binding.signUp.setOnClickListener {
            presenter.validateFields()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getUsername(): String {
        return binding.username.text.toString()
    }

    override fun getName(): String {
        return binding.name.text.toString()
    }

    override fun getLastName(): String {
        return binding.lastName.text.toString()
    }

    override fun getAddress(): String {
        return binding.address.text.toString()
    }

    override fun getPassword(): String {
        return binding.password.text.toString()
    }

    override fun getMail(): String {
        return binding.mail.text.toString()
    }

    override fun getPhone(): String {
        return binding.phone.text.toString()
    }

    override fun signUpSuccess(title: String, message: String) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setPositiveButton(getString(R.string.str_ok)) { dialogInterface: DialogInterface, i: Int ->
            presenter.goToHome()
        }
        dialog.show()
    }

    override fun goToHome() {
        val intent = Intent(this, DrawerLateralActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun getContext(): Context {
        return applicationContext
    }

    override fun showLoading(message: String) {

    }

    override fun hideLoading() {

    }
}