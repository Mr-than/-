package sub;

import classes.*;

//近战小兵
public class MeleeCreeps extends BatmanClass {
    private String name;
    private int HP;
    private int damage;
    private int defense;

    public MeleeCreeps() {
        this.name = "近战小兵";
    }
    public String getName() {
        return this.name;
    }


}
