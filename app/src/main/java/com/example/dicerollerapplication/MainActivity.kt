package com.example.dicerollerapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()

            rollDice()
        }

        //rolls randomly when the app opens so users will know what to expect
        rollDice()
    }
    private fun rollDice() {
        // Create 2 new Dice object with 6 sides and roll them
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        val resultDiceImage: ImageView = findViewById(R.id.imageView)
        val resultDiceImage2: ImageView = findViewById(R.id.imageView2)

        //creates a value that stores the appropriate ID of the picture that should be displayed
        val diceImageResource1 = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        resultDiceImage.setImageResource(diceImageResource1)
        resultDiceImage.contentDescription = diceRoll.toString()

        //creates a value that stores the appropriate ID of the picture that should be displayed
        val diceImageResource2 = when (diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        resultDiceImage2.setImageResource(diceImageResource2)
        resultDiceImage.contentDescription = diceRoll.toString()
    }
}
/**
 * Class of dice with only one attribute: its num of sides.
 */
class Dice(private val numOfSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numOfSides).random()
    }
}