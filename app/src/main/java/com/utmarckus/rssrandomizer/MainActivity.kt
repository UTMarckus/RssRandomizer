package com.utmarckus.rssrandomizer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utmarckus.rssrandomizer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        openFirstFragment(0)
    }

    private fun openFirstFragment(prevNum: Int) {
        val firstFragment = FirstFragment.newInstance(prevNum)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, firstFragment)
        transaction.commit()
    }
}
