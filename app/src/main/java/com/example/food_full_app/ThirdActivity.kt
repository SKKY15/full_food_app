package com.example.food_full_app

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.food_full_app.databinding.ActivityThirdBinding
import java.util.ArrayList

class ThirdActivity : AppCompatActivity() {
        lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val Foods = ArrayList<Food>()
        Foods.add(Food("Cheese Burger 3","Cheese with 3 fromages","2$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 2","Cheese with 2 fromages","7.5$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 5","Cheese with 5 fromages","5$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 44","Cheese with 44 fromages","40$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 6","Cheese with 6 fromages","11$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 1","Cheese with 1 fromages","4$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 0","Cheese with 0 fromages","1.99$",R.drawable.hmbr))
        Foods.add(Food("Cheese Burger 21","Cheese with 21 fromages","3$",R.drawable.hmbr))

        val adapter = FoodAdapter(this, Foods)
        binding.foodsLists.adapter = adapter
        val manager = GridLayoutManager(this,2)
        binding.foodsLists.layoutManager = manager
        adapter.onItemClick = {
            val i = Intent(this@ThirdActivity, DetailsActivity::class.java)
            i.putExtra("foodname", it.foodname)
            i.putExtra("price", it.price)
            startActivity(i)
        }

        val burgerButton = binding.burger
        val pizzaButton = binding.pizza
        val soupsButton = binding.soups
        val saladesButton = binding.salades
        val drinksButton = binding.drinks
        var currentButton = burgerButton.id
        burgerButton.setOnClickListener {
            if(currentButton == burgerButton.id) return@setOnClickListener;

            val previousButton = findViewById<Button>(currentButton)
            previousButton.setTextColor(Color.BLACK)
            previousButton.setBackgroundResource(R.drawable.shape_choices_white)
            burgerButton.setTextColor(Color.WHITE)
            burgerButton.setBackgroundResource(R.drawable.shape_choices)
            currentButton = burgerButton.id;
        }
        pizzaButton.setOnClickListener {
            if(currentButton == pizzaButton.id) return@setOnClickListener;
            val previousButton = findViewById<Button>(currentButton)
            previousButton.setTextColor(Color.BLACK)
            previousButton.setBackgroundResource(R.drawable.shape_choices_white)
            pizzaButton.setTextColor(Color.WHITE)
            pizzaButton.setBackgroundResource(R.drawable.shape_choices)
            currentButton = pizzaButton.id;
        }
        soupsButton.setOnClickListener {
            if(currentButton == soupsButton.id) return@setOnClickListener;
            val previousButton = findViewById<Button>(currentButton)
            previousButton.setTextColor(Color.BLACK)
            previousButton.setBackgroundResource(R.drawable.shape_choices_white)
            soupsButton.setTextColor(Color.WHITE)
            soupsButton.setBackgroundResource(R.drawable.shape_choices)
            currentButton = soupsButton.id;
        }
        saladesButton.setOnClickListener {
            if(currentButton == saladesButton.id) return@setOnClickListener;
            val previousButton = findViewById<Button>(currentButton)
            previousButton.setTextColor(Color.BLACK)
            previousButton.setBackgroundResource(R.drawable.shape_choices_white)
            saladesButton.setTextColor(Color.WHITE)
            saladesButton.setBackgroundResource(R.drawable.shape_choices)
            currentButton = saladesButton.id;
        }
        drinksButton.setOnClickListener {
            if(currentButton == drinksButton.id) return@setOnClickListener;
            val previousButton = findViewById<Button>(currentButton)
            previousButton.setTextColor(Color.BLACK)
            previousButton.setBackgroundResource(R.drawable.shape_choices_white)
            drinksButton.setTextColor(Color.WHITE)
            drinksButton.setBackgroundResource(R.drawable.shape_choices)
            currentButton = drinksButton.id;
        }
        val homeButton = binding.home;
        homeButton.setOnClickListener{
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("HELLO Home")
            dialog.setMessage("Yes it's me i'm home")
            dialog.show()
        }
    }
}