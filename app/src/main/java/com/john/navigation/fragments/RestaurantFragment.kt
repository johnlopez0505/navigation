package com.john.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.john.navigation.R
import com.john.navigation.databinding.FragmentRestaurantBinding
import com.john.navigation.controller.Controller


class RestaurantFragment : Fragment() {
    private lateinit var binding: FragmentRestaurantBinding
    lateinit var recyclerView : RecyclerView
    lateinit var controller: Controller
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRestaurantBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    fun init(){
        recyclerView = binding.myRecyclerView.findViewById(R.id.my_recycler_view)
        controller = Controller(requireContext())
        controller.iniciar(recyclerView)

        binding.fab.setOnClickListener{
            controller.addRestaurant(recyclerView)
        }

    }
}