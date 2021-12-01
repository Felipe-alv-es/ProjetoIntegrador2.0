package com.example.aplicationtestinglayout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationtestinglayout.R
import com.example.aplicationtestinglayout.model.Tarefas
import com.example.aplicationtestinglayout.viewModel_remoteBD.MainViewModel

class TarefaAdapter(

    private val taskItemClickListener: TaskItemClickListener,
    private val mainViewModel: MainViewModel
    )
    : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>()
    {

    private var listaTarefas = emptyList<Tarefas>()

    class TarefaViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textNome = view.findViewById<TextView>(R.id.titulo)
        val textDesc = view.findViewById<TextView>(R.id.descri)
        val textDono = view.findViewById<TextView>(R.id.DonoProv)
        val textData = view.findViewById<TextView>(R.id.data)
        val textStatus = view.findViewById<TextView>(R.id.StatusProv)
        val buttonDeletar = view.findViewById<Button>(R.id.buttonDeletar)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {

        val layoutAdapter = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)

        return TarefaViewHolder(layoutAdapter)

    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {

        val tarefa = listaTarefas[position]

        holder.textNome.text = tarefa.name
        holder.textDesc.text = tarefa.description
        holder.textDono.text = tarefa.assignetTo
        holder.textData.text = tarefa.dueDate
        holder.textStatus.text = tarefa.status

        holder.buttonDeletar.setOnClickListener {
            mainViewModel.deleteTarefa(tarefa.id)
        }

        holder.itemView.setOnClickListener {
            taskItemClickListener.onTaskClicked(tarefa)
        }

    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

    fun setData(tarefas: List<Tarefas>){

        this.listaTarefas = tarefas
        notifyDataSetChanged()

    }

}