package com.example.aplicationtestinglayout

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicationtestinglayout.databinding.FragmentTaskListFragmentBinding
import javax.sql.DataSource


class TaskList_fragment : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    private var _binding: FragmentTaskListFragmentBinding? = null
    private var binding = _binding
    //private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentBinding = FragmentTaskListFragmentBinding.inflate(inflater, container, false)

        binding = fragmentBinding

        layoutManager = LinearLayoutManager(context)

        binding?.recyclerView?.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        binding?.recyclerView?.adapter = adapter

        return fragmentBinding.root

    }

}

