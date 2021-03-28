package com.example.bookselect

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.email_txt
import kotlinx.android.synthetic.main.activity_dashboard.name_txt
import kotlinx.android.synthetic.main.activity_nav__header.*

class Nav_HeaderActivity : AppCompatActivity() {
    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav__header)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser


        name_txt.text = currentUser?.displayName
        email_txt.text = currentUser?.email

        Glide.with(this).load(currentUser?.photoUrl).into(profile_image);

       /* logout.setOnClickListener {
            mAuth.signOut()
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
            finish()*/
        }
    }
