package com.livevac.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.livevac.R
import java.util.*

class VaccinateEventFragment : Fragment() {

    companion object {
        fun newInstance(HFID: UUID) = VaccinateEventFragment()
    }

    private lateinit var viewModel: VaccinateEventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vaccinate_event_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VaccinateEventViewModel::class.java)
        // TODO: Use the ViewModel
    }

}