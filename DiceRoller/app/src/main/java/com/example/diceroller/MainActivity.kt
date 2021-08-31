package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = dice.roll().toString()
        val diceImage: ImageView = findViewById(R.id.imageView)
        rollDice(diceImage)

        rollButton.setOnClickListener {
            rollDice(diceImage)
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            //toast.show()
            //val resultTextView: TextView = findViewById(R.id.textView)
            //resultTextView.text = "6"
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

private fun rollDice(diceImage: ImageView) {
    val dice = Dice(6)

    val drawableResource = when (dice.roll()) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    diceImage.setImageResource(drawableResource)
}
