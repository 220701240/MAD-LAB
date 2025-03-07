package com.example.sdcard

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etRollno :EditText=findViewById(R.id.etRollno)
        val etName :EditText=findViewById(R.id.etName)

        val etCgpa :EditText=findViewById(R.id.etCgpa)
        val btSave : Button =findViewById(R.id.btSave)
        val btLoad :Button=findViewById(R.id.btLoad)
        btSave.setOnClickListener {
            var  rollno=etRollno.text.toString()
            var  name=etName.text.toString()
            var  cgpa=etCgpa.text.toString()
            val file= File(getExternalFilesDir(null),"student.txt")
            val writer=FileWriter(file)
            writer.write("$rollno\n$name\n$cgpa")
            writer.close()
            etRollno.text.clear()
            etName.text.clear()

            etCgpa.text.clear()

            Toast.makeText(this,"Saved Successfully..!",Toast.LENGTH_LONG).show()
        }
        btLoad.setOnClickListener {
            val file= File(getExternalFilesDir(null),"student.txt")
             val reader=BufferedReader(FileReader(file))
            val rollno=reader.readLine()
            val name=reader.readLine()
            val cgpa=reader.readLine()
            etRollno.setText(rollno)
            etName.setText(name)
            etCgpa.setText(cgpa)
            reader.close()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
