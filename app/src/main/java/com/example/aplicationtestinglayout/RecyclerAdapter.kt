package com.example.aplicationtestinglayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationtestinglayout.data.User

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder> () {

    private var userList = emptyList<User>()

    //var tipo = arrayOf(R.drawable.goal,R.drawable.clipboards,R.drawable.clipboards,R.drawable.habito,R.drawable.goal,R.drawable.clipboards,R.drawable.habito, R.drawable.goal, R.drawable.goal, R.drawable.goal)
    //var corDaView = arrayOf(R.drawable.recycle_task_color_yellow, R.drawable.recycle_task_collor_red, R.drawable.recycle_task_collor_red, R.drawable.recycle_task_color_green, R.drawable.recycle_task_color_yellow, R.drawable.recycle_task_collor_red, R.drawable.recycle_task_color_green, R.drawable.recycle_task_color_yellow, R.drawable.recycle_task_color_yellow, R.drawable.recycle_task_color_yellow,)

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        /*
        var tituloTask: TextView
        var descricaoTask: TextView
        var data: TextView
        //var hora: TextView
        var Itemtipo: ImageView
        var viewCor: ImageView
        var textId: TextView

         */

        init {

            /*
            //alterado pra testes
            tituloTask = itemView.findViewById(R.id.titulo)
            descricaoTask = itemView.findViewById(R.id.descri)
            data = itemView.findViewById(R.id.data)
            //hora = itemView.findViewById(R.id.hora)
            Itemtipo = itemView.findViewById(R.id.TypeImage)
            viewCor = itemView.findViewById(R.id.ColorViewTasks)
            textId = itemView.findViewById(R.id.StatusProv)
            //alterado pra testes

             */

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        val currentItem = userList[position]
        /*
        holder.textId.text = currentItem.id.toString()
        holder.tituloTask.text = currentItem.tituloTarefa
        holder.descricaoTask.text = currentItem.descriTarefa
        holder.data.text = currentItem.dataTarefa
        holder.hora.text = currentItem.horaTarefa
        holder.Itemtipo.setImageResource(R.drawable.recycle_task_color_yellow)
        holder.viewCor.setImageResource(R.drawable.recycle_task_color_yellow)

         */


    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){

        this.userList = user
        notifyDataSetChanged()

    }

}





