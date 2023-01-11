package com.example.superquizzer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val questionlist = ScienceQuestions
    }
}