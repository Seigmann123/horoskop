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

        //Spinner for signs
        val signSpinner: Spinner = findViewById(R.id.signspinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.sign,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            signSpinner.adapter = adapter
        }

        //Spinner for dates
        val daySpinner: Spinner = findViewById(R.id.date)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.date,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            daySpinner.adapter = adapter
        }

        //Knapp for å starte neste activity
        val start : Button = findViewById(R.id.startactivity)

        //onClick event for å få de vaglte tingene fra spinnerne og start ny activity
        start.setOnClickListener {
            val selectedSign : String = signSpinner.selectedItem.toString()
            val selectedDay : String = daySpinner.selectedItem.toString()
            val url : String = createURL(selectedSign, selectedDay)

            val intent = Intent(this@MainActivity,signActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        }

    }

    //Lage URL
    private fun createURL(sign : String, date : String) : String {
        return "https://aztro.sameerkumar.website/?sign=$sign&day=$date"
    }
}





