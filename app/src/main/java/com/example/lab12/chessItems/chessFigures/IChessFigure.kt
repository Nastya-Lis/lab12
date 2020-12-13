package com.example.lab12.chessItems.chessFigures

import com.example.lab12.chessItems.Color
import com.example.lab12.chessItems.Coordinates


interface IChessFigure {

    var coordinate:Coordinates?
    val color:Color
    val nameFigure:String
    var history: ArrayList<Coordinates?>
    var state:State

    fun changeCoordinate(coordinate:Coordinates)

    //функция по умолчанию
    //!!!!!!!!!!!!!!!!!!!!!!!!!

    class State{
        var isOnField = false
        var isAbleToMove = false

        fun getState():String{
            return "isOnField:$isOnField, isAbleToMove:$isAbleToMove "
        }
    }
}