package com.example.vit.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.squareup.moshi.Json



data class MarsPhoto(
    val id: String,
    @Json(name = "img_src")
    val imgSrc: String

)