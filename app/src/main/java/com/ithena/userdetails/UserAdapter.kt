package com.ithena.userdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val context: Context, private val productlist:List<User>):
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){

        var title: TextView
        var price: TextView
        //var category: TextView
        //var rate: TextView
        // var count:TextView



        init {
            title=itemView.findViewById(R.id.title)
            price=itemView.findViewById(R.id.price)
            //category=itemView.findViewById(R.id.category)
            //rate=itemView.findViewById(R.id.rate)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.user,parent,false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text=productlist[position].firstName
        holder.price.text= productlist[position].lastName
        //holder.category.text= productlist[position].age.toString()
        //holder.rate.text=productlist[position].address.toString()
    }

    override fun getItemCount(): Int {
        return  productlist.size
    }
}


