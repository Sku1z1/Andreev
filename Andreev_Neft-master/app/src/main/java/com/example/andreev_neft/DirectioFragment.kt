package com.example.dimabakief_neft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.andreev_neft.R

class DirectioFragment : Fragment() {
    private lateinit var adapterDeriction: AdapterDeriction

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_directio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeAdapter(view.findViewById(R.id.rvDirectio))
    }
    private fun initializeAdapter(recyclerView: RecyclerView) {
        val bundle = Bundle()
        val manager = Manager()
        val originalData = manager.getAllDirections()

        adapterDeriction = AdapterDeriction(originalData) { list ->
            navigateToDetails(list, bundle)
        }
        recyclerView.adapter = adapterDeriction

        view?.findViewById<EditText>(R.id.edPoiskDirectio)?.addTextChangedListener { editable ->
            val query = editable.toString()

            val filteredData = when {
                query.isBlank() -> originalData
                manager.findDirectionByName(query).isNotEmpty() -> manager.findDirectionByName(query)
                manager.findDirectionByCode(query).isNotEmpty() -> manager.findDirectionByCode(query)
                else -> emptyList()
            }

            recyclerView.adapter = AdapterDeriction(filteredData) { list ->
                navigateToDetails(list, bundle)
            }
        }
    }

    private fun navigateToDetails(list: Direction, bundle: Bundle) {
        bundle.putString("MyDirections", "${list.code}@${list.name}@${list.body}")
        findNavController().navigate(R.id.nvDirectionDetalisFragment, bundle)
    }

}