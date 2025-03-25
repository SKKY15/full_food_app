package com.example.food_full_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.food_full_app.databinding.ActivityLoadingBinding

class LoadingActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                } catch(e : Exception) {
                    e.printStackTrace()
                } finally {
                    val i = Intent(this@LoadingActivity, MainActivity::class.java)
                    startActivity(i)
                }
            }
        }
        thread.start()
    }
}