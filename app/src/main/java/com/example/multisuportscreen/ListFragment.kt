package com.example.multisuportscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multisuportscreen.databinding.FragmentListBinding


class ListFragment : Fragment(),CustomListAdapter.OnItemClick {
    lateinit var binding: FragmentListBinding
    private lateinit var comm: CustomListAdapter.OnItemClick

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        val customListAdapter = CustomListAdapter(this)
        comm = requireActivity() as CustomListAdapter.OnItemClick
        customListAdapter.submitList(data)
        binding.recyclerView.apply {
            LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            setHasFixedSize(true)
            adapter = customListAdapter
        }


//        binding.textView.setOnClickListener {
//            findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
//        }
        return binding.root
    }

    override fun onItemClick(item: DataModel) {
        comm.onItemClick(item)
     //   findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
    }


}