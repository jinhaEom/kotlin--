/*
플레이어 캐릭터 생성 -> player 클래스의 생성자를 호출하여 인스턴스를 생성.
 */
import java.io.File
class Player(_name :String,
             var healthPoints : Int = 100,
             val isBlessed : Boolean,
             private val isImmortal : Boolean
)

{
    var name = _name
        get()="${field.capitalize()} of $hometown"
    private set(value){
        field=value.trim() //String 타입의 trim함수를 호출하여 문자열 앞뒤 공백문자를 제거한다.
    }
    val hometown by lazy { selectHometown() }
    init{
        require(healthPoints>0,{"healthPoints는 0보다 커야 합니다."})
        require(name.isNotBlank(),{"플레이어의 이름이 있어야 합니다."})
    }
    constructor(name:String) : this(name,    //this 키워드 = 보조 생성자를 사용해서 생성되는 player 인스턴스의 또다른 생성자인 기본생성자를 뜻함.
        isBlessed = true,
        isImmortal=false){
        if(name.toLowerCase()=="kar") healthPoints=40  //toLowerCase = 문자열을 소문자로 변환하여 반환
    }


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

    private fun selectHometown()=File("data/towns.txt")
        .readText()
        .split("\r\n")
        .shuffled()
        .first()
}

