package com.gl4.insat_authentication_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val correctEmail: String = "gl4@insat.tn"
    private val correctPassword: String = "insat2022"
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener { view ->
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            if (email == correctEmail && password == correctPassword) {
                val intent = Intent(view.context, WelcomeActivity::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Email: $email ou mot de passe: $password sont incorrectes",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
