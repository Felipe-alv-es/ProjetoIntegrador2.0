package com.example.aplicationtestinglayout

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder> () {

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        var tituloTask: TextView
        var descricaoTask: TextView
        var data: TextView
        var hora: TextView
        var Itemtipo: ImageView

        init {


            //alterado pra testes
            tituloTask = itemView.findViewById(R.id.titulo)
            descricaoTask = itemView.findViewById(R.id.descri)
            data = itemView.findViewById(R.id.data)
            hora = itemView.findViewById(R.id.hora)
            Itemtipo = itemView.findViewById(R.id.TypeImage)
            //alterado pra testes

        }

    }

    //Atributos da recyclerView
    var title = arrayOf("Comprar um carro zero", "Teste2", "Teste3", "Teste4", "Teste5", "Teste6", "Teste7", "Teste8", "Teste9" )
    var descri = arrayOf("Comprar um carro zero caro pra caramba slc","Teste2","Teste3","Teste4","Teste5","Teste6","Teste7", "Teste8", "Teste9")
    var data = arrayOf("04/09/2077","Teste2","Teste3","Teste4","Teste5","Teste6","Teste7", "Teste8", "Teste9")
    var hora = arrayOf("Não especificado","Teste2","Teste3","Teste4","Teste5","Teste6","Teste7", "Teste8", "Teste9")
    var tipo = arrayOf(R.drawable.goal,R.drawable.clipboards,R.drawable.clipboards,R.drawable.habito,R.drawable.goal,R.drawable.clipboards,R.drawable.habito, R.drawable.goal, R.drawable.goal)
    //Atributos da recyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.tituloTask.text = title[position]
        holder.descricaoTask.text = descri[position]
        holder.data.text = data[position]
        holder.hora.text = hora[position]
        holder.Itemtipo.setImageResource(tipo[position])

    }

    override fun getItemCount(): Int {
        return title.size
    }

}





