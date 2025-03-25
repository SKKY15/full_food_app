package com.example.food_full_app

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.food_full_app.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val foodname = intent.getStringExtra("foodname")
        val foodprice = intent.getStringExtra("price")
        binding.cheese.text = foodname
        binding.theprice.text = foodprice


        val textView: TextView = findViewById(R.id.toread)

        val fullContent =
            "This beef burger uses 100% quality beef with sliced tomatoes, cucumbers, vegetables, and onions, all served on a freshly toasted bun with a side of crispy fries."
        val collapsedContent =
            "This beef burger uses 100% quality beef with sliced tomatoes, cucumbers, vegetables and onions."

        var isCollapsed = true
        updateTextView(textView, collapsedContent, fullContent, isCollapsed)

        textView.setOnClickListener {
            isCollapsed = !isCollapsed
            updateTextView(textView, collapsedContent, fullContent, isCollapsed)
        }
        var text = binding.thetext.text.toString()
        val add = binding.addone
        val minus = binding.minusone
        add.setOnClickListener {
            val newtext = text.toInt() + 1
            binding.thetext.text = newtext.toString()
            text = newtext.toString()
        }
        minus.setOnClickListener {
            if(text.toInt() == 1) {
                return@setOnClickListener
            }
                val newtext = text.toInt() - 1
                binding.thetext.text = newtext.toString()
                text = newtext.toString()

        }
    }

    private fun updateTextView(
        textView: TextView,
        collapsedContent: String,
        fullContent: String,
        isCollapsed: Boolean
    ) {
        val displayText = if (isCollapsed) collapsedContent else fullContent
        val actionText = if (isCollapsed) " Show More" else " Show Less"

        // Combine the display text and action text
        val spannableContent = SpannableString("$displayText$actionText")

        // Apply the clickable span only to the actionText
        spannableContent.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Directly toggle the text and update
                val newCollapsedState = !isCollapsed
                updateTextView(textView, collapsedContent, fullContent, newCollapsedState)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false // Remove underline
                ds.color = textView.context.getColor(R.color.teal_700) // Set color
            }
        }, displayText.length, spannableContent.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableContent
        textView.highlightColor = Color.TRANSPARENT // Remove background highlight
        textView.movementMethod = android.text.method.LinkMovementMethod.getInstance()
    }




}