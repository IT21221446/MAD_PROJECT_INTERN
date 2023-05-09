package com.example.mad_project_intern

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mad_project_intern.databinding.ActivityMain2Binding

class Main2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){

                R.id.home->replaceFragment(Home())
                R.id.search->replaceFragment(Search())
                R.id.settings->replaceFragment(Settings())
                R.id.feedback->replaceFragment(Feedback())
                R.id.profile->replaceFragment(Profile())

                else->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment:Fragment){

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}