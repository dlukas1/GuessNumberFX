/**
 * Created by Dmitry on 8.11.2016.
 */
public class Engine {


    public int rndNum;

    public Engine() {
        GenerateNumber();
    }

    public void GenerateNumber() {  //constructor creates rndNum
        this.rndNum = (int) (Math.random() * 100);
    }

    public String Check(int a) {
        if (a > this.rndNum) {
            return "Sinu number on liiga suur";
        } else if (a == this.rndNum) {
            return "Võit!";
        } else {
            return "Sinu number on liiga vaike";
        }
    }
    public boolean kasNumber (String a) {
        try {
            Integer.parseInt(a);
        } catch(Exception e){
            return false;
        }
        return true;
    }
}
