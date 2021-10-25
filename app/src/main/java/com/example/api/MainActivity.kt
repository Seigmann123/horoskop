package com.example.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinner: Spinner = findViewById(R.id.spinner)
        val signs = resources.getStringArray(R.array.sign)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            signs
        )
        spinner.adapter = adapter


        val date: Spinner = findViewById(R.id.date)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.date,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            date.adapter = adapter
        }



        val start: Button = findViewById(R.id.startactivity)

        start.setOnClickListener {
            val sign: String = spinner.getSelectedItem().toString()
            val date: String = date.getSelectedItem().toString()

            val intent = Intent(this, signActivity::class.java)
            intent.putExtra("url", createURL(sign, date))
            startActivity(intent)


        }



        }


    }

    private fun createURL(sign: String, date: String): String {
        val url = "https://aztro.sameerkumar.website/?sign=$sign&day=$date"

        return url
}





