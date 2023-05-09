package com.example.mad_project_intern

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mad_project_intern.databinding.ActivityLoginBinding
import com.example.mad_project_intern.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {

private lateinit var binding: ActivityLoginBinding
private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding=ActivityLoginBinding.inflate(layoutInflater)

    setContentView(binding.root)
    firebaseAuth=FirebaseAuth.getInstance()

    binding.btnSignup.setOnClickListener{
        val intent=Intent(this,Register::class.java)
        startActivity(intent)
    }

    binding.btnLogin.setOnClickListener{

        val email=binding.email.text.toString()
        val password=binding.password.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()) {

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {

                if (it.isSuccessful) {
                    Toast.makeText(this,"Okey",Toast.LENGTH_SHORT).show()

                     val intent = Intent(this, Main2::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this,"Empty Filed are not Allowed",Toast.LENGTH_SHORT).show()
        }

    }
}

}

