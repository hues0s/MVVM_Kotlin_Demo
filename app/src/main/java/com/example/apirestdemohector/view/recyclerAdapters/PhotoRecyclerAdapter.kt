package com.example.apirestdemohector.view.recyclerAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apirestdemohector.R
import com.example.apirestdemohector.model.models.Photo
import com.squareup.picasso.Picasso

class PhotoRecyclerAdapter() :
    ListAdapter<Photo, PhotoRecyclerAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.show_all_photos_recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(photo: Photo) {
            itemView.findViewById<TextView>(R.id.show_all_photos_recycler_item_title).text = photo.title
            itemView.findViewById<TextView>(R.id.show_all_photos_recycler_item_id).text = photo.id.toString()
            itemView.findViewById<TextView>(R.id.show_all_photos_recycler_item_album_id).text = photo.albumId.toString()
            Picasso.get().load(photo.thumbnailUrl).into(itemView.findViewById<ImageView>(R.id.show_all_photos_recycler_item_image))
        }

    }

}

class TaskDiffCallback : DiffUtil.ItemCallback<Photo>() {

    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }

}