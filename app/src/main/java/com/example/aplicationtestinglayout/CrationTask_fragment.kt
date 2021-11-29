package com.example.aplicationtestinglayout

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.aplicationtestinglayout.databinding.FragmentCrationTaskFragmentBinding
import com.example.aplicationtestinglayout.model.Tarefas
import com.example.aplicationtestinglayout.viewModel_remoteBD.MainViewModel
import com.example.cardview.fragment.DatePickerFragment
import com.example.cardview.fragment.TimePickerListener
import java.text.SimpleDateFormat
import java.util.*


class CrationTask_fragment : Fragment(), TimePickerListener, AdapterView.OnItemSelectedListener {

    val mainViewModel: MainViewModel by activityViewModels()

    private var _tarefaSelecionada: Tarefas? = null
    private val tarefaSelecionada get() = _tarefaSelecionada!!

    private var _binding: FragmentCrationTaskFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_cration_task_fragment, container, false)

        carregarDados()

        mainViewModel.selectedDateLiveData.observe(viewLifecycleOwner, {
            selectedDate -> binding.inputData.setText(selectedDate.toString())
        })

        binding.inputData.setOnClickListener{

            DatePickerFragment(this).show(parentFragmentManager, "DatePicker")

        }

        binding.BotaoSalvarTarefa.setOnClickListener{
            inserirNoBanco()
        }

        return view

    }

    fun carregarDados() {
        _tarefaSelecionada = mainViewModel.tarefaSelecionada
        if (_tarefaSelecionada != null) {
            binding.taskTitleForm.setText(tarefaSelecionada.tituloTarefa)
            binding.descricaoTask.setText(tarefaSelecionada.descriTarefa)
            binding.inputData.setText(tarefaSelecionada.dataTarefa)
            binding.inputHora.setText(tarefaSelecionada.horaTarefa)
        } else {
            binding.taskTitleForm.text = null
            binding.descricaoTask.text = null
            binding.inputData.text = null
            binding.inputHora.text = null
        }
    }

    private fun inputCheck(
        titulo: String, desc: String,
        data: String, hora: String
    ): Boolean{
        return !(TextUtils.isEmpty(titulo) &&
                TextUtils.isEmpty(desc) &&
                TextUtils.isEmpty(data) &&
                TextUtils.isEmpty(hora)
                )
    }

    fun inserirNoBanco(){
        val titulo = binding.taskTitleForm.text.toString()
        val desc = binding.descricaoTask.text.toString()
        val data = binding.inputData.text.toString()
        val hora = binding.inputHora.text.toString()

        if(inputCheck(titulo, desc, data, hora)){
            _tarefaSelecionada = mainViewModel.tarefaSelecionada
            var atualizarCriar = ""
            if (_tarefaSelecionada != null) {
                val tarefas = Tarefas(0, titulo, desc, data,
                    hora
                )
                mainViewModel.updateTarefa(tarefas)
                atualizarCriar = "Tarefa Atualizada!"
            }else{
                val tarefas = Tarefas(0, titulo, desc, data,
                    hora
                )
                mainViewModel.addTarefa(tarefas)
                atualizarCriar = "Tarefa Adicionada!"
            }
            Toast.makeText(
                context, atualizarCriar,
                Toast.LENGTH_LONG
            ).show()

            findNavController().navigate(R.id.CreationTaskToList)
        }else{
            Toast.makeText(
                context, "Preencha todos os campos!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onTimeSelected(date: Date) {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val formatedDate = formatter.format(date).toString()
        mainViewModel.selectedDateLiveData.postValue(formatedDate)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val itemAtPosition: String = p0?.getItemAtPosition(p2) as String
        Log.d("Developer", "itemAtPosition: $itemAtPosition")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}


