package com.example.travelapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.travelapp.databinding.FragmentTeamDetailBinding


class DashboardFragmentDetail : Fragment(){
    private var _binding: FragmentTeamDetailBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("Name")
        val description = arguments?.getString("City")
        val division = arguments?.getString("Division")
        val abbreviation = arguments?.getString("Abbreviation")

        activity?.title = title
        binding.title.text = title
        binding.description.text = description
        binding.devision.text = division
        binding.abbreviation.text = abbreviation
    }
}