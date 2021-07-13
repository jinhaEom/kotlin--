package com.bignerdranch.nyethack
import java.util.*

interface Fightable{ //인터페이스 정의
    var healthPoints : Int
    val diceCount : Int   //전투에 사용하는 주사위의 개수
    val diceSides : Int  //주사위 면의 수
    val damageRoll : Int //주사위를 굴려서 나온 수의 합계(적에게 입힐 손상의 양을 결정.)
        get()=(0 until diceCount).map{
            Random().nextInt(diceSides)+1
        }.sum()

    fun attack(opponent: Fightable): Int
}
abstract class Monster(val name:String, val description: String, override var healthPoints:Int): Fightable{
    override fun attack(opponent:Fightable):Int{
        val damageDealt = damageRoll
        opponent.healthPoints-=damageDealt
        return damageDealt
    }
}
class Goblin(name:String="Goblin",
            description:String = "추하게 생긴 고블린",
            healthPoints:Int=30): Monster(name,description,healthPoints){

override val diceCount=2
override val diceSides=8
            }