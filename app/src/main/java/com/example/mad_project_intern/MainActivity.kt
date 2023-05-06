package com.example.mad_project_intern

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var signupBtn: Button
    private lateinit var loginBtn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signupBtn=findViewById(R.id.signupBtn)
        loginBtn=findViewById(R.id.loginBtn)

        signupBtn.setOnClickListener{
            val signup= Intent(this, Register::class.java)
            startActivity(signup)
        }

        loginBtn.setOnClickListener {
            val login = Intent(this, Login::class.java)
            startActivity(login)

        }
    }
}