//예외처리
fun main() {
    var swordsJuggling: Int? =null
    val isJugglingProficient=(1..3).shuffled().last()==3
    if(isJugglingProficient){
        swordsJuggling=2
    }
    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)
    println("$swordsJuggling 개의 칼로 저글링합니다.!")

}
fun proficiencyCheck(swordsJuggling: Int?){
    swordsJuggling ?: throw IllegalStateException("플레이어가 저글링을 할 수 없음")
}

//IllegalStateException이 생길때 에러메시지가 제공되므로 프로그램이 크래시 되는 이유를 알 수 있다.