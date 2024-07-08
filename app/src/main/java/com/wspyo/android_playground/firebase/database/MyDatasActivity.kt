package com.wspyo.android_playground.firebase.database

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.wspyo.android_playground.R
import com.wspyo.android_playground.recyclerview.RVAdapter

class MyDatasActivity : AppCompatActivity() {

    private lateinit var database : FirebaseDatabase
    private lateinit var auth: FirebaseAuth


    lateinit var rvAdapter: DataRVAdapter
    val dataModelList  = mutableListOf<DataModel>()
    val itemKeyList = mutableListOf<String>()

    val TAG = MyDatasActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_datas)
        database = Firebase.database
        auth = FirebaseAuth.getInstance()

        findViewById<Button>(R.id.addDataBtn).setOnClickListener{
            showDialog()
        }


        val rv : RecyclerView = findViewById(R.id.rv_data)
        rvAdapter = DataRVAdapter(dataModelList,this,itemKeyList)

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(this)

        getMyData()
    }

    private fun getMyData(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataModelList.clear()
                itemKeyList.clear()
              for(data in dataSnapshot.children){
                  val dataModel = data.getValue(DataModel::class.java)
                  dataModelList.add(dataModel!!)
                  itemKeyList.add(data.key.toString())
              }

                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        database.getReference("data").child(auth.currentUser?.uid.toString()).addValueEventListener(postListener)
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Input data")

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(16, 16, 16, 16)

        val titleInputArea = EditText(this)
        titleInputArea.hint = "Enter Title"

        val contentInputArea = EditText(this)
        contentInputArea.hint = "Enter Content"

        layout.addView(titleInputArea)
        layout.addView(contentInputArea)
        builder.setView(layout)


        builder.setPositiveButton("확인") { dialog, which ->
            val title = titleInputArea.text.toString()
            val content = contentInputArea.text.toString()

            val dataModel = DataModel("",title,content)

            database.getReference("data").child(auth.currentUser?.uid.toString()).push().setValue(dataModel)

            Toast.makeText(this,"${dataModel.title} 데이터 저장 성공",Toast.LENGTH_SHORT).show()
        }

        builder.setNegativeButton("취소") { dialog, which ->
            dialog.cancel()
        }
        builder.show()
    }
}