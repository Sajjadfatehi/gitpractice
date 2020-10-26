package com.example.paygahdadeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment:Fragment(R.layout.start_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.start_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            val text=edt.text.toString().toInt()

            customView.setFill(text.toFloat())

        }

        button2.setOnClickListener {

            findNavController().navigate(StartFragmentDirections.actionStartFragmentToSecondFragment())
        }

    }
}