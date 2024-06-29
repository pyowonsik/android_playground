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
import com.wspyo.android_playground.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private  lateinit var  binding : ActivityJoinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)

        val email = binding.emailArea
        val password = binding.passwordArea

        binding.joinBtn.setOnClickListener{
            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this,"회원가입 성공",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,AuthResultActivity::class.java)
                        val user = auth.currentUser
                        startActivity(intent)
                    } else {
                        Toast.makeText(this,"회원가입 실패",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}