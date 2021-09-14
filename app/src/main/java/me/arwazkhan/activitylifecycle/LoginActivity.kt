package me.arwazkhan.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    lateinit var sharedPreferences: SharedPreferences

    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)

        if (isLoggedIn){
            val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            val nameAvenger: String

            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            if(mobileNumber.isEmpty() || password.isEmpty()){
                Toast.makeText(this@LoginActivity, "Enter All Fields", Toast.LENGTH_LONG).show()
            }
            else{
                if (mobileNumber == validMobileNumber) {
                    when (password) {
                        validPassword[0] -> {
                            nameAvenger = "Iron Man"
                            savePreferences(nameAvenger)
                            startActivity(intent)
                        }
                        validPassword[1] -> {
                            nameAvenger = "Captain America"
                            savePreferences(nameAvenger)
                            startActivity(intent)
                        }
                        validPassword[2] -> {
                            nameAvenger = "The Hulk"
                            savePreferences(nameAvenger)
                            startActivity(intent)
                        }
                        validPassword[3] -> {
                            nameAvenger = "The Avengers"
                            savePreferences(nameAvenger)
                            startActivity(intent)
                        }
                        else -> Toast.makeText(
                            this@LoginActivity,
                            "Incorrect Password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Incorrect Credential", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    private fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply() //we can use commit() also
        sharedPreferences.edit().putString("Title",title).apply()
    }
}