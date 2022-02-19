/*
 * *
 *  * Created by Abhinav Maurya on 20/02/22, 12:24 AM for ETAOP Pvt Ltd
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 20/02/22, 12:24 AM
 *
 */

package com.site_valley.dropdownspinnerexamplekotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.site_valley.dropdownspinnerexamplekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setSimpleSpinner()
    }


    private fun setSimpleSpinner() {

        binding.simpleSpinner.adapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            getStringList()
        )


        binding.simpleSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(adapterView: AdapterView<*>?, p1: View?, i: Int, p3: Long) {
                Toast.makeText(this@MainActivity, "Clicked On Position:- $i", Toast.LENGTH_SHORT)
                    .show()
                val item = adapterView?.adapter?.getItem(i)  // Getting item from adapter
                binding.tvSimpleSpinner.text = item.toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // TODO("Not yet implemented")
            }

        }

    }

    private fun getStringList(): ArrayList<String> {
        return arrayListOf(
            "Select Item...",
            "Abhinav",
            "Site Valley",
            "Android",
            "Google",
            "Kotlin",
            "Spinner"
        )
    }
}