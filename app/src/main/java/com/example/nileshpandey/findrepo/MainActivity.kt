package com.example.nileshpandey.findrepo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.nileshpandey.findrepo.R.id.SearchButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEditText = findViewById<EditText>(R.id.SearchEditText)

        val button = findViewById<Button>(R.id.SearchButton)
        button.setOnClickListener {

            val intent = Intent(this, search_result_activity::class.java)
            intent.putExtra("SearchTerm", searchEditText.text.toString())
            startActivity(intent)
        }
    }
}
