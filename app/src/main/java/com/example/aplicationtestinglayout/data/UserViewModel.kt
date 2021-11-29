package com.example.aplicationtestinglayout.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (context: Context?): ViewModel() {

    val lerTodosOsDados: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDataBase.getDatabase(context!!).userDao()
        repository = UserRepository(userDao)
        lerTodosOsDados = repository.lerTodosOsDados
    }

    fun addUser(user: User){

        viewModelScope.launch ( Dispatchers.IO ){

            repository.addUser(user)

        }

    }

    fun removeUser(user: User){

        viewModelScope.launch (Dispatchers.IO) {

            repository.removeUser(user)

        }

    }

}