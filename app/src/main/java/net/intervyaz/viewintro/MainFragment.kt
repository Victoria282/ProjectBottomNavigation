package net.intervyaz.viewintro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import net.intervyaz.viewintro.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment) {

	private lateinit var binding: MainFragmentBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = MainFragmentBinding.inflate(inflater, container, false)
		return binding.root
	}
}