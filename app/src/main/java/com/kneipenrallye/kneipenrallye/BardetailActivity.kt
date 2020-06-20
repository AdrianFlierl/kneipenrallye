package com.kneipenrallye.kneipenrallye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.internal.bind.TypeAdapters.URL
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_bar_detail.*
import kotlinx.android.synthetic.main.barlist_item.view.*

class BardetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_detail)

        val navBarTitle = intent.getStringExtra(CustomViewHolder.BAR_TITLE_KEY)
        supportActionBar?.title = navBarTitle


        val locationTextView: TextView = findViewById(R.id.txt_input_location) as TextView
        val locString = intent.getStringExtra(CustomViewHolder.BAR_LOCATION_KEY)
        locationTextView.text = locString


        val specialTextView: TextView = findViewById(R.id.txt_input_special) as TextView
        val specialString = intent.getStringExtra(CustomViewHolder.BAR_SPECIAL_KEY)
        specialTextView.text = specialString


        val barBigImageView: ImageView = findViewById(R.id.img_bar_big) as ImageView
        val barImageView = intent.getStringExtra(CustomViewHolder.BAR_IMAGE_KEY)
        Picasso.get().load(barImageView).fit().into(barBigImageView)
    }
}
