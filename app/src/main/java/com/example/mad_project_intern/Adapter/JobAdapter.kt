package com.example.mad_project_intern.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_project_intern.Models.JobModel
import com.example.mad_project_intern.R

class JobAdapter(private val jobList: ArrayList<JobModel>):RecyclerView.Adapter<JobAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.job_list,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentJob=jobList[position]
        holder.jobName.text=currentJob.jobTittle
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val jobName:TextView=itemView.findViewById(R.id.jobName)


    }
}