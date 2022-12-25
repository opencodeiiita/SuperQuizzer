package com.example.superquizzer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Patterns
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.superquizzer.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var etEmail:EditText?=null
    private var etPassword:EditText?=null
    private var bLogin:Button?=null
    private var isAllDetailsChecked=false

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        etEmail=binding.editTextTextEmailAddress4
        etPassword=binding.editTextTextPassword2
        bLogin=binding.loginButton

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(view)

        binding.signUpLink.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.forgotPassword.setOnClickListener{
            val intent=Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        bLogin?.setOnClickListener {
            if(validateLoginDetails())
            {
                Toast.makeText(this@LoginActivity,"Login Succeeded",Toast.LENGTH_LONG).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }

        }

    }
    private fun validateLoginDetails(): Boolean {
        isAllDetailsChecked=checkAllDetails()

        return if(isAllDetailsChecked) {
            true
        } else {
            Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show()
            false
        }
    }
    private fun isEmail(text: Editable?): Boolean {
        val email: CharSequence = text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun checkAllDetails(): Boolean {
        if(etEmail?.length()==0)
        {
            etEmail?.error="Email cannot be blank"
            return false
        }
        if(!isEmail(etEmail?.editableText))
        {
            etEmail?.error="Email address is not valid"
            return false
        }
        if (etPassword!!.length() == 0) {
            etPassword!!.error = "Password cannot be blank"
            return false
        } else if (etPassword!!.length() < 8) {
            etPassword!!.error = "Password must be minimum 8 characters"
            return false
        }
        return true
    }

}