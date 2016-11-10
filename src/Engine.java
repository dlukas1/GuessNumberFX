/**
 * Created by Dmitry on 8.11.2016.
 */
public class Engine {
    //dat novoe imja !=sisNum

    public int sisNum;
//zamenit sisNum na "random"
    public Engine(){
        this.sisNum = GenerateNumber();
    }

    public int GenerateNumber() {return (int)(Math.random()*100);}

    public String Check (int a) {
        if(a > this.sisNum) {return "Sinu number on liiga suur";
    } else if (a == this.sisNum) {return "Võit!";
} else {return "Sinu number on liiga vaike";}}}
