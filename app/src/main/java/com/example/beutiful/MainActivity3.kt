package com.example.beutiful

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.beutiful.databinding.ActivityMain3Binding

@Suppress("DEPRECATION")
class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    private lateinit var buttonCamera: Button
    private lateinit var imagePhoto: ImageView

    private val REQUEST_IMAGE_CAPTURE = 1
    
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        val button = findViewById<Button>(R.id.button4)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity3, MainActivity2::class.java)
            startActivity(intent)
        }
        val buttonUrl = findViewById<Button>(R.id.buttonLink)
        buttonUrl.setOnClickListener {
            val url = "https://www.roi.ru/117415/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        buttonCamera = findViewById(R.id.buttonPhoto)
        imagePhoto = findViewById(R.id.imagePhoto)
        buttonCamera.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imagePhoto.setImageBitmap(imageBitmap)
        }
    }
}

/*
class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private val REQUEST_IMAGE_CAPTURE = 1

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        binding.button4.setOnClickListener {
            val intent = Intent(this@MainActivity3, MainActivity2::class.java)
            startActivity(intent)
        }

        binding.buttonLink.setOnClickListener {
            val url = "https://www.roi.ru/117415/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        binding.buttonPhoto.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    @Deprecated("This method has been deprecated in favor of using the Activity Result API")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            binding.imagePhoto.setImageBitmap(imageBitmap)
        }
    }
}
*/
