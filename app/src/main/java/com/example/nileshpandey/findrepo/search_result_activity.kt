package com.example.nileshpandey.findrepo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class search_result_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result_activity)

        val searchTerm = intent.getStringExtra("SearchTerm")
        println(message = searchTerm)
    }
}
