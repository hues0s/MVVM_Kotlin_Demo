package com.example.apirestdemohector.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.apirestdemohector.R
import com.example.apirestdemohector.view.dialogs.ShowBigPhotoDialog
import com.example.apirestdemohector.viewModel.viewModels.ShowOneViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.show_all_photos_recycler_item.*

class ShowOnePhotoFragment : Fragment(R.layout.show_all_photos_recycler_item) {

    private val viewModel by viewModels<ShowOneViewModel>()
    private val args: ShowOnePhotoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argPhotoID = args.photoID

        viewModel.photoLiveData(argPhotoID).observe(viewLifecycleOwner) { photo ->
            // Check if the result of the search is null or not
            photo?.let { photoChecked ->

                show_all_photos_recycler_item_title.text = photoChecked.title
                show_all_photos_recycler_item_id.text = photoChecked.id.toString()
                show_all_photos_recycler_item_album_id.text = photoChecked.albumId.toString()
                Picasso.get().load(photoChecked.thumbnailUrl).into(show_all_photos_recycler_item_image)
                show_all_photos_recycler_item_cardview.setOnClickListener {
                    ShowBigPhotoDialog(photoChecked.url).show(parentFragmentManager, "show big photo")
                }
            }
        }

        viewModel.isPhotoLoadingLiveData.observe(viewLifecycleOwner) {
            if (it) {
                show_all_photos_recycler_item_progressBar.visibility = View.VISIBLE
                show_all_photos_recycler_item_album_id_textview.visibility = View.GONE
                show_all_photos_recycler_item_id_textview.visibility = View.GONE
            } else {
                show_all_photos_recycler_item_progressBar.visibility = View.GONE
                show_all_photos_recycler_item_album_id_textview.visibility = View.VISIBLE
                show_all_photos_recycler_item_id_textview.visibility = View.VISIBLE
            }
        }
    }
}
