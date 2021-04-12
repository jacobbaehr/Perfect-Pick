package com.example.algorithmsanonymous

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_place.view.*

class PlacesAdapter(val context: Context, private val places: List<YelpPlaces>, val listener: OnItemClickListener) :
        RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_place, parent, false))
    }

    override fun getItemCount() = places.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        fun bind(place: YelpPlaces) {
            itemView.tvName.text = place.name
            itemView.ratingBar.rating = place.rating.toFloat()
            itemView.tvNumReviews.text = "${place.numReviews} Reviews"
            itemView.tvAddress.text = place.location.address
            itemView.tvCategory.text = place.categories[0].title
            itemView.tvDistance.text = place.displayDistance()
            itemView.tvPrice.text = place.price
            Glide.with(context).load(place.imageUrl).apply(RequestOptions().transforms(
                    CenterCrop(), RoundedCorners(20)
            )).into(itemView.imageView)
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}
