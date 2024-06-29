package com.wspyo.android_playground.firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.wspyo.android_playground.R
import com.wspyo.android_playground.databinding.ActivityFireBasePracticeBinding

class FireBasePracticeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding : ActivityFireBasePracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_base_practice)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this,R.layout.activity_fire_base_practice)

        val email = binding.emailArea
        val password = binding.passwordArea


        binding.loginBtn.setOnClickListener{
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"로그인 성공", Toast.LENGTH_LONG).show()
                        val intent = Intent(this,AuthResultActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"로그인 실패", Toast.LENGTH_LONG).show()
                    }
                }
        }

        binding.joinBtn.setOnClickListener{
            val intent = Intent(this,JoinActivity::class.java)
            startActivity(intent)
        }
    }
}