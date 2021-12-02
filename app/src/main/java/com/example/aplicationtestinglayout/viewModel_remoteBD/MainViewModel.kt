package com.example.aplicationtestinglayout.viewModel_remoteBD

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicationtestinglayout.model.Tarefas
import com.example.cardview.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val repository: Repository

): ViewModel() {

    /*
    private val _myResponse = MutableLiveData<Response<List<Tarefas>>>()
    val myResponse: LiveData<Response<List<Tarefas>>> = _myResponse

    private val _myDeleteResponse = MutableLiveData<Response<Tarefas>>()
    val myDeleteResponse: LiveData<Response<Tarefas>> = _myDeleteResponse
     */

    val selectedDateLiveData: MutableLiveData<String> = MutableLiveData()

    var tarefaSelecionada: Tarefas? = null

    var contador: Int = 0

    lateinit var myQueryResponse: Flow<List<Tarefas>>

    init {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = formatter.format(Date())
        selectedDateLiveData.postValue(date.toString())

        viewModelScope.launch {
            myQueryResponse = repository.queryAllTarefas()
        }
    }

    fun listTarefas(){

        viewModelScope.launch {

            try {
                val response = repository.listTarefas()
                if (response.isSuccessful){
                    val listTarefas = response.body()!!
                    for (tarefa in listTarefas){
                        val findTarefas = repository.queryById(tarefa.id)
                        if(findTarefas.first() != null){
                            repository.updateRoom(tarefa)
                        }else{
                            repository.insertTarefas(tarefa)
                        }
                    }
                }else{
                    Log.d("Developer", "Erro: ${response.errorBody().toString()}")
                }

            }catch (e: Exception){
                Log.d("Developer", e.message.toString())
            }

        }

    }

    fun addTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            try {
                val response = repository.addTarefa(tarefas)
                if(response.isSuccessful){
                    repository.insertTarefas(tarefas)
                }else{
                    repository.insertTarefas(tarefas)
                }
            }catch (e: Exception){
                repository.insertTarefas(tarefas)
            }
        }
    }

    fun updateTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            try {
                repository.updateTarefa(tarefas)
                repository.updateRoom(tarefas)
            }catch (e: Exception){
                repository.updateRoom(tarefas)
            }
        }
    }

    fun deleteTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            try {
                repository.deleteTarefa(tarefas.id)
                repository.deleteTarefaRoom(tarefas)
            }catch (e: Exception){
                repository.deleteTarefaRoom(tarefas)
            }
        }
    }

}