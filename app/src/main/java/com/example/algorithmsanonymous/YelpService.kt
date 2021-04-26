package com.example.algorithmsanonymous

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


public interface YelpService {

    @GET("businesses/search")
    fun search (

            @Header("Authorization") authHeader: String,
            @Query("term") term: String,
            @Query("limit") limit: Int,
            @Query("price") price: String,
            @Query("location") location: String) : Call<YelpSearchResult>

    @GET("businesses/search")
    fun search2 (

        @Header("Authorization") authHeader: String,
        @Query("term") term: String,
        @Query("limit") limit: Int,
        @Query("location") location: String) : Call<YelpSearchResult>


}