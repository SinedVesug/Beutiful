package com.example.beutiful

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.beutiful.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val myText = intent.getStringExtra("myTextOne") ?: ""
        binding.textExample.text = myText
        //Без биндинга
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            val answer = "$myText it 2"
            intent.putExtra("answer", answer)
            startActivity(intent)
        }
        //С биндингом
        /*binding.button2.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            val answer = "$myText it 2"
            intent.putExtra("answer", answer)
            startActivity(intent)
        }*/
        binding.button3.setOnClickListener {
            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}