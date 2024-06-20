package com.example.vit.network

import retrofit2.http.GET
import retrofit2.http.Path

interface LoremPicsumApi {

    @GET("https://picsum.photos/v2/list?page=2&limit=40")
    suspend fun getPhotos(): List<Photo>
}