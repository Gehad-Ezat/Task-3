package com.gehad.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val myfilms: ArrayList<Films>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
         return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
       val film = myfilms[position]
        holder.image .setImageResource(film.imageView)
        holder.descrip.text=film.textView
    }

    override fun getItemCount(): Int {
     return  myfilms.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

     val descrip: TextView=  view.findViewById(R.id.textView)
       val image: ImageView =view.findViewById(R.id.imageView)

    }
}