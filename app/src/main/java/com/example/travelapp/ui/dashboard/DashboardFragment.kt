package com.example.travelapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.csi.bottomnavigationactivity.utils.TeamRVAdapter
import com.example.travelapp.R
import com.example.travelapp.databinding.FragmentDashboardBinding
import com.example.travelapp.network.IMDBResult



class DashboardFragment : Fragment() {
    private val dashboardViewModel by viewModel<DashboardViewModel>()


    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // on below line we are initializing our adapter class.
        val travelsAdapter = TeamRVAdapter{
            openTeamDetailFragment(it)
        }
        // on below line we are setting
        // adapter to our recycler view.
        binding.notesRV.adapter = travelsAdapter
        dashboardViewModel.travelResult.observe(viewLifecycleOwner) { list ->
            list?.let {
                // on below line we are updating our list.
                travelsAdapter.updateList(it.IMDResult)
            }
        }

        binding.travelButton.setOnClickListener {
            dashboardViewModel.getMovies(binding.travelPrompt.text.toString())
        }
    }

    private fun openTeamDetailFragment(team: IMDBResult) {
        val bundle = bundleOf()
        bundle.putString("Title", team.name)
        bundle.putString("Description", team.city)
        findNavController().navigate(R.id.navigation_dashboard, bundle)
    }
}