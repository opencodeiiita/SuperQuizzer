package com.example.superquizzer

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.google.firebase.auth.FirebaseAuth

class Settings : AppCompatActivity() {
    companion object
    {
        lateinit var auth: FirebaseAuth

    }
    private lateinit var mProgressDialog: Dialog
    var bBack: ImageView?=null
    var bDelete:Button?=null
    @SuppressLint("UseSwitchCompatOrMaterialCode", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
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
            Animatoo.animateSlideLeft(this)
        }
        bDelete!!.setOnClickListener{
            showDeleteDialog()
        }
    }
    private fun showDeleteDialog()
    {
        val dialogBuilder= AlertDialog.Builder(this,R.style.CustomAlertDialog)
        dialogBuilder .setTitle("Delete Account")
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
    {showProgressDialog(resources.getString(R.string.please_wait))
        val user=auth.currentUser!!
        user.delete()
            .addOnCompleteListener { task ->
                hideProgressDialog()
                if (task.isSuccessful) {
                    Log.d(TAG, "User account deleted.")
                    finishAffinity();
                    System.exit(0);
                }
            }
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