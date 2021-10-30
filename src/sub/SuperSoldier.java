package sub;

import classes.*;

//超级兵
public class SuperSoldier extends BatmanClass {
    private String name;
    private int HP;
    private int damage;

    public SuperSoldier() {
        this.name = "超级兵";
    }
    public String getName() {
        return this.name;
    }
}
