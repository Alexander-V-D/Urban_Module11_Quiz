package com.example.urban_module11_quiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class ResultActivity : AppCompatActivity() {

    private lateinit var scoreTV: TextView
    private lateinit var markTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        scoreTV = findViewById(R.id.scoreTV)
        markTV = findViewById(R.id.markTV)

        val score = intent.getIntExtra("score", 0)
        scoreTV.text = String.format(Locale.US, "Результат: $score")
        markTV.text = when(score) {
            0 -> getString(R.string.mark_0)
            100 -> getString(R.string.mark_100)
            200 -> getString(R.string.mark_200)
            300 -> getString(R.string.mark_300)
            400 -> getString(R.string.mark_400)
            else -> getString(R.string.mark_500)
        }
    }
}