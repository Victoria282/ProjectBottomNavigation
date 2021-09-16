package net.intervyaz.viewintro.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import net.intervyaz.viewintro.R
import net.intervyaz.viewintro.databinding.DetailsFragmentBinding

class DetailsFragment() : Fragment(R.layout.details_fragment) {
	private lateinit var binding: DetailsFragmentBinding

	private val args: DetailsFragmentArgs by navArgs()

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = DetailsFragmentBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.text.text = "id билета - " + args.ticketId.toString()
	}
}