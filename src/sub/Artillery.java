package sub;

import classes.*;

//炮兵
public class Artillery extends BatmanClass {
    private String name;
    private int HP;
    private int damage;

    public Artillery() {
        this.name = "炮车";
    }
    public String getName() {
        return this.name;
    }
}
