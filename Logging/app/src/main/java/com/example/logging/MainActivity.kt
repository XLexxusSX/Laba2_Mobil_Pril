package com.example.logging

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import timber.log.Timber
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonLog = findViewById<Button>(R.id.button_log)
        val editTextLog = findViewById<EditText>(R.id.edit_text_log)
        buttonLog.setOnClickListener {
            val text = editTextLog.text.toString()
            Log.v("From EditText", text)
        }

        val buttonTimber = findViewById<Button>(R.id.button_timber)
        buttonTimber.setOnClickListener {
            val text = editTextLog.text.toString()
            Timber.v(text)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}