package interfaces;
import classes.*;

public interface HeroSkills {
    /*
     *英雄技能名应该是作者自己提前设置得，所以这里的方法就不用传入参数了。
     *
     * 所有技能CD都为三回合
     */
    //返回英雄技能名字
    public String getSkillName();
    //返回英雄技能伤害（效果）
    public int getSkillProperty(HeroClass h);
}
