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
            // Get the input from EditText
            val inputText = temperatureInput.text.toString()

            // Validate if the input is not empty
            if (inputText.isNotEmpty()) {
                try {
                    // Extract the number and unit from the input string
                    val number = inputText.takeWhile { it.isDigit() || it == '.' }  // Get the numeric part
                    val unit = inputText.takeLastWhile { it.isLetter() }  // Get the unit part (C or F)

                    // Check if the input is valid (contains number and unit)
                    if (number.isNotEmpty() && unit.isNotEmpty()) {
                        val temperature = number.toDouble()

                        // Perform the conversion based on the unit
                        val result = when (unit.uppercase()) {
                            "C" -> celsiusToFahrenheit(temperature)
                            "F" -> fahrenheitToCelsius(temperature)
                            else -> {
                                Toast.makeText(this, "Please enter a valid temperature with unit (C or F)", Toast.LENGTH_SHORT).show()
                                return@setOnClickListener
                            }
                        }

                        // Display the result
                        resultText.text = result
                    } else {
                        Toast.makeText(this, "Invalid input. Make sure to include both number and unit (C or F).", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    // Handle any exceptions (like invalid number)
                    Toast.makeText(this, "Invalid input. Please enter a valid number.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Handle empty input
                Toast.makeText(this, "Please enter a temperature value", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to convert Celsius to Fahrenheit
      private fun celsiusToFahrenheit(celsius: Double): String {
        return String.format("%.2f °C = %.2f °F", celsius, (celsius * 9/5) + 32)
    }

    // Function to convert Fahrenheit to Celsius
    private fun fahrenheitToCelsius(fahrenheit: Double): String {
        return String.format("%.2f °F = %.2f °C", fahrenheit, (fahrenheit - 32) * 5/9)
    }


    }
