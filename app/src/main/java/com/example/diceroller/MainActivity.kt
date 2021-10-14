package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            val resultTextView2: TextView = findViewById(R.id.textView2)
            resultTextView2.text = "Dado 1"

            val resultTextView3: TextView = findViewById(R.id.textView3)
            resultTextView3.text = "Dado 2"

            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = Dice(6).roll().toString()

            val resultTextView4: TextView = findViewById(R.id.textView4)
            resultTextView4.text = Dice(6).roll().toString()
        }
    }
}

//Instancia o dado, rola-o e retorna um número dele
class Dice(private val numSides: Int) {
    fun roll(): Int { return (1..numSides).random() }
}