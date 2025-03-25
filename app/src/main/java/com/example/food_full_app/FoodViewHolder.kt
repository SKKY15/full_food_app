package com.example.food_full_app

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.burgerimage)
        val foodname = itemView.findViewById<TextView>(R.id.maintitle)
        val fooddescription = itemView.findViewById<TextView>(R.id.secondtitle)
        val price = itemView.findViewById<TextView>(R.id.price)
}