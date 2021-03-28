package com.example.bookselect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.email_txt
import kotlinx.android.synthetic.main.activity_dashboard.name_txt
import kotlinx.android.synthetic.main.activity_nav__header.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    lateinit var toogle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var  navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser


        name_txt.text = currentUser?.displayName
        email_txt.text = currentUser?.email

        Glide.with(this).load(currentUser?.photoUrl).into(profile_images)

        logout.setOnClickListener {
            mAuth.signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }


        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Contact -> Toast.makeText(
                    applicationContext,
                    "882828....",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.Email -> Toast.makeText(
                    applicationContext,
                    "mokalpooja380@gmail.com",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.Logout -> Toast.makeText(applicationContext, "logout", Toast.LENGTH_SHORT)
                    .show()
            }
            true

        }

    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (toogle.onOptionsItemSelected(item)) {
                true
            }
            return super.onOptionsItemSelected(item)
        }
    }
