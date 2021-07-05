import kotlin.math.roundToInt
const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
fun main() {
    //placeOrder("shandy, Dragon's Breath,5.91")
    placeOrder("elixir,Shirley's Temple,4.12")

}
fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold +(playerSilver/100.0) //실수이기 때문에 100.0 으로 나누어준다.
    println("지갑 전체 금액: 금화 $totalPurse")
    println("금화 $price 로 술을 구입함")
    val remainingBalance = totalPurse-price
    println("남은 잔액: ${"%.2f".format(remainingBalance)}") //소수점 2째자리까지 나타나게 하기 위함.

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance%1*100).roundToInt()
    playerGold=remainingGold
    playerSilver=remainingSilver
    displayBalance()
}
private fun displayBalance(){
    println("플레이어의 지갑 잔액: 금화: $playerGold 개, 은화: $playerSilver 개")
}

private fun toDragonSpeak(pharse:String)=
    pharse.replace(Regex("[aeiou]")){
        //Regex함수는 찾아서 변경할 문자가 정의된 검색패턴인 "[aeiou]"를 인자로 받는다.
        when(it.value){
            "a"->"4"
            "e"->"3"
            "i"->"1"
            "o"->"0"
            "u"->"|_|"
            else->it.value
        }
    }
private fun placeOrder(menuData:String){
    val indexOfApostrophe=TAVERN_NAME.indexOf('\'')
        val tavernMaster=TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("마드리드같은 $tavernMaster 에게 주문한다.")

    val(type,name,price)=menuData.split(',')//
    val message="마드리갈은 금화 $price 로 $name ($type)를 구입한다."
    println(message)

    performPurchase(price.toDouble())

    val phrase = if(name=="Dragon's Breath"){
        "마드리갈이 감탄한다: ${toDragonSpeak(("와 $name 진짜 좋구나"))}"

    }else{
        "마드리갈이 말한다: 감사합니다 $name."
    }
    println(phrase)
}