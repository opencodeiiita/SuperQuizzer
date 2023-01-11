package com.example.superquizzer

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.superquizzer.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class LoginActivity : AppCompatActivity() {
    private var etEmail:EditText?=null
    private var etPassword:EditText?=null
    private var bLogin:Button?=null
    private var isAllDetailsChecked=false
    lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    private lateinit var mProgressDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        bLogin = findViewById(R.id.loginButton)
//        bLogin!!.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
        auth = FirebaseAuth.getInstance()
        etEmail=binding.editTextTextEmailAddress4
        etPassword=binding.editTextTextPassword2
        bLogin=binding.loginButton
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
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
                showProgressDialog(resources.getString(R.string.please_wait))
                val email = etEmail!!.text.toString()
                val password = etPassword!!.text.toString()
                auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){ task->
                    hideProgressDialog()
                    if(task.isSuccessful) {
                        Toast.makeText(this@LoginActivity, "Login Succeeded", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        try{
                            throw task.exception!!
                        }
                        catch(e: FirebaseAuthInvalidUserException){
                            etEmail!!.error = "User does not exist. Please register again."
                        }
                        catch (e: FirebaseAuthInvalidCredentialsException){
                            etEmail!!.error = "Invalid credentials. Kindly check and re-enter."
                        }
                        Toast.makeText(this,"Login Failed",Toast.LENGTH_LONG).show()
                    }
                }
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

    fun showProgressDialog(text: String) {
        mProgressDialog = Dialog(this)

        /*Set the screen content from a layout resource.
        The resource will be inflated, adding all top-level views to the screen.*/
        mProgressDialog.setContentView(R.layout.dialog_progress)

        mProgressDialog.findViewById<TextView>(R.id.tv_progress_text).text = text

        mProgressDialog.setCancelable(false)
        mProgressDialog.setCanceledOnTouchOutside(false)

        //Start the dialog and display it on screen.
        mProgressDialog.show()
    }

    fun hideProgressDialog() {
        mProgressDialog.dismiss()

    }

}