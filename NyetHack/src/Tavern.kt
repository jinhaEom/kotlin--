import kotlin.math.roundToInt
import java.io.File
const val TAVERN_NAME = "Taernyl's Folly"


val patronList = mutableListOf("Eli","Mordoc","Sophie")
val lastName = listOf("Ironfoot","Fernsworth","Baggins")
val uniquePatrons=mutableSetOf<String>()
val menuList=File("data/tavern-menu-items.txt")
    .readText() //파일의 모든내용을 하나의 문자열로 반환한다.
    .split("\r\n")  // split 함수는 리스트의 요소로 각 항목을 분리하여 저장하게 하는 역할
val patronGold= mutableMapOf<String,Double>()
/*
mutableListOf는 저장된 요소를 변경해야할때 사용을 하고
listOf는 고정된 값을 사용할때 사용
 */
fun main() {
    if (patronList.contains("Eli")) {
        println("술집 주인이 말한다 : Eli 는 안쪽 방에서 카드를 치고있어요.")
    } else {
        println("술집 주인이 말한다: Eli는 여기 없어용ㅎㅎ")
    }
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("술집 주인이 말한다 : 네 모두 술집에 있읍니다.")
    } else {
        println("술집 주인이 말한다 : 나간사람도 있으예")
    }

    (0..9).forEach{
        val first=patronList.shuffled().first()
        val last=lastName.shuffled().first()
        val name="$first $last"
        uniquePatrons+=name
    }
    uniquePatrons.forEach{
        patronGold[it]=6.0
    }

    var orderCount=0
    while(orderCount<=9) {
        placeOrder(
            uniquePatrons.shuffled().first(),
            menuList.shuffled().first()
        )
        orderCount++
    }
    displayPatronBalances()
}
private fun displayPatronBalances(){
    patronGold.forEach{ patron,balance ->
        println("$patron, balance : ${"%.2f".format(balance)}")
    }
}
fun performPurchase(price:Double,patronName:String){
    val totalPurse=patronGold.getValue(patronName)
    patronGold[patronName]= totalPurse-price
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
private fun placeOrder(patronName: String,menuData:String){
    val indexOfApostrophe=TAVERN_NAME.indexOf('\'')
        val tavernMaster=TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName 은 $tavernMaster 에게 주문한다.")

    val(type,name,price)=menuData.split(',')//
    val message="$patronName 은 금화 $price 로 $name($type)을 구입한다."
    println(message)

    performPurchase(price.toDouble(),patronName)

    val phrase = if(name=="Dragon's Breath"){
        "$patronName 이(가) 감탄한다: ${toDragonSpeak(("와 $name 진짜 좋구나"))}"

    }else{
        "$patronName 이(가) 말한다: 감사합니다 $name."
    }
    println(phrase)
}