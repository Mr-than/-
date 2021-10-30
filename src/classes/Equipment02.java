package classes;
import interfaces.*;

public class Equipment02 implements Equipment{
    private String name;
    public Equipment02(){
        this.name="邱天盔甲";
    }
    public String getName(){
        return this.name;
    };

    public int getAddDamage(){
        return 10;
    };

    public int getAddDefense(){
        return 200;
    };
}
