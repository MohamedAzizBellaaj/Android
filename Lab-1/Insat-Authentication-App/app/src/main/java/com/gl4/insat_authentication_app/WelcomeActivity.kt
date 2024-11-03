package com.gl4.insat_authentication_app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    private lateinit var welcomeTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        welcomeTextView = findViewById(R.id.welcomeTextView)
        val email = intent.getStringExtra("email")
        welcomeTextView.setText("Bienvenue $email")
    }
}
