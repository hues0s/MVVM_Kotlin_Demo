package com.example.apirestdemohector.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apirestdemohector.R
import com.example.apirestdemohector.model.models.Photo
import com.example.apirestdemohector.view.recyclerAdapters.PhotoRecyclerAdapter
import com.example.apirestdemohector.viewModel.viewModels.ShowAllViewModel
import kotlinx.android.synthetic.main.fragment_show_all_photos.*


class ShowAllPhotosFragment : Fragment(R.layout.fragment_show_all_photos) {

    private val viewModel by viewModels<ShowAllViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment_show_all_photos_recycler_view.apply {
            this.layoutManager = LinearLayoutManager(this.context)
            this.adapter = PhotoRecyclerAdapter()
        }

        viewModel.photoListLiveData.observe(viewLifecycleOwner) { photoList ->
            (fragment_show_all_photos_recycler_view.adapter as PhotoRecyclerAdapter).submitList(photoList)
        }

    }
}