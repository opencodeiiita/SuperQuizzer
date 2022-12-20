package com.example.superquizzer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import android.widget.Button

class RegisterActivity : AppCompatActivity() {

    private var firstName : EditText? = null
    private var lastName : EditText? = null
    private var emailID : EditText? = null
    private var passwordOne : EditText? = null
    private var passwordTwo : EditText? = null
    private var checkBox : CheckBox? = null

    private lateinit var textlogin : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerBtn = findViewById<Button>(R.id.button6)
        firstName = findViewById(R.id.button)
        lastName = findViewById(R.id.button2)
        emailID = findViewById(R.id.button3)
        passwordOne = findViewById(R.id.button4)
        passwordTwo = findViewById(R.id.button5)
        checkBox = findViewById(R.id.checkBox)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_register)

        textlogin = findViewById(R.id.login)

        textlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        registerBtn.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser(){
        if (firstName!!.text.toString().isEmpty()){
            Toast.makeText(this, "First name cannot be blank", Toast.LENGTH_LONG).show()
        }
        if (lastName!!.text.toString().isEmpty()){
            Toast.makeText(this, "Last name cannot be blank", Toast.LENGTH_LONG).show()
        }
        if (emailID!!.text.toString().isEmpty()){
            Toast.makeText(this, "Email ID cannot be blank", Toast.LENGTH_LONG).show()
        }
        if (passwordOne!!.text.toString().isEmpty()){
            Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_LONG).show()
        }
        if (passwordTwo!!.text.toString().isEmpty()){
            Toast.makeText(this, "Password cannot be blank", Toast.LENGTH_LONG).show()
        }
        if (!checkBox!!.isChecked()){
            Toast.makeText(this,"Terms and conditions need to be accepted", Toast.LENGTH_LONG).show()
        }
        if (passwordOne!!.text.toString() != passwordTwo!!.text.toString()){
            Toast.makeText(this, "The passwords do not match", Toast.LENGTH_LONG).show()
        }
        if (firstName!!.text.toString().isNotEmpty() && lastName!!.text.toString().isNotEmpty() && emailID!!.text.toString().isNotEmpty()
            && passwordOne!!.text.toString().isNotEmpty() && passwordTwo!!.text.toString().isNotEmpty() && checkBox!!.isChecked &&
            passwordOne!!.text.toString() == passwordTwo!!.text.toString()){
            Toast.makeText(this, "Registration Complete", Toast.LENGTH_LONG).show()
        }
    }
}