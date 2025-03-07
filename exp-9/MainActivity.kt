package com.example.alertdialogbox

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        var etText: EditText = findViewById(R.id.etText)
        var btDisplay: Button = findViewById(R.id.btDisplay)
         btDisplay.setOnClickListener{
             val alertdialog= AlertDialog.Builder(this)
                 .setTitle("mad Lab")
                 .setMessage(etText.text.toString())
                 .setPositiveButton("Ok"){ dialog,which->
                     Toast.makeText(this,"you clicked ok",Toast.LENGTH_LONG).show()
                 }
                 .setNegativeButton("cancel"){
                         dialog,which->
                     Toast.makeText(this,"you clicked cancel",Toast.LENGTH_LONG).show()
                 }
                 .create()
                  alertdialog.show()
         }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

