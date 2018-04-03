package com.example.nileshpandey.findrepo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
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
