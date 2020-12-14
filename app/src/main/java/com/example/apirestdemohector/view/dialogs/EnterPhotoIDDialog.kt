package com.example.apirestdemohector.view.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.apirestdemohector.R
import com.example.apirestdemohector.utils.MAX_ID
import com.example.apirestdemohector.view.fragments.StartFragmentDirections

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
            val photoID = if (editText.text.toString() != "") Integer.valueOf(editText.text.toString()) else 1
            if(photoID > MAX_ID) {
                Toast.makeText(context, resources.getString(R.string.dialog_enter_photo_id_max_id_exceeded),
                        Toast.LENGTH_LONG).show()
            }
            else {
                val action = StartFragmentDirections.actionStartFragmentToShowOnePhotoFragment(photoID)
                findNavController().navigate(action)
                if (editText.text.toString() == "")
                    Toast.makeText(context, resources.getString(R.string.dialog_enter_photo_id_default_id_message),
                            Toast.LENGTH_LONG).show()
            }
            dismiss()
        }

        return dialogView
    }

}