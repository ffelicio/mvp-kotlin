package com.example.mvp.main

import com.example.mvp.postDelayed

class FindItemsInteractor {
    fun findItems(callback: (List<String>) -> Unit) {
        postDelayed(2000) { callback(createArrayList()) }
    }

    private fun createArrayList(): List<String> = (1..20).map { "Item $it" }
}