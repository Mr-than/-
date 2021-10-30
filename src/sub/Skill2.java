package sub;
import classes.*;
public class Skill2 extends Skills{
    //技能名字
    public String getSkillName() {
        return "智蔷杀";
    }

    //技能伤害

    //志强杀会对敌方造成目前血量百分之3的伤害，无视护甲，会为自身回复100滴血。
    public int getSkillProperty(HeroClass h) {
        return (int) (h.getHp() * 0.04);
    }
    public int skillEffect() {
        //设定志强杀返回数字为  ：  2
        return 2;
    }
}
