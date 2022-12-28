package com.yanhhan.wordpad

import android.app.Application
import com.yanhhan.wordpad.repository.WordRepository

class MyApplication : Application() {
    val wordRepo = WordRepository.getInstance()
}