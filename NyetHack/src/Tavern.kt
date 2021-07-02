fun main() {
    var beverage = readLine()?.let{
        if(it.isNotBlank()){
            it.capitalize()
        }else{
            "맥주"
        }
    }
    //    beverage=null

    println(beverage)
}