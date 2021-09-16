package net.intervyaz.viewintro.fragments

import android.content.Context
import android.content.Context.MODE_PRIVATE
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
import net.intervyaz.viewintro.service.Music
import android.content.SharedPreferences
import android.widget.RadioButton

import android.content.Context.MODE_PRIVATE







class SettingsFragment : Fragment(R.layout.fragment_settings){
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
        binding.switchMusic.isChecked = false
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadMusicSettings()
        // Обработка нажатия включения музыки
        binding.switchMusic.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                save()
                context?.startService(Intent(context, Music::class.java))
                Toast.makeText(context, "Музыка включена", Toast.LENGTH_SHORT).show()
            }
            else {
                save()
                context?.stopService(Intent(context, Music::class.java))
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

    fun loadMusicSettings() {
        val sharedPref: SharedPreferences = (context?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: "empty") as SharedPreferences
        val savedStr = sharedPref.getBoolean("boolean_key", false)
        binding.switchMusic.isChecked = savedStr
    }

    private fun save() {
        val sharedPref: SharedPreferences = (context?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: "empty") as SharedPreferences
        val editor = sharedPref.edit()
        editor.apply() {
            putBoolean("boolean_key", binding.switchMusic.isChecked).apply()
        }
    }


}