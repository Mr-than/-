package interfaces;

//英雄
/*
 *设置这个英雄接口是因为我有多英雄对战的想法，所以为了方便扩展，不过时间有限，应该在交作业之前是实现不了了
 */
public interface Hero {
    public void setName(String name);
    public void setHp(int hp);
    public void setDamage(int damage);
    public void setDefense(int defense);

    public String getName();
    public int getHp();
    public int getDamage();
    public int getDefense();

    public void back();

}
