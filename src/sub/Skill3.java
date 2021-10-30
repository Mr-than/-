package sub;
import classes.*;
public class Skill3 extends Skills{
    //技能名字
    public String getSkillName() {
        return "王兮砍";
    }

    //技能伤害
    //王兮砍会对敌方造成百分之15的伤害，无其他效果（属于是用伤害弥补了效果的不足）。
    public int getSkillProperty(HeroClass h) {
        System.out.println("技能实现，对敌方造成自身血量百分之15得伤害，无视护甲。");
        return (int) (h.getHp() * 0.15);
    }
    public int skillEffect() {
        //设定王兮砍返回数字为  ：  3
        return 3;
    }
}
