package com.example.lab12.chessItems.chessFigures

import android.widget.Space
import com.example.lab12.chessItems.Color
import com.example.lab12.chessItems.Coordinates
import com.example.lab12.chessItems.chessFigures.IChessFigure.State

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

    override fun changeCoordinate(coordinate: Coordinates) {
        TODO("Not yet implemented")
    }
}