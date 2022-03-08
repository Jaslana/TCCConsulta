package com.example.myconsultamedica.ui.consultamedia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myconsultamedica.R

class ConsultaFragment : Fragment() {

    private lateinit var viewModel: ConsultaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.consulta_fragment, container, false)
    }
}