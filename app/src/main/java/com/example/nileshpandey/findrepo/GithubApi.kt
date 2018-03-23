package com.example.nileshpandey.findrepo

import android.app.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by nileshpandey on 3/19/18.
 */


interface GithubService{

    @GET("search/repositories?")
    fun searchRepos(@Query("q") searchTerm:String) : Call<GithubSearchResults>
}

class GithubSearchResults(val items: List<Repo>)
class Repo(val full_name:String,val owner: GithubUser , val html_url:String)
class  GithubUser(val avatar_url:String)

class GithubRetreiver{

    val service:GithubService

    init {
        val retroFit = Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create()).build()

        service = retroFit.create(GithubService::class.java)
    }

    fun searchRepos(callback: Callback<GithubSearchResults>, searchTerm: String){

        var searchT = searchTerm
        if (searchT==""){

            searchT = "Eggs"
        }
        val call = service.searchRepos(searchT)
        call.enqueue(callback)

    }
}