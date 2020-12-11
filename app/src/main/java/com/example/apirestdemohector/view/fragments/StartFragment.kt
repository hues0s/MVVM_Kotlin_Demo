package com.example.apirestdemohector.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apirestdemohector.R
import com.example.apirestdemohector.view.dialogs.EnterPhotoIDDialog
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment(R.layout.fragment_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_start_button_showall.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_showAllPhotosFragment)
        }

        fragment_start_button_showone.setOnClickListener {
            EnterPhotoIDDialog().show(parentFragmentManager, "enter photo id dialog")
        }

    }
}