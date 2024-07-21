package com.wspyo.android_playground

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wspyo.android_playground.firebase.FireBasePracticeActivity
import com.wspyo.android_playground.fragment.MainFragmentActivity
import com.wspyo.android_playground.recyclerview.RecyclerViewPracticeActivity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.wspyo.android_playground.access_view.AccessViewActivity
import com.wspyo.android_playground.data_binding.DataBindingDeepActivity
import com.wspyo.android_playground.view_binding_adpter.ViewBindingAdapterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.bindingBtn).setOnClickListener{
            startActivity(Intent(this,FindViewByIdTestActivity::class.java))
        }


        findViewById<Button>(R.id.intentBtn).setOnClickListener{
            val intent = Intent(this,IntentTestActivity::class.java)
            intent.putExtra("value1", "android play")
            intent.putExtra("value2","2024-06-06")
            startActivity(intent)
        }

        findViewById<Button>(R.id.listViewBtn).setOnClickListener{
            startActivity(Intent(this,ListViewPracticeActivity::class.java))
        }

        findViewById<Button>(R.id.recyclerViewBtn).setOnClickListener{
            startActivity(Intent(this,RecyclerViewPracticeActivity::class.java))
        }

        findViewById<Button>(R.id.fragmentBtn).setOnClickListener{
            startActivity(Intent(this,MainFragmentActivity::class.java))
        }


        findViewById<Button>(R.id.firebaseBtn).setOnClickListener{
            startActivity(Intent(this,FireBasePracticeActivity::class.java))
        }

        findViewById<Button>(R.id.notificationBtn).setOnClickListener{
                Toast.makeText(this,"알림 보내기",Toast.LENGTH_SHORT).show()
//            val isTiramisuOrHigher = Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU
//            val notificationPermission = Manifest.permission.POST_NOTIFICATIONS
//
//            var hasNotificationPermission =
//                if (isTiramisuOrHigher)
//                    ContextCompat.checkSelfPermission(this, notificationPermission) == PackageManager.PERMISSION_GRANTED
//                else true
//
//            val launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()){
//                hasNotificationPermission = it
//
//            }
//
//            if (!hasNotificationPermission) {
//                launcher.launch(notificationPermission)
//            }
            createNotificationChannel()
            sendNotification()
        }
        findViewById<Button>(R.id.accessViewBtn).setOnClickListener{
            startActivity(Intent(this,AccessViewActivity::class.java))
        }

        findViewById<Button>(R.id.dataBindingDeepBtn).setOnClickListener{
            startActivity(Intent(this,DataBindingDeepActivity::class.java))
        }

        findViewById<Button>(R.id.viewBindingAdapterBtb).setOnClickListener{
            startActivity(Intent(this,ViewBindingAdapterActivity::class.java))
        }

    }
    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "name"
            val descriptionText = "description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("Test_Channel", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun sendNotification() {
        var builder = NotificationCompat.Builder(this, "Test_Channel")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("매칭완료")
            .setContentText("매칭이 완료 되었습니다. 저사람도 나를 좋아해요")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//        with(NotificationManagerCompat.from(this)){
//            notify(123, builder.build())
//        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(123, builder.build())
    }


}