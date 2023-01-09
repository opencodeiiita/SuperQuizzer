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

    var user = FirebaseAuth.getInstance().currentUser
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var actionBarDrawerToggle : ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    private lateinit var scienceButton : ImageButton
    private lateinit var sharebtn:ImageButton
    @SuppressLint("MissingInflatedId")
    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth=FirebaseAuth.getInstance()
        val name = user!!.displayName
        val full_name=findViewById<TextView>(R.id.full_name)
        full_name.setText("${name}")
        scienceButton = findViewById(R.id.ScienceButton)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView=findViewById(R.id.nav_view)
        sharebtn=findViewById(R.id.shareimgbtn)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        scienceButton.setOnClickListener {
            val science = Intent(this, ScienceActivity::class.java)
            startActivity(science)
        }        
        
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
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

