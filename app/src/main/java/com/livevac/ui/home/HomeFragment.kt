package com.livevac.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.livevac.R
import com.livevac.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vaccinateEventButton: Button = binding.btnVaccineEvent

        vaccinateEventButton.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToVaccinateEventFragment()
            findNavController().navigate(action)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeFrag", "onCreate(Bundle?) called")
        Toast.makeText(this@HomeFragment.requireActivity(), "Home", Toast.LENGTH_SHORT).show()
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val textView: TextView = binding.txtDisease

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
/*
package com.livevac.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.livevac.R
import com.livevac.databinding.FragmentHomeBinding
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //FragPass: CallBack on call method
    interface Callbacks {
        fun onVaccinateSelected()
    }
    //FragPass: Initialize callback var
    private var callbacks: Callbacks? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeFrag", "onCreate(Bundle?) called")
        Toast.makeText(this@HomeFragment.requireActivity(), "Home", Toast.LENGTH_SHORT).show()
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //FragPass: Event button binding
        val vaccinateEventButton: Button = binding.btnVaccineEvent

        val textView: TextView = binding.txtDisease

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        //FragPass: Event handler for button vaccinateEvent
        vaccinateEventButton.setOnClickListener { view: View ->
            callbacks?.onVaccinateSelected()

        }
        return root

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

*/