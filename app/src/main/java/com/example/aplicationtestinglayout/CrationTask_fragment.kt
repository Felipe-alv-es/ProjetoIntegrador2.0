package com.example.aplicationtestinglayout

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.aplicationtestinglayout.data.User
import com.example.aplicationtestinglayout.data.UserViewModel
import com.example.aplicationtestinglayout.databinding.FragmentCrationTaskFragmentBinding


class CrationTask_fragment : Fragment() {

    var dadosValidados: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cration_task_fragment, container, false)
        val buttonSalvar = view.findViewById<Button>(R.id.BotaoSalvarTarefa)

        //Instanciando ViewModel do banco de dados
        val userViewModel = UserViewModel(context)
        //Instanciando ViewModel do banco de dados


        // Variaveis para validação de Inputs
        var title = view.findViewById<EditText>(R.id.taskTitleForm)
        var descri = view.findViewById<EditText>(R.id.descricaoTask)
        var date = view.findViewById<EditText>(R.id.inputData)
        var hour = view.findViewById<EditText>(R.id.inputHora)
        // Variaveis para validação de Inputs

        fun inserirNoBanco(){

            val tituloTarefa = title.text.toString()
            val descriTarefa = descri.text.toString()
            val dataTarefa = date.text.toString()
            val horaTarefa = hour.text.toString()

            if (dadosValidados == true) {

                val user = User(0, tituloTarefa, descriTarefa, dataTarefa, horaTarefa)
                userViewModel.addUser(user)
                Toast.makeText(
                    context, "Tarefa adicionada com sucesso",
                    Toast.LENGTH_LONG
                ).show()
                Navigation.findNavController(view).navigate(R.id.CreationTaskToList)
            }

        }

        buttonSalvar?.setOnClickListener{

            validaForm(title.text.toString(), descri.text.toString(), date.text.toString(), hour.text.toString())
            inserirNoBanco()

        }

        return view
    }

    private fun validaForm(titulo: String, descricao: String, data: String, hora: String) {
        if ((TextUtils.isEmpty(titulo) || TextUtils.isEmpty(descricao) || TextUtils.isEmpty(data) || TextUtils.isEmpty(hora))){
            return Toast.makeText(context, "Algum campo solicitado está em branco!", Toast.LENGTH_SHORT).show()
        }
        else if (titulo.length > 50 || descricao.length > 150){
            return Toast.makeText(context, "Foram excedidas as quantidas maximas de caracteres", Toast.LENGTH_SHORT).show()
        }
        else if (data.length > 10 || hora.length > 5){
            return Toast.makeText(context, "A data ou hora foram digitadas incorretamente", Toast.LENGTH_SHORT).show()
        }
        else{
            dadosValidados = true
            return
        }
    }

}
