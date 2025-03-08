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
        val ettitle :EditText=findViewById(R.id.etTitle)
        val etauthor : EditText =findViewById(R.id.etAuthor)
        val etpublisher : EditText =findViewById(R.id.etPublisher)
        val etprice :EditText=findViewById(R.id.etPrice)
        val btSave : Button =findViewById(R.id.btSave)
        val btLoad :Button=findViewById(R.id.btLoad)
        btSave.setOnClickListener {
            var title=ettitle.text.toString()
            var author=etauthor.text.toString()
            var publisher=etpublisher.text.toString()
            var price=etprice.text.toString()

            val file= File(getExternalFilesDir(null),"book.txt")
            val writer= FileWriter(file)
            writer.write("$\titlen$author\n$publisher\n$price")
            writer.close()
            ettitle.text.clear()
            etauthor.text.clear()

            etpublisher.text.clear()
            etprice.text.clear()

            Toast.makeText(this,"Saved Successfully..!",Toast.LENGTH_LONG).show()
        }
        btLoad.setOnClickListener {
            val file= File(getExternalFilesDir(null),"student.txt")
            val reader=BufferedReader(FileReader(file))
            val title=reader.readLine()
            val author=reader.readLine()
            val publisher=reader.readLine()
             val price=reader.readLine()

            ettitle.setText(title)
            etauthor.setText(author)
            etpublisher.setText(publisher)
             etprice.setText(price)

            reader.close()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
