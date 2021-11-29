package com.example.aplicationtestinglayout

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationtestinglayout.data.UserViewModel
import com.example.aplicationtestinglayout.databinding.FragmentTaskListFragmentBinding
import javax.sql.DataSource


class TaskList_fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_task_list_fragment, container, false)

        val adapter = RecyclerAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        val userViewModel = UserViewModel(context)
        userViewModel.lerTodosOsDados.observe(viewLifecycleOwner, {

            response -> adapter.setData(response)

        })

        return view
    }

}

