package com.example.vit

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var count = 0

    fun incrementCount() {
        count++
    }
}
