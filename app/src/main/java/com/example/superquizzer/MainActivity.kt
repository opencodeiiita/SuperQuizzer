package com.example.superquizzer


import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
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

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        auth=FirebaseAuth.getInstance()

        val full_name=findViewById<TextView>(R.id.full_name)
        val name= auth.currentUser?.displayName

        full_name.text = "$name"
        val scienceButton = findViewById<ImageButton>(R.id.ScienceButton)
        val animeButton = findViewById<ImageButton>(R.id.AnimeButton)
        val gkButton = findViewById<ImageButton>(R.id.GKButton)
        val sportsButton = findViewById<ImageButton>(R.id.SportsButton)
        val musicButton = findViewById<ImageButton>(R.id.MusicButton)
        val gamingButton = findViewById<ImageButton>(R.id.GamingButton)
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
                 R.id.nav_settings->{
                    val intent=Intent(this@MainActivity,Settings::class.java)
                    startActivity(intent)
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
        gkButton.setOnClickListener {
            val gk = Intent(this, GKActivity::class.java)
            startActivity(gk)
        }
        musicButton.setOnClickListener {
            val music = Intent(this, MusicActivity::class.java)
            startActivity(music)
        }
        gamingButton.setOnClickListener {
            val gaming = Intent(this, GamingActivity::class.java)
            startActivity(gaming)
        }
        animeButton.setOnClickListener {
            val anime = Intent(this, AnimeActivity::class.java)
            startActivity(anime)
        }
        sportsButton.setOnClickListener {
            val sports = Intent(this, SportsActivity::class.java)
            startActivity(sports)
        }
        updateNavHeader()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return if (actionBarDrawerToggle?.onOptionsItemSelected(item) == true) {
            true
        } else super.onOptionsItemSelected(item)
    }
    private fun showLogoutDialog()
    {
        val dialogBuilder=AlertDialog.Builder(this,R.style.CustomAlertDialog)
        dialogBuilder .setTitle("Log Out")
            .setMessage("Are you sure you want to logout ?")
            .setPositiveButton("Yes"){ _, _ ->  //dialog,which
                if(signOutFromApp())
                {
                    val intent=Intent(this,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }
            .setNegativeButton("No"){ dialog, _ ->
                dialog.cancel()
            }.show()
    }
    private fun signOutFromApp():Boolean
    {
        auth.signOut()
        Toast.makeText(this,"Logout Successfully",Toast.LENGTH_LONG).show()
        return true
    }
    private  fun updateNavHeader()
    {
        val navigationView=findViewById<NavigationView>(R.id.nav_view)
        val headerView=navigationView.getHeaderView(0)
        val nav_name=headerView.findViewById<TextView>(R.id.user_name)
        val nav_email=headerView.findViewById<TextView>(R.id.user_email)
        val nav_pic=headerView.findViewById<ImageView>(R.id.profile_pic)
        val currentUser=auth.currentUser
        if (currentUser != null) {
            nav_email.text = currentUser.email
            nav_name.text=currentUser.displayName
            val userpic=currentUser.photoUrl
            Glide.with(this).load(userpic).into(nav_pic)
        }
    }

}

