package com.example.mad_project_intern.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mad_project_intern.Repositories.companyRepository

class companyViewModel:ViewModel() {

    private val repository:companyRepository
    private val _allCompanies=MutableLiveData<List<Company>>()
    val allCompanies:LiveData<List<Company>> = _allCompanies

    init{
                repository=companyRepository().getInstance()
        repository.loadComapanies(_allCompanies)
            }
}