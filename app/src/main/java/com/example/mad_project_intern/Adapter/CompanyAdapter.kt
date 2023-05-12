package com.example.mad_project_intern.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mad_project_intern.Home
import com.example.mad_project_intern.Models.Company
import com.example.mad_project_intern.R
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

class CompanyAdapter(private val context: Context) :RecyclerView.Adapter<CompanyAdapter.ViewHolder>() {


    private val companyList=ArrayList<Company>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val company = companyList[position]
        holder.companyNameTextView.text = company.companyName
        holder.companyCountryTextView.text = company.companyCountry
        Glide.with(context).load(company.uploadingImage).into(holder.imageView)
    }

    override fun getItemCount():Int{
        return companyList.size
    }

    fun updateCompanyList(companyList: List<Company>){
        this.companyList.clear()
        this.companyList.addAll(companyList)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView3)
        val companyNameTextView: TextView = itemView.findViewById(R.id.companyNameTextView)
        val companyCountryTextView: TextView = itemView.findViewById(R.id.companyCountryTextView)
    }

}