package com.example.apirestdemohector.view.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.apirestdemohector.R

class EnterPhotoIDDialog: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.isCancelable = false //Prevents the dialog from closing when touching outside, or pressing back button

        val dialogView = inflater.inflate(R.layout.dialog_enter_photo_id, container, false)
        val okButton = dialogView.findViewById(R.id.dialog_enter_photo_id_button_ok) as Button
        val dismissButton = dialogView.findViewById(R.id.dialog_enter_photo_id_button_dismiss) as Button
        val editText = dialogView.findViewById(R.id.dialog_enter_photo_id_edit_text) as EditText

        dismissButton.setOnClickListener {
            dismiss()
        }

        okButton.setOnClickListener {
            editText.text?.let { editText ->
                //if the user has entered some id, then we will load the photo matching that id

                //aqui tengo que usar safeargs para pasar el edittext.text como argumento

                findNavController().navigate(R.id.action_startFragment_to_showOnePhotoFragment)
            }
        }

        return dialogView
    }

}