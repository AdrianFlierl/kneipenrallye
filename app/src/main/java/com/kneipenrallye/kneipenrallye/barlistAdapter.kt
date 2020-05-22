package com.kneipenrallye.kneipenrallye

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.barlist_item.view.*

class barlistAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>(){

    val barTitle = listOf("First title", "Second", "3rd", "MOOOOORE TITLE", "MONO", "Test", "test2")
    val bar_description = listOf("First title", "Second", "3rd", "MOOOOORE TITLE", "MONO", "Test", "test2")

    // numberOfItems
    override fun getItemCount(): Int {
        return homeFeed.bars.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        // how do we even create a view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.barlist_item, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //val bar = barTitle.get(position)
        val barObj = homeFeed.bars.get(position)
        holder.view.txt_bar_name?.text = barObj.name
        holder.view.txt_bar_description?.text = barObj.description

        val barImageView = holder.view.imgView_bar
        Picasso.get().load(barObj.link).into(barImageView)
    }

}


class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            println("Clicked on Viewholder")

            val intent = Intent(view.context, barDetailActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}
