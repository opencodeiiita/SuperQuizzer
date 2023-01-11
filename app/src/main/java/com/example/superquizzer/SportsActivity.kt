package com.example.superquizzer

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SportsActivity : AppCompatActivity() {
    private lateinit var questionField : TextView
    private lateinit var progressBar : ProgressBar
    private lateinit var progressTv : TextView
    private lateinit var optionOne : TextView
    private lateinit var optionTwo : TextView
    private lateinit var optionThree : TextView
    private lateinit var optionFour : TextView
    private lateinit var submitButton : Button
    private lateinit var nextButton : Button
    private var score : Int = 0
    private lateinit var scoreTv : TextView
    private var optionSelected : Int = 0
    private var correctOption : Int? = 0
    private var currentPosition : Int = 1
    private var submitted : Boolean = false
    private var canSelect : Boolean = true
    private lateinit var backButton: ImageButton
    private lateinit var questionsArray : ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_science)

        questionField = findViewById(R.id.tv_question)
        progressBar = findViewById(R.id.progressBar)
        progressTv = findViewById(R.id.tv_progress)
        optionOne = findViewById(R.id.tv_option_one)
        optionTwo = findViewById(R.id.tv_option_two)
        optionThree = findViewById(R.id.tv_option_three)
        optionFour = findViewById(R.id.tv_option_four)
        submitButton = findViewById(R.id.button)
        nextButton = findViewById(R.id.button2)
        scoreTv = findViewById(R.id.score)
        backButton = findViewById(R.id.back_btn)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        questionsArray = SportsQuestion.getQuestions()
        setQuestions()

        optionOne.setOnClickListener {
            if (canSelect){
                playSelect()
                optionSelected = 1
//                optionOne.setTypeface(optionOne.typeface, Typeface.BOLD)
                optionOne.setBackgroundColor(Color.CYAN)
                optionTwo.setBackgroundColor(Color.WHITE)
                optionThree.setBackgroundColor(Color.WHITE)
                optionFour.setBackgroundColor(Color.WHITE)
//                optionTwo.setTypeface(optionTwo.typeface, Typeface.NORMAL)
//                optionThree.setTypeface(optionThree.typeface, Typeface.NORMAL)
//                optionFour.setTypeface(optionFour.typeface, Typeface.NORMAL)
            }
        }
        optionTwo.setOnClickListener {
            if (canSelect){
                playSelect()
                optionSelected = 2
//                optionTwo.setTypeface(optionTwo.typeface, Typeface.BOLD)
                optionTwo.setBackgroundColor(Color.CYAN)
                optionOne.setBackgroundColor(Color.WHITE)
                optionThree.setBackgroundColor(Color.WHITE)
                optionFour.setBackgroundColor(Color.WHITE)
//                optionOne.setTypeface(optionOne.typeface, Typeface.NORMAL)
//                optionThree.setTypeface(optionThree.typeface, Typeface.NORMAL)
//                optionFour.setTypeface(optionFour.typeface, Typeface.NORMAL)
            }
        }
        optionThree.setOnClickListener {
            if (canSelect){
                playSelect()
                optionSelected = 3
//                optionThree.setTypeface(optionThree.typeface, Typeface.BOLD)
                optionThree.setBackgroundColor(Color.CYAN)
                optionOne.setBackgroundColor(Color.WHITE)
                optionTwo.setBackgroundColor(Color.WHITE)
                optionFour.setBackgroundColor(Color.WHITE)
//                optionOne.setTypeface(optionOne.typeface, Typeface.NORMAL)
//                optionTwo.setTypeface(optionTwo.typeface, Typeface.NORMAL)
//                optionFour.setTypeface(optionFour.typeface, Typeface.NORMAL)
            }
        }
        optionFour.setOnClickListener {
            if (canSelect){
                playSelect()
                optionSelected = 4
//                optionFour.setTypeface(optionFour.typeface, Typeface.BOLD)
                optionFour.setBackgroundColor(Color.CYAN)
                optionOne.setBackgroundColor(Color.WHITE)
                optionThree.setBackgroundColor(Color.WHITE)
                optionTwo.setBackgroundColor(Color.WHITE)
//                optionOne.setTypeface(optionOne.typeface, Typeface.NORMAL)
//                optionThree.setTypeface(optionThree.typeface, Typeface.NORMAL)
//                optionTwo.setTypeface(optionTwo.typeface, Typeface.NORMAL)
            }
        }

        submitButton.setOnClickListener {
            submitQuestion()
        }

        nextButton.setOnClickListener {
            if (!submitted){
                Toast.makeText(this, "Submit your answer first", Toast.LENGTH_LONG).show()
            }
            else{
                if(currentPosition < questionsArray!!.size){
                    currentPosition++
                    setQuestions()
                    canSelect = true
                }
                else{
                    val result = Intent(this, ResultActivity::class.java)
                    result.putExtra("score", score.toString())
                    startActivity(result)
                    finish()
                }
            }
        }




    }

    private fun submitQuestion() {
        val question : Question = questionsArray[currentPosition - 1]
        correctOption = question.correctOption
        if (optionSelected == 0){
            submitted = false
            Toast.makeText(this, "Select an option first", Toast.LENGTH_LONG).show()
        }
        else{
            canSelect = false
            submitted = true
            if (correctOption == optionSelected){
                playCorrect()
                score++
                scoreTv?.text = "Score: $score/${progressBar?.max}"
                when (optionSelected) {
                    1 -> {

                        optionOne.setBackgroundColor(Color.GREEN)
                    }
                    2 -> {

                        optionTwo.setBackgroundColor(Color.GREEN)
                    }
                    3 -> {

                        optionThree.setBackgroundColor(Color.GREEN)
                    }
                    4 -> {

                        optionFour.setBackgroundColor(Color.GREEN)
                    }
                }
            }
            else{
                playIncorrect()
                when (correctOption) {
                    1 -> {

                        optionOne.setBackgroundColor(Color.GREEN)
                    }
                    2 -> {

                        optionTwo.setBackgroundColor(Color.GREEN)
                    }
                    3 -> {

                        optionThree.setBackgroundColor(Color.GREEN)
                    }
                    4 -> {

                        optionFour.setBackgroundColor(Color.GREEN)
                    }
                }
                when (optionSelected) {
                    1 -> {

                        optionOne.setBackgroundColor(Color.RED)
                    }
                    2 -> {

                        optionTwo.setBackgroundColor(Color.RED)
                    }
                    3 -> {

                        optionThree.setBackgroundColor(Color.RED)
                    }
                    4 -> {

                        optionFour.setBackgroundColor(Color.RED)
                    }
                }
            }
        }
    }

    private fun setQuestions() {
        val question : Question = questionsArray[currentPosition - 1]
        progressBar?.progress = currentPosition
        progressTv?.text = "$currentPosition/${progressBar?.max}"
        questionField?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour
        submitted = false
        correctOption = 0
        optionSelected = 0
        scoreTv?.text = "Score: $score/${progressBar?.max}"
        if (currentPosition == questionsArray!!.size){
            nextButton.text = "Finish!"
        }

        optionOne.setBackgroundColor(Color.WHITE)
        optionTwo.setBackgroundColor(Color.WHITE)
        optionThree.setBackgroundColor(Color.WHITE)
        optionFour.setBackgroundColor(Color.WHITE)
//        optionOne.setTypeface(optionOne.typeface, Typeface.NORMAL)
//        optionThree.setTypeface(optionThree.typeface, Typeface.NORMAL)
//        optionTwo.setTypeface(optionTwo.typeface, Typeface.NORMAL)
//        optionFour.setTypeface(optionFour.typeface, Typeface.NORMAL)
    }

    private fun playCorrect(){

        var resId = resources.getIdentifier(R.raw.correct_answer.toString(),
            "raw", packageName)

        val mediaPlayer = MediaPlayer.create(this, resId)
        mediaPlayer.start()
    }

    private fun playIncorrect(){

        var resId = resources.getIdentifier(R.raw.wrong_answer.toString(),
            "raw", packageName)

        val mediaPlayer = MediaPlayer.create(this, resId)
        mediaPlayer.start()
    }

    private fun playSelect(){

        var resId = resources.getIdentifier(R.raw.select_option.toString(),
            "raw", packageName)

        val mediaPlayer = MediaPlayer.create(this, resId)
        mediaPlayer.start()
    }
}