package com.example.week_6_assignment_1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week_6_assignment_1.R
import com.example.week_6_assignment_1.adapter.UserAdapter
import com.example.week_6_assignment_1.model.UserData
import com.example.week_6_assignment_1.model.UserList

class HomeFragment : Fragment(), View.OnClickListener {
   private lateinit var recyclerview : RecyclerView
    private lateinit var btnref : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerview = view.findViewById(R.id.recyclerview)
        btnref = view.findViewById(R.id.btnref)

        btnref.setOnClickListener(this)

        val adapter = UserAdapter(UserList.fetchUser(), context!!)
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adapter

        return view
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnref->{
                recyclerview.adapter?.notifyDataSetChanged()
            }
        }
    }


}