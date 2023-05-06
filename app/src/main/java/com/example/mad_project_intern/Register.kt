package com.example.mad_project_intern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mad_project_intern.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Register : AppCompatActivity() {



    private lateinit var binding:ActivityRegisterBinding
    private lateinit var firebaseAuth:FirebaseAuth


    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtRePassword: EditText

    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbRef=FirebaseDatabase.getInstance().getReference("User")

        firebaseAuth=FirebaseAuth.getInstance()

        binding.RegButton.setOnClickListener {
            val edtName = binding.Name.text.toString()
            val edtEmail = binding.Email.text.toString()
            val edtPassword = binding.Password.text.toString()
            val edtRePassword = binding.RePassword.text.toString()

            if(edtName.isNotEmpty() && edtEmail.isNotEmpty() && edtPassword.isNotEmpty() && edtRePassword.isNotEmpty()){

                    if(edtPassword==edtRePassword)
                    {
                        val userId = dbRef.push().key!!
                        val user = UserModel(userId, edtName, edtEmail, edtPassword)
                        dbRef.child(userId).setValue(user).addOnCompleteListener {
                            Toast.makeText(this, "User Profile Created", Toast.LENGTH_SHORT).show()
                        }

                        firebaseAuth.createUserWithEmailAndPassword(edtEmail,edtPassword).addOnCompleteListener {

                            if(it.isSuccessful){

                                Toast.makeText(this, "User Profile Created", Toast.LENGTH_SHORT).show()
                                        val intent =Intent(this,Login::class.java)
                                        startActivity(intent)

                            }else{
                                Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        Toast.makeText(this,"Password is not matching",Toast.LENGTH_SHORT).show()
                    }
                }else {
                Toast.makeText(this,"Empty Filed are not Allowed",Toast.LENGTH_SHORT).show()
                }
        }

        binding.ResetButton.setOnClickListener{

            val Reset=binding.ResetButton

            edtName = findViewById(R.id.Name)
            edtEmail = findViewById(R.id.Email)
            edtPassword = findViewById(R.id.Password)
            edtRePassword = findViewById(R.id.RePassword)
            Reset.setOnClickListener {
                edtName.text.clear()
                edtEmail.text.clear()
                edtPassword.text.clear()
                edtRePassword.text.clear()
            }
        }
    }
}

