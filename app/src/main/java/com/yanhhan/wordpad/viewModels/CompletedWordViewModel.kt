package com.yanhhan.wordpad.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yanhhan.wordpad.Model.Word
import com.yanhhan.wordpad.repository.WordRepository

class CompletedWordViewModel(val repo: WordRepository): ViewModel() {
    val words: MutableLiveData<List<Word>> = MutableLiveData()


    init {
        getWords()
    }

    fun getWords() {
        val res = repo.getWords()
        words.value = res.filter { it.completed }
        Log.d("get words", words.value.toString() + "something")
    }

    class Provider(val repo: WordRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CompletedWordViewModel(repo) as T
        }
    }
}