package com.example.food_full_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.food_full_app.databinding.ActivityMainBinding
import com.example.food_full_app.databinding.BottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val signup = binding.button


        signup.setOnClickListener {
            val bot = BottomSheetBinding.inflate(layoutInflater)
            val dialog = BottomSheetDialog(this)

            dialog.setContentView(bot.root)

            bot.sign.setOnClickListener {
                val email_input = bot.email.text.toString()
                val pass_input = bot.pass.text.toString()
                if(email_input!!.isEmpty()) {
                    bot.email.setError("please fill this field")
                } else if(pass_input!!.isEmpty()) {
                    bot.pass.setError("please fill this field")
                } else {
                    if(email_input == "test@gmail.com" && pass_input == "123456") {
                       val i = Intent(this@MainActivity,ThirdActivity::class.java)
                        startActivity(i)
                    } else {
                        val dial = AlertDialog.Builder(this)
                        dial.setTitle("SIGN UP")
                        dial.setMessage("incorrect information entered, please try again")
                        dial.setPositiveButton("Try Again") {aa, _ -> {
                            aa.dismiss()
                        }}
                        dialog.dismiss()
                        dial.show()
                    }

                }
            }

            dialog.show()
        }
    }
}