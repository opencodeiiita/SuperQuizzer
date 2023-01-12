package com.example.superquizzer

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth

class Settings : AppCompatActivity() {
    companion object
    {
        lateinit var auth: FirebaseAuth

    }
    var bBack: ImageView?=null
    var bDelete:Button?=null
    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darkTheme)
        } else {
            setTheme(R.style.Theme_SuperQuizzer)
        }
        setContentView(R.layout.activity_settings)
        val bMode=findViewById<Switch>(R.id.switchbtn)
        bMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Toast.makeText(this,"Enable Light Mode",Toast.LENGTH_SHORT).show()
            }
        }

        auth = FirebaseAuth.getInstance()
        bBack=findViewById(R.id.back_btn)
        bDelete=findViewById(R.id.loginButton)
        bBack!!.setOnClickListener {
            val intent = Intent(this@Settings, MainActivity::class.java)
            startActivity(intent)
        }
        bDelete!!.setOnClickListener{
            showDeleteDialog()
        }
    }
    private fun showDeleteDialog()
    {
        val dialogBuilder= AlertDialog.Builder(this,R.style.CustomAlertDialog)
        dialogBuilder .setTitle("Log Out")
            .setMessage("Are you sure you want to Delete this account ?")
            .setPositiveButton("Yes"){ _, _ ->  //dialog,which
                deleteFromApp()
                finish()
            }
            .setNegativeButton("No"){ dialog, _ ->
                dialog.cancel()
            }.show()
    }
    private fun deleteFromApp()
    {
        val user=auth.currentUser!!
        user.delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "User account deleted.")
                }
            }
    }
}