package com.example.productofinal.ui.lateral.ui.slideshow

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.productofinal.databinding.FragmentHomeBinding
import com.example.productofinal.databinding.FragmentSlideshowBinding
import com.example.productofinal.ui.lateral.presenter.SettingPresenter
import com.example.productofinal.ui.lateral.ui.home.HomeViewModel
import com.example.productofinal.ui.lateral.views.SettingView
import com.example.productofinal.ui.login.activities.LoginActivity
import com.example.productofinal.ui.login.presenter.LoginPresenter

//import com.example.productofinal.ui.lateral.R
//import com.example.productofinal.ui.lateral.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment(), SettingView {

    private lateinit var slideshowViewModel: SlideshowViewModel
    private var _binding: FragmentSlideshowBinding? = null
    private lateinit var presenter: SettingPresenter
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        validateLogout()

        return root
    }

    private fun validateLogout() {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("Confirmación")
        dialog.setMessage("Está seguro de salir de la sesión?")
        dialog.setPositiveButton("Salir") { d, i ->
            presenter.logout()
        }
        dialog.setNegativeButton("No") { d, i ->
            d.dismiss()
        }
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun goToLogin() {
        val intent = Intent(getFragmentContext(), LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    override fun getFragmentContext(): Context {
        return requireContext()
    }
}