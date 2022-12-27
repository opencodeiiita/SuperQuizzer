package com.example.superquizzer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.superquizzer.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    var bBack:ImageView?=null
    var edtEmail:EditText?=null
    private var bSubmit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(view)

        bBack=binding.backBtn
        bSubmit=binding.loginButton
        edtEmail=binding.editTextTextEmailAddress4

        bBack!!.setOnClickListener {
            val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
            startActivity(intent)
        }

            bSubmit!!.setOnClickListener {
                if(CheckEmail())
                {
                    Toast.makeText(this@ForgotPasswordActivity,"Submitted Successfully",Toast.LENGTH_LONG).show()
                    val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
                    startActivity(intent)
                }

            }

    }

    private fun isEmail(text: Editable?): Boolean {
        val email: CharSequence = text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun CheckEmail():Boolean{
        if(edtEmail?.length()==0)
        {
            edtEmail?.error="E-mail cannot be blanked"
            return false
        }
        if(!isEmail(edtEmail?.editableText))
        {
            edtEmail?.error="email address is not valid"
            return false
        }
        return true
    }
}