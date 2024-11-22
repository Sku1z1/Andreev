package com.example.dimabakief_neft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.andreev_neft.R

class WorkersFragment : Fragment() {
    private val manager = Manager()
    private lateinit var view: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_workers, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeAdapter(view.findViewById(R.id.rvGuide))
        view.findViewById<ImageView>(R.id.imExet).setOnClickListener(){
            findNavController().navigate(R.id.nvExetWorkerFragment)
        }

    }
    private fun initializeAdapter(recyclerView: RecyclerView) {
        val bundle = Bundle()
        val isAdmin = arguments?.getBoolean("Chek") == true
        val title = if (isAdmin) "Администрация" else "Учителя"
        view.findViewById<TextView>(R.id.tvTitle).text = title

        val workers = if (isAdmin) manager.getAllWorkers() else manager.getAllTeacher()
        val adapter = AdapterWorkers(workers) { list -> navigateToDetails(bundle, list) }
        recyclerView.adapter = adapter

        val poisk = view.findViewById<EditText>(R.id.edPoisk)
        poisk.addTextChangedListener {
            val query = poisk.text.toString()
            val results = searchWorkers(query, isAdmin)
            recyclerView.adapter = AdapterWorkers(results) { list -> navigateToDetails(bundle, list) }
        }
    }

    private fun searchWorkers(query: String, isAdmin: Boolean): List<Workers> {
        return when {
            isAdmin -> {
                val resultsName = manager.findWorkersByName(query)
                val resultsPost = manager.findWorkersByPost(query)
                val resultsPosition = manager.findWorkersByPosition(query)
                resultsName.ifEmpty { resultsPost.ifEmpty { resultsPosition.ifEmpty { manager.getAllWorkers() } } }
            }
            else -> {
                val resultsName = manager.findTeacherByName(query)
                val resultsPost = manager.findTeacherByPost(query)
                val resultsPosition = manager.findTeacherByPosition(query)
                resultsName.ifEmpty { resultsPost.ifEmpty { resultsPosition.ifEmpty { manager.getAllTeacher() } } }
            }
        }
    }

    private fun navigateToDetails(bundle: Bundle, list: Workers) {
        val details = listOf(
            list.fullName, list.education, list.specialization, list.position,
            list.teachingSubjects, list.achievements, list.professionalDevelopment,
            list.yearsOfExperience, list.teachingExperience
        ).joinToString(separator = "@")
        bundle.putString("WorgersDetalis", details)
        findNavController().navigate(R.id.nvWorgersDetalis, bundle)
    }
}