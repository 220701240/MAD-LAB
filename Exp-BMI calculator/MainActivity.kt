package com.example.temperature

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val height: EditText = findViewById(R.id.etHeight)
        val weight: EditText = findViewById(R.id.etWeight)

        val convertButton: Button = findViewById(R.id.btConvert)
        val resultText: TextView = findViewById(R.id.Result)
        convertButton.setOnClickListener {
          val  height=height.text.toString();
            val weight=weight.text.toString();

            if (height.isNotEmpty() && weight.isNotEmpty()) {
                try {


                    val height = height.toInt()
                    val weight = weight.toInt()
                      val  result=weight/height;
                        resultText.text = result.toString();

                } catch (e: Exception) {
                    Toast.makeText(this, "Invalid input. Please enter a valid number.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a both height and weight value", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
