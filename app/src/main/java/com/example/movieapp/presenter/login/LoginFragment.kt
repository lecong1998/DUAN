package com.example.movieapp.presenter.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.movieapp.presenter.MainActivity
import com.example.movieapp.R
import com.example.movieapp.data.repository.UserRepository
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(),LoginContract.View {
    private lateinit var presenter : LoginContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoginPresenter(this, UserRepository(this.requireContext()))

        login_fragment_btn_login.setOnClickListener {

            val username = login_fragment_edt_username.text.toString()
            val password = login_fragment_edt_password.text.toString()

            presenter.checkLogin(username,password)



        }

        login_fragment_btn_register.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }

    override fun showMessage(message: String) {
        Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
        if (message=="Login success"){
            activity?.let{
                val intent = Intent (getActivity() , MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}