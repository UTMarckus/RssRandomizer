package com.utmarckus.rssrandomizer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.utmarckus.rssrandomizer.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = arguments?.getInt(PREVIOUS_RESULT_KEY)
        binding.prevResult.text = "Previous result: ${result.toString()}"

        binding.generate.setOnClickListener {
            // TODO send min and max to Second Fragment
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"

        fun newInstance(prevRes: Int): FirstFragment {
            val args = Bundle().apply {
                putInt(PREVIOUS_RESULT_KEY, prevRes)
            }
            return FirstFragment().apply { arguments = args }
        }
    }
}
