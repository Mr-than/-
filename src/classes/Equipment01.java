package classes;
import interfaces.*;

public class Equipment01 implements Equipment{
    private String name;
    public Equipment01(){
        this.name="俊枭之剑";
    }
    public String getName(){
        return this.name;
    };

    public int getAddDamage(){
        return 100;
    };

    public int getAddDefense(){
        return 50;
    };
}
