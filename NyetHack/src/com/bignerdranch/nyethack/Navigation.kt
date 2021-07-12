package com.bignerdranch.nyethack

enum class Direction(private val coordinate : Coordinate){
    NORTH(Coordinate(0,-1)),
    EAST(Coordinate(1,0)),
    SOUTH(Coordinate(0,1)),
    WEST(Coordinate(-1,0));//enum 클래스에 함수를 정희할땐 세미콜론을 붙여야함.(항목과 함수를 구분해야하기 때문)

    fun updateCoordinate(playerCoordinate : Coordinate)=
        coordinate+playerCoordinate
}
data class Coordinate(val x: Int, val y:Int){
    val isInBounds = x>0 && y>=0

    operator fun plus(other: Coordinate) = Coordinate(x+other.x,y+other.y)
}