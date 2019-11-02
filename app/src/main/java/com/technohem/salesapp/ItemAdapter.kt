package com.technohem.salesapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

class ItemAdapter(var context: Context, var list:ArrayList<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemHolder).bind(list[position].name,list[position].price,list[position].photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var v: View = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return ItemHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(n:String,p:String,u:String)
        {
            itemView.item_name.text=n
            itemView.item_price.text= p
            var web:String="http://192.168.0.109/SalesWeb/images/"+u
            web=web.replace(" ","%20")
            Picasso.with(itemView.context).load(web).into(itemView.item_photo)
        }
    }
}