package com.example.beutiful

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.beutiful.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val answer = intent.getStringExtra("answer") ?: ""
        val orientation = resources.configuration.orientation
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.layout_and)
        }
        else {
            setContentView(R.layout.activity_main)
        }
        //Без биндинга
        val answerText = findViewById<TextView>(R.id.textAnswer)
        answerText.text = answer
        val edit = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val message = edit.getText().toString()
            intent.putExtra("myTextOne", message)
            startActivity(intent)
        }
        //С биндингом
        /*binding.textAnswer.text = answer
        binding.button1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            val message = binding.editText.text.toString()
            intent.putExtra("myTextOne", message)
            startActivity(intent)
        }*/
    }
}