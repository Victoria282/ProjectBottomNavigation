package net.intervyaz.viewintro.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.intervyaz.viewintro.R
import net.intervyaz.viewintro.adapter.TicketsAdapter
import net.intervyaz.viewintro.databinding.FragmentHomeBinding
import net.intervyaz.viewintro.fakeTickets

class HomeFragment : Fragment(R.layout.fragment_home), TicketsAdapter.TicketClickListener {

    private lateinit var binding: FragmentHomeBinding

    override fun onTicketClick(id: Int) {
        val action = HomeFragmentDirections.toDetails(id)
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TicketsAdapter(fakeTickets)
        adapter.clickListener = this
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(
            requireContext(), RecyclerView.VERTICAL, false)

        binding.btnMap.setOnClickListener {
            val action = HomeFragmentDirections.toDetails(2)
            findNavController().navigate(action)
        }

    }
}