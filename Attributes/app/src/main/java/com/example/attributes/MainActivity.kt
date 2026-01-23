package com.example.attributes

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_text)

        findViewById<Button>(R.id.button_bg_red).setOnClickListener {
            editText.setBackgroundColor(Color.RED)
        }

        findViewById<Button>(R.id.button_bg_green).setOnClickListener {
            editText.setBackgroundColor(Color.GREEN)
        }

        findViewById<Button>(R.id.button_text_blue).setOnClickListener {
            editText.setTextColor(Color.BLUE)
        }

        findViewById<Button>(R.id.button_text_red).setOnClickListener {
            editText.setTextColor(Color.RED)
        }

        findViewById<Button>(R.id.button_size_large).setOnClickListener {
            editText.textSize = 24f
        }

        findViewById<Button>(R.id.button_size_small).setOnClickListener {
            editText.textSize = 12f
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}