package com.example.aplicationtestinglayout

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationtestinglayout.adapter.TarefaAdapter
import com.example.aplicationtestinglayout.data.UserViewModel
import com.example.aplicationtestinglayout.databinding.FragmentTaskListFragmentBinding
import com.example.aplicationtestinglayout.model.Tarefas
import com.example.aplicationtestinglayout.viewModel_remoteBD.MainViewModel
import com.example.cardview.repository.Repository
import javax.sql.DataSource


class TaskList_fragment : Fragment() {

    val mainViewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentTaskListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTaskListFragmentBinding.inflate(inflater, container, false)


        val adapter = TarefaAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)

        mainViewModel.listTarefas()
        mainViewModel.myResponse.observe(viewLifecycleOwner, {

            response ->
            response.body()?.let {adapter.setData(it)}

        })




        /*

        //Banco de dados Local

        val adapter = RecyclerAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        val userViewModel = UserViewModel(context)
        userViewModel.lerTodosOsDados.observe(viewLifecycleOwner, {

            response -> adapter.setData(response)

        })
        */


        return binding.root
    }

}

