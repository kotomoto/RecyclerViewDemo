package com.koto.recyclerviewdemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = GridLayoutManager(this, 2)

        val item1 = Item(1, "First", "https://68.media.tumblr.com/avatar_17f83bf1ae10_128.png")
        val item2 = Item(2, "Second", "https://i.pinimg.com/736x/27/9d/02/279d0203193f94f9bd9d3c294432a2a0--baby-shower-yellow-rubber-duck.jpg")
        val item3 = Item(3, "Third", "https://pbs.twimg.com/profile_images/732153713272442880/RWrbuO-0.jpg")

        val items = listOf(item1, item2, item3)

        recycler.adapter = MyAdapter(items) {
            toast("${it.title} clicked")
        }
    }
}

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
