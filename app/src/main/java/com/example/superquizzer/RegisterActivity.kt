package com.example.superquizzer

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest


class RegisterActivity : AppCompatActivity() {
    companion object
    {
        lateinit var auth: FirebaseAuth

    }
    //buttons
    var bRegister:Button?=null
    //edit text
    var etFirstName:EditText?=null
    var etLastName:EditText?=null
    var etEmail:EditText?=null
    var etPassword:EditText?=null
    var etConfPassword:EditText?=null
    var cbTermConditions:CheckBox?=null
    var isAllEditTextCheck=false

    private lateinit var textlogin : TextView
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth= FirebaseAuth.getInstance()
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
        etEmail=findViewById<EditText>(R.id.email_et)
        etFirstName=findViewById<EditText>(R.id.first_name)
        etLastName=findViewById<EditText>(R.id.last_name)
        etPassword=findViewById<EditText>(R.id.password_et)
        etConfPassword=findViewById<EditText>(R.id.conf_password_et)
        cbTermConditions=findViewById<CheckBox>(R.id.terms_cond_cbox)
        bRegister=findViewById<Button>(R.id.register_btn)

        bRegister?.setOnClickListener { registerUser() }

        textlogin = findViewById(R.id.login)
        textlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
    private fun registerUser()
    {
        val email= etEmail?.text.toString()
        val password=etPassword?.text.toString()
        val name=etFirstName?.text.toString()+etLastName?.text.toString()
        isAllEditTextCheck=CheckAllEditText()
        if(isAllEditTextCheck){
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful)
                    {
                        val user=auth.currentUser
                        val updates=UserProfileChangeRequest.Builder()
                            .setDisplayName(name).build()
                        user!!.updateProfile(updates)
                        updateUI(user)
                        Toast.makeText(this,"Registration Succeeded",Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        Log.i("TAG",task.exception.toString())
                        Toast.makeText(this,"Registration Failed",Toast.LENGTH_LONG).show()
                        updateUI(null)
                    }
                }

        }
        else
        {
            Toast.makeText(this,"Registration is not successful",Toast.LENGTH_SHORT).show()
        }
    }

    private fun isEmail(text: Editable?): Boolean {
        val email: CharSequence = text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun CheckAllEditText(): Boolean {
        if(etFirstName?.length()  ==0)
        {
            etFirstName?.error = "First Name cannot be blank"
            return false;
        }
        if(etLastName?.length()==0)
        {
            etLastName?.error="Last Name cannot be blank"
            return false;
        }
        if(etEmail?.length()==0)
        {
            etEmail?.error="Email ID cannot be blank"
            return false;
        }
        if(!isEmail(etEmail?.editableText))
        {
            etEmail?.error="Email Address is not valid."
            return false
        }
        if (etPassword!!.length() == 0) {
            etPassword!!.error = "Password cannot be blank"
            return false
        } else if (etPassword!!.length() < 8) {
            etPassword!!.error = "Password must be of minimum 8 characters."
            return false
        }
        if(etConfPassword!!.length()==0)
        {
            etConfPassword!!.error="Password and Confirm Password do not match."
            return false
        }
        if(!etConfPassword?.equals(etConfPassword)!!)
        {
            etConfPassword!!.error="Password and Confirm Password do not match."
            return false
        }
        if (cbTermConditions?.isChecked == true) {
            (cbTermConditions!!.text.toString() + " ")
        } else {
            (cbTermConditions!!.text.toString() + "UnChecked")
            Toast.makeText(this@RegisterActivity,"Terms and Conditions must be checked.",Toast.LENGTH_SHORT).show()
            return false
        }
        return true

    }
    private fun updateUI(user: FirebaseUser?){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}