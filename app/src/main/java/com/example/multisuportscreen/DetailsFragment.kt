package com.example.multisuportscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.multisuportscreen.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    private var name: String? = ""
    private var des: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        name = arguments?.getString("Name")
        des = arguments?.getString("Description")


        val cName = binding.cname
        val cDes = binding.description


        cName.text = name
        cDes.text = des


        return binding.root
    }

    fun displayDetails(courseName: String, description: String) {

        val cName = binding.cname
        val cDes = binding.description


        cName.text = courseName
        cDes.text = description

    }


}