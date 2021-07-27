package com.livevac.ui.vaccines

import android.os.Bundle
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
import com.livevac.databinding.FragmentVaccinesBinding
import com.livevac.ui.herd.HerdFragmentDirections

class VaccinesFragment : Fragment() {

    private lateinit var vaccinesViewModel: VaccinesViewModel
    private var _binding: FragmentVaccinesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addVaccines: Button = binding.btnAddVaccine

        addVaccines.setOnClickListener {
            val action = VaccinesFragmentDirections.actionNavigationNotificationsToAddVaccineFragment()
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(this@VaccinesFragment.requireActivity(), "vac", Toast.LENGTH_SHORT).show()

        vaccinesViewModel =
            ViewModelProvider(this).get(VaccinesViewModel::class.java)

        _binding = FragmentVaccinesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        vaccinesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}