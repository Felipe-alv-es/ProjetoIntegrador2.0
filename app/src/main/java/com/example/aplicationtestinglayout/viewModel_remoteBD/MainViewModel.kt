package com.example.aplicationtestinglayout.viewModel_remoteBD

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicationtestinglayout.model.Tarefas
import com.example.cardview.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

    private val repository: Repository

): ViewModel() {

    private val _myResponse = MutableLiveData<Response<List<Tarefas>>>()
    val myResponse: LiveData<Response<List<Tarefas>>> = _myResponse

    val selectedDateLiveData: MutableLiveData<String> = MutableLiveData()

    var tarefaSelecionada: Tarefas? = null

    init {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = formatter.format(Date())
        selectedDateLiveData.postValue(date.toString())
    }

    fun listTarefas(){

        viewModelScope.launch {

            val response = repository.listTarefas()
            _myResponse.value = response

        }

    }

    fun addTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            val response = repository.addTarefa(tarefas)
        }
    }

    fun updateTarefa(tarefas: Tarefas){
        viewModelScope.launch {
            val response = repository.updateTarefa(tarefas)
        }
    }

}