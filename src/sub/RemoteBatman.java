package sub;

import classes.*;

//远程小兵
public class RemoteBatman extends BatmanClass {
    protected String name;
    protected int HP;
    protected int damage;

    public RemoteBatman() {
        this.name = "远程小兵";
    }
    public String getName() {
        return this.name;
    }
}
