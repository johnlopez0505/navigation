package com.john.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.john.navigation.R
import com.john.navigation.databinding.FragmentStartBinding

class FragmentStart : Fragment() {
    lateinit var navController : NavController //nuestro navController
    lateinit var bindingFragment : FragmentStartBinding //utilizamos binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentStartBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        val viewFragment = bindingFragment.root //devolvemos el raiz, que sera la vista
        return viewFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val navHost = requireActivity() //referencia del activity
            .supportFragmentManager //administrador de Fragmentos
            .findFragmentById(R.id.fragment_container_view) //buscamos elContenedor de Fragmentos

        navHost.let {//Si entramos dentro, no es nulo.
            navController = navHost!!.findNavController() //buscamos su NavController
            bindingFragment.button1Inicio.setOnClickListener{
                navController.navigate(R.id.action_fragmentStart_to_fragmentA) //navegamos
            }
            bindingFragment.button2Inicio.setOnClickListener{
                //navController.navigate(R.id.action_fragmentStart_to_fragmentB) //navegamos
                navController.navigate(FragmentStartDirections.actionFragmentStartToFragmentB(name = "john"))
            }
        }
    }


}