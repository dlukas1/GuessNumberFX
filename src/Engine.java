/**
 * Created by Dmitry on 8.11.2016.
 */
public class Engine {


    public int rndNum;

    public Engine() {
        GenerateNumber();
    }

    public void GenerateNumber() {
        this.rndNum = (int) (Math.random() * 100);
    }

    public String Check(int a) {
        if (a > this.rndNum) {
            return "Sinu number on liiga suur";
        } else if (a == this.rndNum) {
            return "Võit!";
        } else if (a > 100) {
            return "Number ei saa olla suurem kui 100!";
        } else if (a <= 0) {
            return "Number ei saa olla 0 või vähem!";
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
