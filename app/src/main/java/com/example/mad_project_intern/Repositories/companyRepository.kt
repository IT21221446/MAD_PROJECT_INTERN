package com.example.mad_project_intern.Repositories

import androidx.lifecycle.MutableLiveData
import com.example.mad_project_intern.Models.Company
import com.google.android.play.core.integrity.e
import com.google.firebase.database.*

class companyRepository {
    private val databaseReference:DatabaseReference=FirebaseDatabase.getInstance().getReference("companies")

    @Volatile private var INSTANCE : companyRepository ?= null

    fun getInstance() : companyRepository {
        return INSTANCE ?: synchronized(this) {

            val instance = companyRepository()
            INSTANCE = instance
            instance
        }
    }


    fun loadComapanies(companyList:MutableLiveData<List<Company>>)
    {
        databaseReference.addValueEventListener(object :ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
               try{
                   val _comapnyList: List<Company> = snapshot.children.map{dataSnapshot->
                        dataSnapshot.getValue(Company::class.java)!!
                   }
                   companyList.postValue(_comapnyList)
               }

               catch (e:Exception)
               {

               }            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}