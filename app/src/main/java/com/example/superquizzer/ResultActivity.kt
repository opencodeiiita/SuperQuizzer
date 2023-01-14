package com.example.superquizzer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.firebase.auth.FirebaseAuth

class ResultActivity : AppCompatActivity() {
    companion object
    {
        lateinit var auth: FirebaseAuth

    }

    private lateinit var shareButton: ImageButton
    private lateinit var homeButton: ImageButton
    private var scoreTv: TextView? = null
    private var usernameTv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        auth =FirebaseAuth.getInstance()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        shareButton = findViewById(R.id.share_button)
        homeButton = findViewById(R.id.home_button)
        scoreTv = findViewById(R.id.score_tv)
        val usernameTv = findViewById<TextView>(R.id.username)

        val name= auth.currentUser?.displayName
        usernameTv.text = "$name"
        val intent = intent;
        val ss: String = intent.getStringExtra("score").toString()
        scoreTv!!.text = "You scored ${ss} points!"

        shareButton.setOnClickListener {
            val s =
                "Checkout this interesting quiz-taking application developed during OpenCode-22!!\n" +
                        "https://github.com/opencodeiiita/SuperQuizzer"
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, s)
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        homeButton.setOnClickListener {
            val home = Intent(this, MainActivity::class.java)
            startActivity(home)
            Animatoo.animateSpin(this)
            finish()
        }

    }
}