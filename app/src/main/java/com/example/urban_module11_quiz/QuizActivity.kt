package com.example.urban_module11_quiz

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var questionTV: TextView
    private lateinit var answersRG: RadioGroup
    private lateinit var answer1RB: RadioButton
    private lateinit var answer2RB: RadioButton
    private lateinit var answer3RB: RadioButton

    private val correctAnswersList = listOf(2, 1, 3, 2, 3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val score = intent.getIntExtra("score", 0)
        val questionNumber = intent.getIntExtra("number", 1)

        questionTV = findViewById(R.id.questionTV)

        answersRG = findViewById(R.id.answersRG)

        answer1RB = findViewById(R.id.answer1RB)
        answer2RB = findViewById(R.id.answer2RB)
        answer3RB = findViewById(R.id.answer3RB)

        when (questionNumber) {
            1 -> {
                questionTV.text = getString(R.string.question_1)
                answer1RB.text = getString(R.string.q1_answer_1)
                answer2RB.text = getString(R.string.q1_answer_2)
                answer3RB.text = getString(R.string.q1_answer_3)
            }

            2 -> {
                questionTV.text = getString(R.string.question_2)
                answer1RB.text = getString(R.string.q2_answer_1)
                answer2RB.text = getString(R.string.q2_answer_2)
                answer3RB.text = getString(R.string.q2_answer_3)
            }

            3 -> {
                questionTV.text = getString(R.string.question_3)
                answer1RB.text = getString(R.string.q3_answer_1)
                answer2RB.text = getString(R.string.q3_answer_2)
                answer3RB.text = getString(R.string.q3_answer_3)
            }

            4 -> {
                questionTV.text = getString(R.string.question_4)
                answer1RB.text = getString(R.string.q4_answer_1)
                answer2RB.text = getString(R.string.q4_answer_2)
                answer3RB.text = getString(R.string.q4_answer_3)
            }

            5 -> {
                questionTV.text = getString(R.string.question_5)
                answer1RB.text = getString(R.string.q5_answer_1)
                answer2RB.text = getString(R.string.q5_answer_2)
                answer3RB.text = getString(R.string.q5_answer_3)
            }
        }
        val intent = if (questionNumber == 5) {
            Intent(this, ResultActivity::class.java)
        } else {
            Intent(this, QuizActivity::class.java)
        }

        answersRG.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.answer1RB -> {
                    intent.putExtra(
                        "score", if (correctAnswersList[questionNumber - 1] == 1) {
                            score + 100
                        } else {
                            score
                        }
                    )
                    if (questionNumber < 5) intent.putExtra("number", questionNumber + 1)
                    startActivity(intent)
                }

                R.id.answer2RB -> {
                    intent.putExtra(
                        "score", if (correctAnswersList[questionNumber - 1] == 2) {
                            score + 100
                        } else {
                            score
                        }
                    )
                    if (questionNumber < 5) intent.putExtra("number", questionNumber + 1)
                    startActivity(intent)
                }

                R.id.answer3RB -> {
                    intent.putExtra(
                        "score", if (correctAnswersList[questionNumber - 1] == 3) {
                            score + 100
                        } else {
                            score
                        }
                    )
                    if (questionNumber < 5) intent.putExtra("number", questionNumber + 1)
                    startActivity(intent)
                }
            }
        }
    }
}