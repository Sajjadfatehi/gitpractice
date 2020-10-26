package com.example.paygahdadeh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainCoroutine"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db = AppDataBase.invoke(this)
//        lifecycleScope.launch(Dispatchers.IO) {
//            db.userDao().insertUser(listOf(UserEntity("sajjad", "f", false, "reg")))
//        }


//        lifecycleScope.launch {
//            Log.d(TAG, "onCreate3: ")
//            val s1=tabe1()
//            Log.d(TAG, "onCreate: ")
//            val s2=tabe2()
//
//            Log.d(TAG, "${s1}")
//            Log.d(TAG, "${s2}")
//
//        }

        runBlocking {
            Log.d(TAG, "onCreate1: ")
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG, "bb1: ")
            }
            launch(Dispatchers.Default) {
                delay(3000L)
                Log.d(TAG, "bb2: ")
            }

        }
        Log.d(TAG, "onCreate2: ")
    }

    suspend fun tabe1(): String {
        delay(3000L)
        return "mamad1"
    }

    suspend fun tabe2(): String {
        delay(3000L)
        return "mamad2"
    }


}