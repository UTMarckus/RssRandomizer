package com.utmarckus.rssrandomizer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utmarckus.rssrandomizer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FirstFragment.GenerateButtonClickedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFirstFragment(0)
    }

    private fun openFirstFragment(prevNum: Int) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fragment_container, FirstFragment.newInstance(prevNum))
        commit()
    }


    private fun openSecondFragment(min: Int, max: Int) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fragment_container, SecondFragment.newInstance(min, max))
        commit()
    }

    override fun onGenerateButtonClicked(min: Int, max: Int) {
        openSecondFragment(min, max)
    }
}
