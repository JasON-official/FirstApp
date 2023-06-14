package com.example.firstapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.math.min

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences
    private val keyForNumber: String = "key_for_number"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getSharedPreferences("myFile", MODE_PRIVATE)

        Log.d("MyTagOn", "onCreate спрацював")

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)
        val myText = findViewById<TextView>(R.id.textView)

        var counter = getNumber()
        myText.text = counter.toString()

        //incrementButton.text = "Кніпочка збільшує на 1"
        incrementButton.setOnClickListener {
            Log.d("MyTag", "Click plus")

            counter += 1
            saveNumber(counter)

            val numberAsString = counter.toString()
            myText.text = numberAsString
        }

        //decrementButton.text = "Кніпочка зменшує на 1"
        decrementButton.setOnClickListener {
            Log.d("MyTag2", "Click minus")

            counter -= 1
            saveNumber(counter)

            val numberAsString = counter.toString()
            myText.text = numberAsString
        }
    }


    //SharedPreference - ключ значення.
    private fun saveNumber(number: Int) {
        val editor = sharedPref.edit()
        editor.putInt(keyForNumber, number)
        editor.commit()
    }

    private fun getNumber(): Int {
        val number = sharedPref.getInt(keyForNumber, 0)
        return number
    }
    //Database - база даних. Таблиця і залежності між ними.
    //File
}