package com.example.nileshpandey.findrepo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Response


class search_result_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result_activity)

        val searchTerm = intent.getStringExtra("SearchTerm")

        val callback = object : retrofit2.Callback<GithubSearchResults>{
            override fun onFailure(call: Call<GithubSearchResults>?, t: Throwable?) {
               println("Not working")
            }

            override fun onResponse(call: Call<GithubSearchResults>?, response: Response<GithubSearchResults>?) {
                val searchResult = response?.body()

                if (searchResult!= null){

                    for (Repo in searchResult!!.items){

                        println(Repo.full_name)
                    }

                    val listView = findViewById<ListView>(R.id.repoListView)
                    val adapter = ArrayAdapter(this@search_result_activity,android.R.layout.simple_list_item_1, searchResult!!.items)
                    listView.adapter = adapter
                }
            }


        }
        var retriever = GithubRetreiver()
        retriever.searchRepos(callback,searchTerm)
    }
}
