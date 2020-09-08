package com.example.diceroller

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button = binding.rollButton
        button.setOnClickListener {
            Toast.makeText(this, "\uD83D\uDD2E \uD83D\uDD2E ",
                Toast.LENGTH_SHORT).show()
            rollDice()
        }

    }

    private fun rollDice() {
//        var s = DatagramSocket()
//        s.broadcast = true
//        var message = "2323".toByteArray()
//        val dpSend = DatagramPacket(message, message.size, InetAddress.getByName("localhost"), 8888)
//        s.send(dpSend);
        val randomInt6 = Random.nextInt(6)+1
        binding.textview.text = "\uD83D\uDE90".repeat(randomInt6)

        val drawableResource = when (randomInt6) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.diceImage.setImageResource(drawableResource)

    }


}
