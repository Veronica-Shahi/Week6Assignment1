package com.example.week_6_assignment_1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week_6_assignment_1.R
import com.example.week_6_assignment_1.model.UserData


class UserAdapter(
        val lststds : ArrayList<UserData>,
        val context : Context
        ):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
            class UserViewHolder(view: View):RecyclerView.ViewHolder(view){
               val stdimage : ImageView
               val tvname : TextView
               val tvage : TextView
               val tvaddress : TextView
               val tvgender : TextView
               val delete : ImageView

               init {
                   stdimage = view.findViewById(R.id.stdimage)
                   tvname= view.findViewById(R.id.tvname)
                   tvage= view.findViewById(R.id.tvage)
                   tvaddress= view.findViewById(R.id.tvaddress)
                   tvgender= view.findViewById(R.id.tvgender)
                   delete = view.findViewById(R.id.delete)
               }
            }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.display_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        val stdlst = lststds[position]
        holder.tvname.text = stdlst.etfullname
        holder.tvage.text = stdlst.etage.toString()
        holder.tvaddress.text = stdlst.etaddress
        holder.tvgender.text = stdlst.gender

        holder.delete.setOnClickListener{
            lststds.removeAt(position)
            notifyDataSetChanged()
        }
        Glide.with(context)
                .load(stdlst.etimage)
                .into(holder.stdimage)
    }

    override fun getItemCount(): Int {
        return lststds.size
    }
}