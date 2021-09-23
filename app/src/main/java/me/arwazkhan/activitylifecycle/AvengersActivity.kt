package me.arwazkhan.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
 Kajal1308
import android.widget.ImageView
import android.widget.Toast

import me.arwazkhan.activitylifecycle.databinding.ActivityAvengersBinding
 master

class AvengersActivity : AppCompatActivity() {
    lateinit var binding: ActivityAvengersBinding
    var titleName : String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences
 Kajal1308
    lateinit var btnSend: Button
    lateinit var etMessage: EditText
    lateinit var btnLogout: Button
    lateinit var image: ImageView
    lateinit var imagecapt: ImageView
    lateinit var imagethor: ImageView
    lateinit var imagehulk: ImageView
    lateinit var imagepanther: ImageView
    lateinit var imagewidow: ImageView


    lateinit var btn_Send: Button
    lateinit var et_Message: EditText
    lateinit var btn_Logout: Button
 master

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAvengersBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)


        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        setContentView(binding.root)
        titleName = sharedPreferences.getString("Title","The Avengers")
        title=titleName

Kajal1308
        btnSend = findViewById(R.id.btnSend)
        etMessage = findViewById(R.id.etMessage)
        image = findViewById(R.id.imgTonyStark)
        imagecapt = findViewById(R.id.imgCaptainAmerica)
        imagethor = findViewById(R.id.imgThor)
        imagehulk = findViewById(R.id.imgBruce)
        imagepanther = findViewById(R.id.imgTchalla)
        imagewidow = findViewById(R.id.imgNatasha)


        btn_Send = binding.btnSend
        et_Message = binding.etMessage
master

        btn_Send.setOnClickListener {
            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            val message = et_Message.text.toString()
            intent.putExtra("Message", message)
            startActivity(intent)
        }
        image.setOnClickListener({
            Toast.makeText(this,"Send message to Tony Stark",Toast.LENGTH_LONG).show()
        })
        imagecapt.setOnClickListener({
            Toast.makeText(this,"Send message to Steve Rogers",Toast.LENGTH_LONG).show()
        })
        imagethor.setOnClickListener({
            Toast.makeText(this,"Send message to Thor Odison",Toast.LENGTH_LONG).show()
        })
        imagehulk.setOnClickListener({
            Toast.makeText(this,"Send message to Bruce Banner",Toast.LENGTH_LONG).show()
        })
        imagepanther.setOnClickListener({
            Toast.makeText(this,"Send message to T Challa",Toast.LENGTH_LONG).show()
        })
        imagewidow.setOnClickListener({
            Toast.makeText(this,"Send message to Natasha Romanoff", Toast.LENGTH_LONG).show()
        })


        btn_Logout = binding.btnLogout

        btn_Logout.setOnClickListener {
            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }
}