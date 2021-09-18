package com.example.movieapp.presenter.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.movieapp.R
import com.example.movieapp.data.model.User
import kotlinx.android.synthetic.main.dialog_frag_update.*

class DialogUpdateFrag(val user: User) : DialogFragment() {
    private var dialogListener: UpdateDialogListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_frag_update,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
        fullname_update.setText(user.fullname)
        email_update.setText(user.email)
        country_update.setText(user.country)
        getAction()
    }

    private fun getAction() {
        btn_update.setOnClickListener{
            user.fullname = fullname_update.text.toString()
            user.email = email_update.text.toString()
            user.country = country_update.text.toString()
            dialogListener?.onConfirmButtonClicked(user)
            dismiss()
        }
        btn_cancel.setOnClickListener {dismiss()
        }
    }
    fun setDialogListener(listener: UpdateDialogListener) {
        this.dialogListener = listener
    }
}
interface UpdateDialogListener{
    fun onConfirmButtonClicked(user: User)
}