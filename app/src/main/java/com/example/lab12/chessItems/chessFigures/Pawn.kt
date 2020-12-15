package com.example.lab12.chessItems.chessFigures

import com.example.lab12.chessItems.Board
import com.example.lab12.chessItems.ChessException
import com.example.lab12.chessItems.Color
import com.example.lab12.chessItems.Coordinates
import com.example.lab12.chessItems.chessFigures.IChessFigure.State
import kotlin.math.abs

class Pawn(override val color: Color,coordinate: Coordinates?) : IChessFigure{

    override var coordinate: Coordinates? = null
        set(value) {
            field = value
            history.add(value)
            if(value!=null)
            {
                state.isOnField = true
                state.isAbleToMove = true
            }
        }

    override val nameFigure: String = "Pawn"
    override var history: ArrayList<Coordinates?> = ArrayList()

    override var state: State = State()

    constructor(color: Color) : this(color,null)

    constructor(color: Color, state: State):this(color){
        this.state = state
    }

    init {
        this.coordinate = coordinate
    }


    override fun changeCoordinate(newCoordinate: Coordinates) {

        try {
            if (coordinate != null) {
                if (state.isOnField) {
                    var step = 0
                    step = if (color == Color.WHITE) 1 else -1
                    if (state.isAbleToMove) {

                            if (newCoordinate.y == coordinate!!.y + step) {

                                if (newCoordinate.x == coordinate!!.x) {
                                    if(emptySpace(newCoordinate))
                                    coordinate = newCoordinate
                                    else {
                                        throw ChessException("Unable to move ${this.coordinate}" +
                                                " to such position ${newCoordinate.name}")
                                    }
                                }
                                else if (abs(newCoordinate.x - coordinate!!.x) == 1) {
                                    var pawn = Board.getFigureAtPositionBoard(newCoordinate)
                                    if (pawn != null && pawn.color != color) {
                                        Board.removeFigureFromBoard(newCoordinate)
                                        coordinate = newCoordinate
                                    } else {
                                        throw ChessException("Unable to move ${this.coordinate}" +
                                                " to such position ${newCoordinate.name}")
                                    }
                                }
                                else {
                                    throw ChessException("Unable to move ${this.coordinate}" +
                                            " to such position ${newCoordinate.name}")
                                }
                            }
                            else {
                                throw ChessException("Unable to move ${this.coordinate}" +
                                        " to such position ${newCoordinate.name}")
                            }
                    }
                }
                else {
                    throw ChessException("Unable to move ${this.coordinate}" +
                            " to such position ${newCoordinate.name}")
                }
            }
        }
        catch (e:ChessException){
            println(e.message)
        }
    }
}
