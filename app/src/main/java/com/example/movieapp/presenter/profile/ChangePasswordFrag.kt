package com.example.movieapp.presenter.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.movieapp.R
import com.example.movieapp.data.model.User
import kotlinx.android.synthetic.main.dialog_frag_changepass.*

class ChangePasswordFrag(val user: User): DialogFragment() {
    private var change_dialogListener:ChangePassDialogListener?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_frag_changepass,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
        getAction()
    }

    private fun getAction() {
        btn_change_new_pass.setOnClickListener{
            val pass_old = old_pass_change.text.toString()
            val pass_new = new_pass_change.text.toString()
            val conf_pass_new = confirm_new_pass_change.text.toString()
            if(pass_old != user.password)
                Toast.makeText(requireContext(),"Incorrect password", Toast.LENGTH_SHORT).show()
            else if(pass_new!= conf_pass_new){
                Toast.makeText(requireContext(),"Not match password", Toast.LENGTH_LONG).show() }
            else {
                user.password = pass_new
                change_dialogListener?.onConfirmButtonClicked(user)
                dismiss() }

        }
        btn_change_pass_cancel.setOnClickListener{
            dismiss()
        }
    }
    fun set_change_DialogListener(listener: ChangePassDialogListener) {
        this.change_dialogListener = listener
    }
}
interface ChangePassDialogListener{
    fun onConfirmButtonClicked(user: User)
}