package com.example.lab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lab12.chessItems.Color
import com.example.lab12.chessItems.Coordinates
import com.example.lab12.chessItems.chessFigures.Pawn

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pawn = Pawn(Color.BLACK,Coordinates.A3)
        Log.i("pawn",pawn.coordinate.toString())
    }

}