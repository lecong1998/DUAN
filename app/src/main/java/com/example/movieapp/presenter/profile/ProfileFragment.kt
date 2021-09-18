package com.example.movieapp.presenter.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieapp.R
import com.example.movieapp.data.model.User
import com.example.movieapp.data.repository.UserRepository
import com.example.movieapp.presenter.HomeActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ProfileContract.View {
    private lateinit var presenter: ProfileContract.Presenter
    private val updateListener = object : UpdateDialogListener {
        override fun onConfirmButtonClicked(user: User) {
            presenter.updateUser(user)
        }
    }
    private val passwordListener = object : ChangePassDialogListener {
        override fun onConfirmButtonClicked(user: User) {
            presenter.updateUser(user)
        }
    }
    lateinit var user_update: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ProfilePresenter(this, UserRepository(requireContext()))
        presenter.getUser()
        initAction()
    }

    private fun initAction() {
        btn_edit_profile.setOnClickListener {
            val updateFrag = DialogUpdateFrag(user_update)
            updateFrag.setDialogListener(updateListener)
            // show thì show 1 cái dialog vừa màn hình
            updateFrag.show(childFragmentManager, DialogUpdateFrag::class.java.name)
        }
        btn_change_pw.setOnClickListener {
            val changeDialog = ChangePasswordFrag(user_update)
            changeDialog.set_change_DialogListener(passwordListener)
            changeDialog.show(childFragmentManager, ChangePasswordFrag::class.java.name)
        }
        btn_log_out.setOnClickListener {
            presenter.logout()
            val intent = Intent(requireContext(), HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun updateViewData(user: User) {
        fullname.text = user.fullname
        user_update = user
    }

}