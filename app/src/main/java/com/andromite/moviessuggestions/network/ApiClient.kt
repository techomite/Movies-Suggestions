package com.andromite.moviessuggestions.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://yts.mx/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var apiClient = retrofit.create(Apis::class.java)


}