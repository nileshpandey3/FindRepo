package com.example.nileshpandey.findrepo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
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
                    val adapter = RepoAdapter(this@search_result_activity,android.R.layout.simple_list_item_1, searchResult!!.items)
                    listView.adapter = adapter
                }
            }


        }
        var retriever = GithubRetreiver()
        retriever.searchRepos(callback,searchTerm)
    }
}

class RepoAdapter(context: Context?, resource: Int, objects: List<Repo>?) : ArrayAdapter<Repo>(context, resource, objects) {

    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val repoView = inflator.inflate(android.R.layout.simple_list_item_1, parent, false) as TextView

        val repo = getItem(position)

        repoView.text = repo.full_name

        return repoView

    }

}
