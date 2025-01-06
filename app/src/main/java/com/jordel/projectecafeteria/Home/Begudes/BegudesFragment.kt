package com.jordel.projectecafeteria.Home.Begudes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jordel.projectecafeteria.R

/**
 * A simple [Fragment] subclass.
 * Use the [BegudesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BegudesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_begudes, container, false)
    }
}