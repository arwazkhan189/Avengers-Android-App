package me.arwazkhan.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import me.arwazkhan.activitylifecycle.databinding.ActivityAvengersBinding

class AvengersActivity : AppCompatActivity() {
    lateinit var binding: ActivityAvengersBinding
    var titleName : String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btn_Send: Button
    lateinit var et_Message: EditText
    lateinit var btn_Logout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAvengersBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)


        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        setContentView(binding.root)
        titleName = sharedPreferences.getString("Title","The Avengers")
        title=titleName

        btn_Send = binding.btnSend
        et_Message = binding.etMessage

        btn_Send.setOnClickListener {
            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)
            val message = et_Message.text.toString()
            intent.putExtra("Message", message)
            startActivity(intent)
        }

        btn_Logout = binding.btnLogout

        btn_Logout.setOnClickListener {
            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }

    }
}