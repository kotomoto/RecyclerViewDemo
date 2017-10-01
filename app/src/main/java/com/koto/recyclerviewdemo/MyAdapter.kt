package com.koto.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_title_with_image.view.*


class MyAdapter(val items: List<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(items[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.list_item_title_with_image))

    override fun getItemCount(): Int = items.size
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
        list_item_title.text = item.title
        list_item_image.loadUrl(item.url)
        setOnClickListener { listener(item) }
    }
}

fun ViewGroup.inflate(layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.loadUrl(url: String) = Picasso.with(context).load(url).into(this)