package com.livevac.ui.herd

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
import com.livevac.databinding.FragmentHerdBinding
import com.livevac.ui.home.HomeFragment
import java.util.*
class HerdFragment : Fragment() {

    private lateinit var herdViewModel: HerdViewModel
    private var _binding: FragmentHerdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addHerdButton: Button = binding.btnAddHerd
        val addLivestockFragment: Button = binding.btnAddLivestock
        addHerdButton.setOnClickListener {
            val action = HerdFragmentDirections.actionNavigationDashboardToAddHerdFragment()
            findNavController().navigate(action)
        }
        addLivestockFragment.setOnClickListener {
            val action = HerdFragmentDirections.actionNavigationDashboardToAddLivestockFragment()
            findNavController().navigate(action)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        herdViewModel =
            ViewModelProvider(this).get(HerdViewModel::class.java)

        _binding = FragmentHerdBinding.inflate(inflater, container, false)
        val root: View = binding.root



        val button: Button = binding.toggleButton1
        herdViewModel.text.observe(viewLifecycleOwner, Observer {
            button.text = it
        })
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/*package com.livevac.ui.herd

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
import com.livevac.databinding.FragmentHerdBinding
import com.livevac.ui.home.HomeFragment
import java.util.*
class HerdFragment : Fragment() {

    private lateinit var herdViewModel: HerdViewModel
    private var _binding: FragmentHerdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //FragPass: CallBack on call method
    interface Callbacks {
        fun onAddHerdSelected()
    }
    //FragPass: Initialize callback var
    private var callbacks: Callbacks? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("Herd", "onCreate(Bundle?) called")
        Toast.makeText(this@HerdFragment.requireActivity(), "Herd`", Toast.LENGTH_SHORT).show()

        herdViewModel =
            ViewModelProvider(this).get(HerdViewModel::class.java)

        _binding = FragmentHerdBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //FragPass: Event button binding
        val addHerdButton: Button = binding.btnAddHerd

        val button: Button = binding.toggleButton1
        herdViewModel.text.observe(viewLifecycleOwner, Observer {
            button.text = it
        })
        //FragPass: Event handler for button vaccinateEvent
        addHerdButton.setOnClickListener { view: View ->
            callbacks?.onAddHerdSelected()

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