package com.yanhhan.wordpad.Model

data class Word(
    val id: Long? = null,
    val title: String,
    val meaning: String,
    val synonym: String,
    val details: String,
    var completed: Boolean = false
)