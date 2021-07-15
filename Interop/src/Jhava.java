import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Jhava {
    private int hitPoints = 52489112;
    private String greeting = "BLARGH";

    public static void main(String[] args){
        System.out.println(Hero.makeProclamation());

        System.out.println("Spells:");
        Spellbook spellbook = new Spellbook();
    for (String spell : spellbook.spells){
        System.out.println(spell);
    }
    System.out.println("Max spell count :"+ Spellbook.MAX_SPELL_COUNT);

    Spellbook.getSpellbookGreeting();
     // 동반 객체를 나타내는 Companion 키워드와 게터를 나타내는 접두사인 get 키워드를 지정해야 함.
        Function1<String, Unit> translatorJ = Hero.getTranslator();
        translatorJ.invoke("TRUCE");
    }
    @NotNull
    public String utterGreeting(){

        return greeting;
    }
    @Nullable
    public String determineFriendshipLevel(){

        return null;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String getGreeting(){
        return greeting;
    }
    public void setGreeting(String greeting){
        this.greeting=greeting;
    }
    public void offerFood(){
        Hero.handOverFood("피자");
    }
    public void extendHandInFriendship() throws Exception{
        throw new Exception();
    }

    public void apologize(){
        try{
            Hero.acceptApology();
        }catch(IOException e){
            System.out.println("Caught!");
        }
    }
}
