package ru.aurorahost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.aurorahost.databinding.ActivityMainBinding
import ru.aurorahost.fragments.MainFragment
import ru.aurorahost.fragments.SettingsFragment
import ru.aurorahost.fragments.TracksFragment
import ru.aurorahost.utils.openFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBottomNavClicks()
        openFragment(MainFragment.newInstance())
    }

    private fun onBottomNavClicks() {
        binding.nBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> openFragment(MainFragment.newInstance())
                R.id.tracks -> openFragment(TracksFragment.newInstance())
                R.id.settings -> openFragment(SettingsFragment.newInstance())
            }
            true
        }
    }
}