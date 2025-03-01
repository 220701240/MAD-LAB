package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etusername : EditText = findViewById(R.id.etusername)
        val etpinnmber :EditText=findViewById(R.id.etpinnumber)
        val btlogin : Button= findViewById(R.id.btlogin)
        val btclear : Button= findViewById(R.id.btclear)
        btlogin.setOnClickListener {
            val username = etusername.text.toString().trim()
            val pinnumber = etpinnmber.text.toString().trim()
            if (username.isEmpty() || pinnumber.isEmpty()) {
                Toast.makeText(this, "All fields are mandatory", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (!username.matches(Regex("^[a-zA-Z]+$"))) {
                Toast.makeText(this, "Invalid Useranme", Toast.LENGTH_LONG).show()
                 return@setOnClickListener

            }
            if (!pinnumber.matches(Regex("^[0-9]{4}$"))) {
                Toast.makeText(this,"Invalid Pin Number", Toast.LENGTH_LONG).show()
                 return@setOnClickListener
            }
            val intent:Intent =Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
