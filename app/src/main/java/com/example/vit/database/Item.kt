package com.example.vit.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Primary key with autoincrement
    val name: String,
    val price: Double,
    val quantity: Int
)
