package com.wspyo.android_playground.firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.wspyo.android_playground.R

class AuthResultActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_result)

        auth = FirebaseAuth.getInstance()

        findViewById<TextView>(R.id.currentUserEmailArea).text =  auth.currentUser?.email.toString()

        findViewById<Button>(R.id.logoutBtn).setOnClickListener{
            auth.signOut()
            val intent = Intent(this,FireBasePracticeActivity::class.java)
            startActivity(intent)
        }

    }
}