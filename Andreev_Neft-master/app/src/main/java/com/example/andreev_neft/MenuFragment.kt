package com.example.dimabakief_neft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.andreev_neft.R

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
        view.findViewById<TextView>(R.id.btMap).setOnClickListener{
            findNavController().navigate(R.id.nv_map, bundle)
        }
        view.findViewById<TextView>(R.id.btGuide).setOnClickListener{
            bundle.putBoolean("Chek", true)
            findNavController().navigate(R.id.nvGuide,bundle)
        }
        view.findViewById<TextView>(R.id.btTeatcher).setOnClickListener{
            bundle.putBoolean("Chek", false)
            findNavController().navigate(R.id.nvGuide,bundle)
        }
        view.findViewById<TextView>(R.id.btDirectio).setOnClickListener{
            findNavController().navigate(R.id.nvDirectioFragment)
        }
        view.findViewById<TextView>(R.id.btDeveloper).setOnClickListener{
            findNavController().navigate(R.id.nvDeveleper)
        }
    }
}