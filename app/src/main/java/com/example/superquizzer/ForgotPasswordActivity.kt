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
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    companion object
    {
        lateinit var auth: FirebaseAuth

    }
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
        auth= FirebaseAuth.getInstance()
        bBack=binding.backBtn
        bSubmit=binding.loginButton
        edtEmail=binding.editTextTextEmailAddress4

        bBack!!.setOnClickListener {
            val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)
            startActivity(intent)
        }

            bSubmit!!.setOnClickListener {
                val email= edtEmail!!.text.toString().trim()
                if(CheckEmail())
                {
                    auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener{task->
                            if(task.isSuccessful)
                            {
                                Toast.makeText(this@ForgotPasswordActivity,"Email sent to reset your password",
                                Toast.LENGTH_LONG).show()
                                finish()
                            }
                            else{
                                Toast.makeText(this@ForgotPasswordActivity,task.exception!!.message.toString(),
                                Toast.LENGTH_LONG).show()
                            }
                        }
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