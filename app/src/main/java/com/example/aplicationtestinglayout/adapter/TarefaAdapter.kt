package com.example.aplicationtestinglayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationtestinglayout.R
import com.example.aplicationtestinglayout.data.User
import com.example.aplicationtestinglayout.model.Tarefas
import com.example.aplicationtestinglayout.viewModel_remoteBD.MainViewModel

class TarefaAdapter(

    private val taskItemClickListener: TaskItemClickListener,
    private val MainViewModel: MainViewModel
    )
    : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>()
    {

    private var listaTarefas = emptyList<Tarefas>()

    class TarefaViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        var tituloTask: TextView
        var descricaoTask: TextView
        var data: TextView
        var Itemtipo: ImageView
        var viewCor: ImageView
        var textId: TextView

        init {


            //alterado pra testes
            tituloTask = itemView.findViewById(R.id.titulo)
            descricaoTask = itemView.findViewById(R.id.descri)
            data = itemView.findViewById(R.id.data)
            Itemtipo = itemView.findViewById(R.id.TypeImage)
            viewCor = itemView.findViewById(R.id.ColorViewTasks)
            textId = itemView.findViewById(R.id.textID)
            //alterado pra testes

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaAdapter.TarefaViewHolder {

        val layoutAdapter = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)

        return TarefaViewHolder(layoutAdapter)

    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {

        val currentItem = listaTarefas[position]

        holder.textId.text = currentItem.Id.toString()
        holder.tituloTask.text = currentItem.tituloTarefa
        holder.descricaoTask.text = currentItem.descriTarefa
        holder.data.text = currentItem.dueDate

    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

    fun setData(tarefas: List<Tarefas>){

        this.listaTarefas = tarefas
        notifyDataSetChanged()

    }

}