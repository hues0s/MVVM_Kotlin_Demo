package com.example.apirestdemohector.view.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.apirestdemohector.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_show_big_photo.*

class ShowBigPhotoDialog(private val photoUrl: String) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.isCancelable = false // Prevents the dialog from closing when touching outside, or pressing back button

        val dialogView = inflater.inflate(R.layout.dialog_show_big_photo, container, false)
        val okButton = dialogView.findViewById(R.id.dialog_show_big_photo_button_ok) as Button
        Picasso
            .get()
            .load(photoUrl)
            .into(
                dialogView.findViewById<ImageView>(R.id.dialog_show_big_photo_imageView),
                object : com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        dialog_show_big_photo_progressBar.visibility = View.GONE
                    }
                    override fun onError(e: java.lang.Exception?) {
                        Toast.makeText(
                            dialogView.context,
                            "There was an error while loading the photo. Try again.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            )

        okButton.setOnClickListener {
            dismiss()
        }

        return dialogView
    }
}
