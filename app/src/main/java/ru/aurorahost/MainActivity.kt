package ru.aurorahost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.aurorahost.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBottomNavClicks()
    }

    private fun onBottomNavClicks() {
        binding.nBar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()}
                R.id.tracks -> { Toast.makeText(this, "Tracks", Toast.LENGTH_SHORT).show()}
                R.id.settings -> {Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()}
            }
            true }
    }
}