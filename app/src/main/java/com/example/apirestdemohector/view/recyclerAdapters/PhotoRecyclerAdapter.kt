package com.example.apirestdemohector.view.recyclerAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apirestdemohector.R
import com.example.apirestdemohector.model.models.Photo
import com.example.apirestdemohector.view.dialogs.ShowBigPhotoDialog
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_show_big_photo.*
import kotlinx.android.synthetic.main.show_all_photos_recycler_item.*

class PhotoRecyclerAdapter(private val fragmentManager: FragmentManager) :
    ListAdapter<Photo, PhotoRecyclerAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.show_all_photos_recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), fragmentManager)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(photo: Photo, fragmentManager: FragmentManager) {
            itemView.findViewById<TextView>(R.id.show_all_photos_recycler_item_title).text = photo.title
            itemView.findViewById<TextView>(R.id.show_all_photos_recycler_item_id).text = photo.id.toString()
            itemView.findViewById<TextView>(R.id.show_all_photos_recycler_item_album_id).text = photo.albumId.toString()
            Picasso.get().load(photo.thumbnailUrl).into(itemView.findViewById<ImageView>(R.id.show_all_photos_recycler_item_image))
            itemView.findViewById<CardView>(R.id.show_all_photos_recycler_item_cardview).setOnClickListener {
                ShowBigPhotoDialog(photo.url).show(fragmentManager, "show big photo")
            }
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