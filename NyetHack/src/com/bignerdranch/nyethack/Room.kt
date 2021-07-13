package com.bignerdranch.nyethack

open class Room(val name:String){  //open은 서브클래스를 가질수 있도록 해줌
    protected open val dangerLevel = 5
    var monster : Monster?=Goblin()
    fun description()="Room:$name\r\n"+"Creature: ${monster?.description ?: "none."} " //description = 어떤 공간인지를 나타내는 문자열을 반환

    open fun load()="아무도 여기 오지 않았읍니다..." // 플레이어가 해당 공간에 들어가는 것을 알려주는 문자열을 반환
}
open class TownSquare : Room("Town Square"){
    override val dangerLevel = super.dangerLevel-3
    private var bellSound="댕댕"

    final override fun load()="당신의 참여를 주민들이 다 함께 환영합니다\r\n${ringBell()}"
    //final 키워드가 지정되었으므로 어떤 서브클래스에서도 load 함수를 오버라이딩 할 수 없음.

    private fun ringBell()="당신의 도착을 종탑에서 알립니다. $bellSound"
}