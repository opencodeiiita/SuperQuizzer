package com.example.superquizzer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    companion object
    {
        lateinit var auth: FirebaseAuth

    }
     private var actionBarDrawerToggle : ActionBarDrawerToggle?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth=FirebaseAuth.getInstance()

        val full_name=findViewById<TextView>(R.id.full_name)
        val name= auth.currentUser?.displayName
        full_name.text = "$name"
        val scienceButton = findViewById<ImageButton>(R.id.ScienceButton)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView=findViewById<NavigationView>(R.id.nav_view)
        val sharebtn=findViewById<ImageButton>(R.id.shareimgbtn)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.nav_logout->{
                    showLogoutDialog()
                    return@setNavigationItemSelectedListener true
                }
                else->return@setNavigationItemSelectedListener true
            }
        }
        sharebtn.setOnClickListener {
            val s="Checkout this interesting and brain-puzzled application develop during OpenCode-22\n" +
                    "Here its github repo link:https://github.com/opencodeiiita/SuperQuizzer"
            val shareIntent= Intent()
            shareIntent.action=Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,s)
            startActivity(Intent.createChooser(shareIntent,"Share via"))

        }
        scienceButton.setOnClickListener {
            val science = Intent(this, ScienceActivity::class.java)
            startActivity(science)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return if (actionBarDrawerToggle?.onOptionsItemSelected(item) == true) {
            true
        } else super.onOptionsItemSelected(item)
    }
    @SuppressLint("SuspiciousIndentation")
    private fun showLogoutDialog()
    {
        val dialogBuilder=AlertDialog.Builder(this,R.style.CustomAlertDialog)
        dialogBuilder .setTitle("Log Out")
            .setMessage("Are you sure you want to logout ?")
            .setPositiveButton("Yes"){ _, _ ->  //dialog,which
                signOutFromApp()
            }
            .setNegativeButton("No"){ dialog, _ ->
                dialog.cancel()
            }.show()
    }
    private fun signOutFromApp()
    {
        auth.signOut()
        Toast.makeText(this,"Logout Successfully",Toast.LENGTH_LONG).show()
    }

}

