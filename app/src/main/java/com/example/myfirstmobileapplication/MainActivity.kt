package com.example.myfirstmobileapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstmobileapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val words = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // https://developer.android.com/topic/libraries/view-binding#kotlin
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.buttonSave.setOnClickListener {
            val inputField = binding.editTextWord
            val word = inputField.text.toString().trim()
            if (word.isEmpty()) {
                inputField.error = "No word"
                return@setOnClickListener
            }
            words.add(word)
        }
        binding.buttonClear.setOnClickListener { words.clear() }

        binding.buttonShow.setOnClickListener {
            binding.textView.text=words.toString()
        }



    }
}
