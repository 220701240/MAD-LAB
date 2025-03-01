package com.example.validationapp

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        validateButton = findViewById(R.id.validateButton)

        validateButton.setOnClickListener {
            validateInputs()
        }
    }

    private fun validateInputs() {
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (email.isEmpty()) {
            emailEditText.error = "Email cannot be empty"
            return
        }

        if (!isValidCollegeEmail(email)) {
            emailEditText.error = "Enter a valid college email (e.g., example@college.edu)"
            return
        }

        if (password.isEmpty()) {
            passwordEditText.error = "Password cannot be empty"
            return
        }

        if (!isValidPassword(password)) {
            passwordEditText.error = "Password must be at least 8 characters, include a letter, a number, and a special character"
            return
        }

        Toast.makeText(this, "Validation Successful!", Toast.LENGTH_SHORT).show()
    }

    private fun isValidCollegeEmail(email: String): Boolean {
        val collegeEmailPattern = "^[a-zA-Z0-9._%+-]+@([a-zA-Z]+\\.)?(college\\.edu)$"
        return Pattern.compile(collegeEmailPattern).matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
        return Pattern.compile(passwordPattern).matcher(password).matches()
    }
}
