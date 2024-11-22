package com.example.dimabakief_neft

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.andreev_neft.R

class workersDetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workers_details, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = arguments?.getString("WorgersDetalis")
        val worgs = text?.split("@")
        view.findViewById<TextView>(R.id.tvNameFullDetalis).text = worgs?.get(0)
        view.findViewById<TextView>(R.id.tvEducationDetalis).text = "Образование: " + worgs?.get(1)
        view.findViewById<TextView>(R.id.tvSpecializationDetalis).text = "Специализация по диплому: " + worgs?.get(2)
        view.findViewById<TextView>(R.id.tvPositionDetalis).text = "Должность: " + worgs?.get(3)
        view.findViewById<TextView>(R.id.tvTeachingSubjectsDetalis).text = "Предметы, которые ведет: " + worgs?.get(4)
        view.findViewById<TextView>(R.id.tvAchievementsDetalis).text = "Достижения, награды и звания: " + worgs?.get(5)
        view.findViewById<TextView>(R.id.tvProfessionalDevelopmentDetalis).text = "Курсы повышения квалификации: " + worgs?.get(6)
        view.findViewById<TextView>(R.id.tvTeachingExperienceDetalis).text = "Общий стаж работы в годах: " + worgs?.get(7)
        view.findViewById<TextView>(R.id.tvYearsOfExperienceDetalis).text = "Стаж работы преподавателем в годах: " + worgs?.get(8)
    }
}