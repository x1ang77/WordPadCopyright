package com.yanhhan.wordpad.repository

import android.util.Log
import com.yanhhan.wordpad.Model.Word

class WordRepository {
    private var counter = 2L
    private val wordsMap: MutableMap<Long, Word> = mutableMapOf(
        0L to Word(
            0L,
            "Metanoia",
            "The journey of changing one's word, heart or a way ot life.",
            "something",
            "something",
            false
        ), 1L to Word(
            1L,
            "Metanoia",
            "The journey of changing one's word, heart or a way ot life.",
            "something",
            "something",
            true
        )
    )

    fun getWords(): List<Word> {
        return wordsMap.values.toList()
    }

    fun addWord(word: Word): Word? {
        wordsMap[++counter] = word.copy(id = counter)
        return wordsMap[counter]
    }

    fun getWordById(id: Long): Word? {
        return wordsMap[id]
    }

    fun updateWord(id: Long, note: Word): Word? {
        wordsMap[id] = note
        return wordsMap[id]
    }

    fun deleteWord(id: Long) {
        wordsMap.remove(id)
    }
    fun completedWord(id:Long):Word?{

            wordsMap[id]?.completed=true
        Log.d("halp",wordsMap[id].toString())
        return wordsMap[id]
    }

    companion object {
        var wordRepository: WordRepository? = null

        fun getInstance(): WordRepository {
            if (wordRepository == null) {
                wordRepository = WordRepository()
            }

            return wordRepository!!
        }
    }
}