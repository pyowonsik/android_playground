package com.wspyo.android_playground.firebase.database

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.wspyo.android_playground.R
import java.io.ByteArrayOutputStream

class DataDetailActivity : AppCompatActivity() {

    private lateinit var database : FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private lateinit var imageArea : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_detail)

        // 갤러리 접근하여 선택한 사진 ImageView에 넣기
        imageArea = findViewById<ImageView>(R.id.imageArea)
        val getAction = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback{ uri ->
                imageArea.setImageURI(uri)
            }
        )
        imageArea.setOnClickListener{
            getAction.launch("image/*")
        }
        //

        database = Firebase.database
        auth = FirebaseAuth.getInstance()

        val itemKey : String = intent.getStringExtra("key").toString()

        bindData(itemKey)

        findViewById<Button>(R.id.imageSaveBtn).setOnClickListener{
            uploadImage(itemKey)
            val intent = Intent(this,MyDatasActivity::class.java)
            startActivity(intent)
        }


    }

    private fun bindData(itemKey : String){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                    Log.d("DataDetailActivity",dataSnapshot.toString())
                    val item = dataSnapshot.getValue(DataModel::class.java)

                val storageRef = Firebase.storage.reference.child(itemKey + ".png")
                storageRef.downloadUrl.addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                    Glide.with(baseContext)
                        .load(task.result)
                        .into(imageArea)
                    }
                }

                findViewById<TextView>(R.id.titleArea).text = item?.title
                findViewById<TextView>(R.id.contentArea).text = item?.content
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("DataDetailActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        database.getReference("data").child(auth.currentUser?.uid.toString()).child(itemKey).addValueEventListener(postListener)
    }

    private fun uploadImage(uid : String){

        val storage = Firebase.storage
        val storageRef = storage.reference.child("$uid.png")

        imageArea.isDrawingCacheEnabled = true
        imageArea.buildDrawingCache()
        val bitmap = (imageArea.drawable as BitmapDrawable).bitmap
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        var uploadTask = storageRef.putBytes(data)
        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
        }.addOnSuccessListener { taskSnapshot ->
            // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
            // ...
        }
    }

}