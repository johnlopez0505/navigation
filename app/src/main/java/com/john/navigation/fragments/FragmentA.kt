package com.john.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.john.navigation.R
import com.john.navigation.databinding.FragmentABinding

class FragmentA : Fragment() {
    lateinit var navController: NavController //nuestro navController
    lateinit var bindingFragment: FragmentABinding //utilizamos binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentABinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        val viewFragmentoA = bindingFragment.root
        return viewFragmentoA
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHost = requireActivity() //referencia del activity
            .supportFragmentManager //administrador de Fragmentos
            .findFragmentById(R.id.fragment_container_view) //buscamos elContenedor de Fragmentos

        navHost.let {//Si entramos dentro, no es nulo.
            navController = navHost!!.findNavController() //buscamos su NavController
            bindingFragment.buttonA.setOnClickListener{
                navController.navigate(R.id.action_fragmentA_to_fragmentStart) //navegamos
            }

        }
    }
}

