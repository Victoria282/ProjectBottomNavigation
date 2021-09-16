package net.intervyaz.viewintro.fragments

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import net.intervyaz.viewintro.R
import net.intervyaz.viewintro.databinding.FragmentSettingsBinding
import android.widget.Toast
import android.widget.CompoundButton
import net.intervyaz.viewintro.MainActivity
import net.intervyaz.viewintro.Music

class SettingsFragment : Fragment(R.layout.fragment_settings){
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Обработка нажатия включения музыки
        binding.switchMusic.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                //context?.startService(Intent(context, Music::class.java))
                Toast.makeText(context, "Музыка включена", Toast.LENGTH_SHORT).show()
            }
            else {
                //context?.stopService(Intent(context, Music::class.java))
                Toast.makeText(context, "Музыка выключена", Toast.LENGTH_SHORT).show()
            }
        });
        // Обработка нажатия изменения текста
        binding.switchText.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "Стандартный шрифт изменён", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(context, "Стандартный шрифт", Toast.LENGTH_SHORT).show()
            }
        });

        // Обработка включения темы
        binding.switchBackground.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "Включена тёмная тема", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(context, "Светлая тема", Toast.LENGTH_SHORT).show()
            }
        });
    }
}