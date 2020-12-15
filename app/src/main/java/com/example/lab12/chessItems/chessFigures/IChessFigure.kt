package com.example.lab12.chessItems.chessFigures

import com.example.lab12.chessItems.Board
import com.example.lab12.chessItems.Color
import com.example.lab12.chessItems.Coordinates


interface IChessFigure {

    var coordinate:Coordinates?
    val color:Color
    val nameFigure:String
    var history: ArrayList<Coordinates?>
    var state:State

    fun changeCoordinate(newCoordinate:Coordinates)

    fun emptySpace(coordinate: Coordinates): Boolean = Board.chess.firstOrNull{it.coordinate == coordinate} == null

    class State{
        var isOnField = false
        var isAbleToMove = false

        fun getState():String = "isOnField:$isOnField, isAbleToMove:$isAbleToMove "
    }
}