@file:JvmName("Hero")  //컴파일되는 클래스 이름 바꾸기 HeroKt->Hero

import java.io.IOException

fun main() {
    val adversary=Jhava()
    println(adversary.utterGreeting())

    val friendshipLevel = adversary.determineFriendshipLevel()
    println(friendshipLevel?.toLowerCase() ?: "무슨 의미인지 난해하군요..")

    //Hero.kt 에서 hitPoints 를 참조하는 코드
    val adversaryHitPoints : Int = adversary.hitPoints
    println(adversaryHitPoints.dec())
    println(adversaryHitPoints.javaClass)

    adversary.greeting="주인님, 안녕하세요!!"
    println(adversary.utterGreeting())

    adversary.offerFood()
    try {
        adversary.extendHandInFriendship()
    }catch (e:Exception){
        println("잘가라, 못된 괴물아")
    }
}
val translator  = { utterance : String ->
    println(utterance.toLowerCase().capitalize())
}
fun makeProclamation() = "안녕, 괴물아"

@JvmOverloads
fun handOverFood(leftHand: String = "딸기", rightHand:String = "고기"){
    println("맛있는 $leftHand 와 $rightHand 를  넘겨주었읍니다.")
}
@Throws(IOException::class)
fun acceptApology(){
    throw IOException()
}
class Spellbook{
    @JvmField
    val spells = listOf("Magic Ms.L", "Lay on Hans")

    companion object{
        @JvmField
        val MAX_SPELL_COUNT = 10

        @JvmStatic
        fun getSpellbookGreeting() =println("나는 위대한 그리모어다.")
    }
}