package com.example.lab12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lab12.chessItems.Board
import com.example.lab12.chessItems.Color
import com.example.lab12.chessItems.Coordinates
import com.example.lab12.chessItems.Player
import com.example.lab12.chessItems.chessFigures.Pawn

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val player:Player = Player("Jojo")
        player.amountOfLose = 0
        player.amountOfVictory = 1000

        println(player)

        val pawn = Pawn(Color.BLACK)
        Log.i("pawn",pawn.coordinate.toString())

        val pawn2 = Pawn(Color.WHITE)
        val whitePawn = Pawn(Color.WHITE)
        val blackPawn = Pawn(Color.BLACK)


      /*  pawn.coordinate = Coordinates.B6
        pawn.coordinate = Coordinates.F1

        Log.i("Pawn history:",pawn.history.toString())*/

        Log.i("Pawn1 state:",pawn.state.getState())
        Log.i("Pawn2 state:",pawn2.state.getState())
        Log.i("WhitePawn state:",whitePawn.state.getState())
        Log.i("BlackPawn2 state:",blackPawn.state.getState())

        println("Adding to the board")

        Board.addFigureToTheBoard(pawn)
        Board.addFigureToTheBoard(pawn2)
        Board.addFigureToTheBoard(whitePawn)
        Board.addFigureToTheBoard(blackPawn)

        pawn.coordinate = Coordinates.H6
        pawn2.coordinate = Coordinates.G5
        whitePawn.coordinate = Coordinates.H5
        blackPawn.coordinate = Coordinates.C4

        Log.i("BPawn state:",pawn.state.getState())
        Log.i("WPawn2 state:",pawn2.state.getState())
        Log.i("whitePawn state:",whitePawn.state.getState())
        Log.i("blackPawn state:",blackPawn.state.getState())


        println("MOVE!!!!")
        pawn2.changeCoordinate(Coordinates.H6)

        println(pawn.history)
        println(pawn2.history)

        pawn2.changeCoordinate(Coordinates.H5)

        println(pawn2.history)

        blackPawn.changeCoordinate(Coordinates.C3)

        println(blackPawn.history)
        //pawn.changeCoordinate(Coordinates.H5)

        val a = A()
        val b = A()
        a.display()

        a.setUp()
        b.setUp()
        a.plus(b)
        Log.i("lala",a.display().toString())


        println("+:" + converter("+")?.invoke(2.4,7.6))
        println("-:" + converter("-")?.invoke(2.4,7.6))
        println("*:" + converter("*")?.invoke(2.4,7.6))
        println("/:" + converter("/")?.invoke(2.4,7.6))

    }


    class A{
        private lateinit var prop: String

        operator fun plus(ob:A) { prop += ob.prop }

        override operator fun equals(other: Any?): Boolean {
            return other is A && other.prop == this.prop
        }

        fun setUp() {
            prop = "100 + 200"
        }

        fun display(){
                if(::prop.isInitialized)
                println(prop)
        }
    }


    fun converter (which: String):((Double, Double) -> Double )?{
        return when(which){
            "+" -> {x,y -> x+y}
            "-" -> {x,y -> x-y}
            "*" -> {x,y -> x*y}
            "/" -> {x,y -> x/y}
            else -> null
        }
    }

}