package com.utmarckus.rssrandomizer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.utmarckus.rssrandomizer.databinding.FragmentFirstBinding
import com.utmarckus.rssrandomizer.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val randomResult = arguments?.let {
            (it.getInt(MIN_VALUE_KEY)..it.getInt(MAX_VALUE_KEY)).random().toString()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        private const val MIN_VALUE_KEY = "MIN_VALUE"
        private const val MAX_VALUE_KEY = "MAX_VALUE"

        fun newInstance(min: Int, max: Int) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putInt(MIN_VALUE_KEY, min)
                    putInt(MAX_VALUE_KEY, max)
                }
            }
    }
}