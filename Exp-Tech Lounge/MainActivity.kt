package com.example.techlonge

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etCount:TextView=findViewById(R.id.etCount)
        val btIn:Button=findViewById(R.id.btIn)
        val btOut:Button=findViewById(R.id.btOut)
        var count=0;
        btIn.setOnClickListener {
                 count=count+1;
           etCount.text= count.toString();
        }
        btOut.setOnClickListener {
            count=count-1;
            etCount.text= count.toString();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
