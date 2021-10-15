package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //faz o layout começar com um dado e um botão
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource(R.drawable.dice_1)

        //seleciona e altera o dado correspondente a cada clique
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val dice = Dice(6)
            val diceRoll = dice.roll()
            dice.roll()
            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            //coloca a imagem do dado correspondente ao resultado do diceRoll
            diceImage.setImageResource(drawableResource)

            //atualização da descrição de conteúdo
            diceImage.contentDescription = diceRoll.toString()
        }
    }
}

//Instancia o dado, rola-o e retorna um número dele
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}