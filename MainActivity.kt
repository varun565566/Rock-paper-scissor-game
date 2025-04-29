package eu.tutorials.game1


import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eu.tutorials.game1.ui.theme.Game1Theme



import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val choices = arrayOf("Rock", "Paper", "Scissors")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultText = findViewById<TextView>(R.id.resultText)
        val rockButton = findViewById<Button>(R.id.rockButton)
        val paperButton = findViewById<Button>(R.id.paperButton)
        val scissorsButton = findViewById<Button>(R.id.scissorsButton)

        rockButton.setOnClickListener { playGame("Rock", resultText) }
        paperButton.setOnClickListener { playGame("Paper", resultText) }
        scissorsButton.setOnClickListener { playGame("Scissors", resultText) }
    }

    private fun playGame(userChoice: String, resultText: TextView) {
        val computerChoice = choices[Random.nextInt(choices.size)]
        val result = when {
            userChoice == computerChoice -> "Draw! You both chose $userChoice."
            userChoice == "Rock" && computerChoice == "Scissors" -> "You Win! Rock beats Scissors."
            userChoice == "Paper" && computerChoice == "Rock" -> "You Win! Paper beats Rock."
            userChoice == "Scissors" && computerChoice == "Paper" -> "You Win! Scissors beats Paper."
            else -> "You Lose! $computerChoice beats $userChoice."
        }

        resultText.text = result
    }
}

open class AppCompatActivity {

}
