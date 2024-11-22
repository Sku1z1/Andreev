package com.example.dimabakief_neft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.andreev_neft.R

class directioDetaliskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_directio_detalisk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString("MyDirections")
        val worgs = text?.split("@")
        view.findViewById<TextView>(R.id.tvNumDirectioDetalisk).text = worgs?.get(0)
        view.findViewById<TextView>(R.id.tvTatleDirectio).text =  worgs?.get(1)
        view.findViewById<TextView>(R.id.tvBodyDirection).text =  worgs?.get(2)
    }
}