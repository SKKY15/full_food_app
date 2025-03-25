package com.example.food_full_app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class FoodAdapter(
    val context : Context,
    val data: ArrayList<Food>,
) : RecyclerView.Adapter<FoodViewHolder>() {

    var onItemClick : ((Food) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
            return FoodViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.row_food, parent, false)
            )
    }

    override fun getItemCount(): Int {
        return data.size;
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = data[position]
        holder.foodname.text = data[position].foodname
        holder.fooddescription.text = data[position].fooddescripiton
        holder.price.text = data[position].price
        holder.image.setImageResource(R.drawable.hmbr)

        holder.itemView.setOnClickListener {
                    onItemClick?.invoke(food)
            }
    }

}