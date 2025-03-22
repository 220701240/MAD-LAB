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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val temperatureInput: EditText = findViewById(R.id.etText)
        val convertButton: Button = findViewById(R.id.btConvert)
        val resultText: TextView = findViewById(R.id.Result)
        convertButton.setOnClickListener {
            val inputText = temperatureInput.text.toString()

            if (inputText.isNotEmpty()) {
                try {
                    val number = inputText.takeWhile { it.isDigit() || it == '.' }  
                    val unit = inputText.takeLastWhile { it.isLetter() } 

                    if (number.isNotEmpty() && unit.isNotEmpty()) {
                        val temperature = number.toDouble()

                        val result = when (unit.uppercase()) {
                            "C" -> celsiusToFahrenheit(temperature)
                            "F" -> fahrenheitToCelsius(temperature)
                            else -> {
                                Toast.makeText(this, "Please enter a valid temperature with unit (C or F)", Toast.LENGTH_SHORT).show()
                                return@setOnClickListener
                            }
                        }

                        resultText.text = result
                    } else {
                        Toast.makeText(this, "Invalid input. Make sure to include both number and unit (C or F).", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "Invalid input. Please enter a valid number.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a temperature value", Toast.LENGTH_SHORT).show()
            }
        }
    }

      private fun celsiusToFahrenheit(celsius: Double): String {
        return String.format("%.2f °C = %.2f °F", celsius, (celsius * 9/5) + 32)
    }

    private fun fahrenheitToCelsius(fahrenheit: Double): String {
        return String.format("%.2f °F = %.2f °C", fahrenheit, (fahrenheit - 32) * 5/9)
    }


    }
