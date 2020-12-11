package com.example.apirestdemohector.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.apirestdemohector.R
import com.example.apirestdemohector.viewModel.viewModels.ShowOneViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.show_all_photos_recycler_item.*


class ShowOnePhotoFragment : Fragment(R.layout.show_all_photos_recycler_item) {

    private val viewModel by viewModels<ShowOneViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.photoLiveData(5).observe(viewLifecycleOwner) { photo ->
            // Check if the result of the search is null or not
            photo?.let { photo ->

                show_all_photos_recycler_item_title.text = photo.title
                show_all_photos_recycler_item_id.text = photo.id.toString()
                show_all_photos_recycler_item_album_id.text = photo.albumId.toString()
                Picasso.get().load(photo.thumbnailUrl).into(show_all_photos_recycler_item_image)

            }
        }
    }
}