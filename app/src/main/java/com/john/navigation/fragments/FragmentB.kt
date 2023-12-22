package com.john.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.john.navigation.R
import com.john.navigation.databinding.FragmentBBinding

class FragmentB : Fragment() {
    lateinit var navController: NavController //nuestro navController
    lateinit var bindingFragment: FragmentBBinding //utilizamos binding
    private val myArgument: FragmentBArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentBBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        val viewFragmentoB = bindingFragment.root
        return viewFragmentoB
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = myArgument.name
        Toast.makeText(requireActivity(), "mi nombre es $name",Toast.LENGTH_LONG).show()
        val navHost = requireActivity() //referencia del activity
            .supportFragmentManager //administrador de Fragmentos
            .findFragmentById(R.id.fragment_container_view) //buscamos elContenedor de Fragmentos

        navHost.let {//Si entramos dentro, no es nulo.
            navController = navHost!!.findNavController() //buscamos su NavController
            bindingFragment.button1B.setOnClickListener{
                navController.navigate(R.id.action_fragmentB_to_fragmentStart) //navegamos
            }

            bindingFragment.button2B.setOnClickListener {
                navController.navigate(R.id.action_fragmentB_to_fragmentC)
            }

        }
    }

}