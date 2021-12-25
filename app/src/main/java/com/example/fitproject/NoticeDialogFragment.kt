package com.example.fitproject


import android.os.Bundle

import android.view.View

import android.widget.Toast

import androidx.core.os.bundleOf

import androidx.fragment.app.Fragment

class NoticeDialogFragment : Fragment(R.layout.dialog_signin) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpResultDoneButtonClickListener()
    }

    private fun setUpResultDoneButtonClickListener() {
        resultDoneButton.setOnClickListener {
            try {
                val number = resultNumberEditText.text.toString().toInt()
                setResult(number)
                parentFragmentManager.popBackStack()
            } catch (exception: NumberFormatException) {
                Toast.makeText(
                    requireContext(),
                    R.string.invalid_number_error,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    private fun setResult(number: Int) {
        parentFragmentManager.setFragmentResult(
            ResultListenerFragment.REQUEST_KEY,
            bundleOf(ResultListenerFragment.KEY_NUMBER to number)
        )
    }

    private fun setResultWithFMExtension(number: Int) {
        setFragmentResult(
            ResultListenerFragment.REQUEST_KEY,
            bundleOf(ResultListenerFragment.KEY_NUMBER to number)
        )
    }
}