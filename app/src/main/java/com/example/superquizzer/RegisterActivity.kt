package com.example.superquizzer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private var firstName : EditText? = null
    private var lastName : EditText? = null
    private var emailID : EditText? = null
    private var passwordOne : EditText? = null
    private var passwordTwo : EditText? = null
    private var checkBox : CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerBtn : Button = findViewById(R.id.registerButton)
        firstName = findViewById(R.id.firstName)
        emailID = findViewById(R.id.emailId)
        lastName = findViewById(R.id.lastName)
        passwordOne = findViewById(R.id.pass1)
        passwordTwo = findViewById(R.id.pass2)
        checkBox = findViewById(R.id.checkBox)

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
        if (checkBox!!.isChecked()){
            Toast.makeText(this,"Terms and conditions need to be accepted", Toast.LENGTH_LONG).show()
        }
        if (firstName!!.text.toString().isNotEmpty() && lastName!!.text.toString().isNotEmpty() && emailID!!.text.toString().isNotEmpty()
            && passwordOne!!.text.toString().isNotEmpty() && passwordTwo!!.text.toString().isNotEmpty() && checkBox!!.isChecked){
            Toast.makeText(this, "Registration Complete", Toast.LENGTH_LONG).show()
        }
    }
}