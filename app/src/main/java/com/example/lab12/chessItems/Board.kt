package com.example.lab12.chessItems

import android.util.Log
import com.example.lab12.chessItems.chessFigures.IChessFigure
import java.lang.Exception

object Board {

 var chess:ArrayList<IChessFigure> = ArrayList()

 fun getFigureAtPositionBoard(coordinate: Coordinates?):IChessFigure? =
           chess.firstOrNull {it.coordinate != null && it.coordinate == coordinate }

 fun addFigureToTheBoard(figure:IChessFigure){
  if(getFigureAtPositionBoard(figure.coordinate) == null)
         chess.add(figure)
  else
        throw Exception("This place is holded by another figure")
 }

 fun removeFigureFromBoard(coordinate: Coordinates?){
  val figure = getFigureAtPositionBoard(coordinate)
  figure?.remove()
  chess.remove(figure)
  figure?.let { println("Removing from board figure from position $coordinate") }
 }

private fun IChessFigure.remove(){
 this.coordinate = null
}

}