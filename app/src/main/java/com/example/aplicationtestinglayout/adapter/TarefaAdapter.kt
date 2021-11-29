package com.example.aplicationtestinglayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationtestinglayout.R
import com.example.aplicationtestinglayout.data.User
import com.example.aplicationtestinglayout.model.Tarefas

class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    private var listaTarefas = emptyList<Tarefas>()

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        var tituloTask: TextView
        var descricaoTask: TextView
        var data: TextView
        var hora: TextView
        var Itemtipo: ImageView
        var viewCor: ImageView
        var textId: TextView

        init {


            //alterado pra testes
            tituloTask = itemView.findViewById(R.id.titulo)
            descricaoTask = itemView.findViewById(R.id.descri)
            data = itemView.findViewById(R.id.data)
            hora = itemView.findViewById(R.id.hora)
            Itemtipo = itemView.findViewById(R.id.TypeImage)
            viewCor = itemView.findViewById(R.id.ColorViewTasks)
            textId = itemView.findViewById(R.id.textID)
            //alterado pra testes

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: TarefaAdapter.ViewHolder, position: Int) {

        val currentItem = listaTarefas[position]

        holder.textId.text = currentItem.Id.toString()
        holder.tituloTask.text = currentItem.tituloTarefa
        holder.descricaoTask.text = currentItem.descriTarefa
        holder.data.text = currentItem.dataTarefa
        holder.hora.text = currentItem.horaTarefa
        holder.Itemtipo.setImageResource(R.drawable.recycle_task_color_yellow)
        holder.viewCor.setImageResource(R.drawable.recycle_task_color_yellow)


    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

    fun setData(tarefas: List<Tarefas>){

        this.listaTarefas = tarefas
        notifyDataSetChanged()

    }

}