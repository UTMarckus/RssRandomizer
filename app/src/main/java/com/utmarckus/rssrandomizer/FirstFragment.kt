package com.utmarckus.rssrandomizer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.utmarckus.rssrandomizer.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var listener: GenerateButtonClickedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as GenerateButtonClickedListener
    }

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
            listener?.onGenerateButtonClicked(
                binding.minValue.text.toString().toIntOrNull() ?: 0,
                binding.maxValue.text.toString().toIntOrNull() ?: 0
            )
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    interface GenerateButtonClickedListener {
        fun onGenerateButtonClicked(min: Int, max: Int)
    }

    companion object {
        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"

        fun newInstance(prevRes: Int) = FirstFragment().apply {
            arguments = Bundle().apply {
                putInt(PREVIOUS_RESULT_KEY, prevRes)

            }
        }
    }
}
