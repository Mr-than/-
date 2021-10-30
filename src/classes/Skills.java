package classes;

import interfaces.HeroSkills;
    //这个类会作为父类，用多态实现技能,同时其自身也可以用于实现技能。

/*
 *想了几个小时找到了实现技能效果的思路：
 * 写好技能效果方法，让其返回特定数字，在FighClass类中进行比对
 * 首先想到用if语句比对，然后是用switch，因为所有技能效果都是在打出伤害之后实现，所有只需要对其
 * 打出伤害的后续代码优化即可。
 */

public class Skills implements HeroSkills {

    //技能名字
    public String getSkillName() {
        return "祥瑞斩";
    }

    //技能伤害

    //祥瑞斩伤害为当前血量的百分之8，无视防御，攻击结束后会闪避一次敌方攻击

    public int getSkillProperty(HeroClass h) {
        return (int) (h.getHp() * 0.08);
    }


    public int skillEffect() {
    //设定祥瑞斩返回数字为  ：  1
        return 1;
    }
}
