/*
플레이어 캐릭터 생성 -> player 클래스의 생성자를 호출하여 인스턴스를 생성.
 */
class Player{
    var name = "madrigal"
        get()=field.capitalize()
    private set(value){
        field=value.trim() //String 타입의 trim함수를 호출하여 문자열 앞뒤 공백문자를 제거한다.
    }
    var healthPoints = 89
    val isBlessed = true
    private val isImmortal = false

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus()=
        when (healthPoints) {
            100 -> " 최상의 상태임!"
            in 90..99 -> "약간의 찰과상만 있음."
            in 75..89 -> if (isBlessed) {
                "경미한 상처가 있지만 빨리 치유되고 있음!"
            } else {
                "경미한 상처만 있음."
            }
            in 15..74 -> "많이 다친 것 같음."
            else -> "최악의 상태임!"
        }


    fun castFireball(numFireballs:Int=2)=
            println("한덩어리의 파이어볼이 나타난다. (x$numFireballs)")
}
