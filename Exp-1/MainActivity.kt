package com.example.employee

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etid :EditText=findViewById(R.id.etid)
        val etName : EditText =findViewById(R.id.etName)

        val etSalary :EditText=findViewById(R.id.etSalary)
        val btSave : Button =findViewById(R.id.btSave)
        val btLoad :Button=findViewById(R.id.btLoad)
        btSave.setOnClickListener {
            var  id=etid.text.toString()
            var  name=etName.text.toString()
            var  salary=etSalary.text.toString()
            val file= File(getExternalFilesDir(null),"student.txt")
            val writer= FileWriter(file)
            writer.write("$id\n$name\n$salary")
            writer.close()
            etid.text.clear()
            etName.text.clear()

            etSalary.text.clear()

            Toast.makeText(this,"Saved Successfully..!",Toast.LENGTH_LONG).show()
        }
        btLoad.setOnClickListener {
            val file= File(getExternalFilesDir(null),"student.txt")
            val reader=BufferedReader(FileReader(file))
            val id=reader.readLine()
            val name=reader.readLine()
            val salary=reader.readLine()
            etid.setText(id)
            etName.setText(name)
            etSalary.setText(salary)
            reader.close()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
