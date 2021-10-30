package classes;

import interfaces.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 *这是战斗系统。
 */
public class FightClass{

    private void pickEq(Equipment e,HeroClass h){
        Scanner scanner =new Scanner(System.in);
        System.out.println("哇哦，掉了一个装备："+e.getName()+"是否捡起？\t1：捡起\t2：捡个锤子，滚一边去！");
        int pick = scanner.nextInt();
        while (pick!=1&&pick!=2){
            System.out.println("你故意找茬是不是？！，就问你捡不捡吧？你捡不捡？！");
        }
        switch (pick){
            case 1:
            {
                System.out.println("恭喜这个b获得攻击提升"+e.getAddDamage()+"点"+"防御提升"+e.getAddDefense()+"点");
                h.setDamage(h.getDamage()+e.getAddDamage());
                h.setDefense(h.getDefense()+e.getAddDefense());
                h.addEq(e.getName());
                System.out.println("目前持有的装备：");
                h.getEQ();
            }
            break;

            case 2:
            {
                System.out.println("这都不捡");
                System.out.println();
                System.out.println();
                return;
            }

        }
    }


    public void fight(ArrayList<BatmanClass> b, HeroClass h, Skills s) {
        //这俩玩意儿的话，CD有眼睛都知道是什么 /doge sk是用来记录下方技能效果返回值的。
        int CD = 0;
        int sk;
        //下面这玩意儿是用来记录装备爆率的,用随机数来设置爆率。
        int eq;
        //下面这玩意儿不用解释吧
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Equipment e;


        //这个循环是为了保证战斗能结束，此系统判断结束的标准是有一方输掉（即血量变为<=0）
        outer1:
        while (b.get(0).getHp() > 0||b.get(1).getHp() > 0||b.get(2).getHp() > 0||b.get(3).getHp() > 0||b.get(4).getHp() > 0&& h.getHp() > 0) {


            //到这里的话下面就是开打了。

            //下面用随机数和if判断是否掉装备，有2种装备（主要装备效果真tm难想。。。。）
            eq = random.nextInt(29) + 1;

            if (eq == 1 && h.getEQ() <= 4) {
                e = new Equipment01();
                this.pickEq(e, h);
            }
            if (eq == 2 && h.getEQ() <= 4) {
                e = new Equipment02();
                this.pickEq(e, h);
            }


            System.out.println("目前你的血量：" + h.getHp());
            h.articleBlood();

            for (int i = 0; i < b.size(); i++) {
                System.out.println(b.get(i).getName()+"💀" + (i + 1) + "血量：" + b.get(i).getHp());
                b.get(i).articleBlood();
            }
            System.out.println("请输入想要攻击的小兵（数字1-5）：");

            //下面是选择小兵打
            int chose = scanner.nextInt();
            while (chose != 1 && chose != 2 && chose != 3 && chose != 4 && chose != 5) {
                System.out.println("？？？？我让你选个小兵打就这么难？？？就这么难？？？");
                chose = scanner.nextInt();
            }

            if (b.get(chose-1).getHp() == 0) {
                System.out.println("做个人？？！！人家死啦，还带鞭尸的？？");
                System.out.println("滚回去重新选！！");
                System.out.println("\n");
            } else {
                //判断技能CD
                if (CD == 10) {
                    CD = 0;
                }
                h.temp1(b.get(chose-1));
                //下面记录攻击方式
                System.out.println("请选择使用的攻击方式：");
                System.out.print("1：平A\t2：技能：" + s.getSkillName());
                if (CD != 0) {
                    System.out.println("（冷却中）");
                } else {
                    System.out.println();
                }
                int way = scanner.nextInt();

                //记录下来开始攻击啦
                while (way != 1 && way != 2) {
                    System.out.println("输入有误，重新输入。");
                    way = scanner.nextInt();
                }
                while (way == 2 && CD != 0) {
                    System.out.println("技能冷却中，请重新输入。");
                    way = scanner.nextInt();
                }
                switch (way) {
                    case 1: {
                        //暴击判断（理论上来说应该是20分之一的暴击率？假随机，不好确定，反正有这么个东西233）
                        int strike = random.nextInt(20) + 1;

                        //下面为英雄对小兵伤害判断
                        int a = (int) (h.getDamage() * 100 / (100 + b.get(chose - 1).getDefense()));

                        if(strike == 6) {
                            System.out.println(h.getName() + "对小兵造成一次暴击，暴击伤害" + (a + 20));

                            if (b.get(0).getHp()<= 0 && b.get(1).getHp()<= 0 && b.get(2).getHp()<= 0 && b.get(3).getHp()<= 0 && b.get(4).getHp()<=0) {
                                System.out.println(h.getName() + "赢了");
                                return;
                            }
                            if (b.get(chose - 1).getHp() - a < 0) {
                                b.get(chose - 1).setHp(0);
                            } else {
                                b.get(chose - 1).setHp(b.get(chose - 1).getHp() - (a + 20));
                            }
                        } else {
                            System.out.println(h.getName() + "伤害小兵" + a);
                            if (b.get(0).getHp()<= 0 && b.get(1).getHp()<= 0 && b.get(2).getHp()<= 0 && b.get(3).getHp()<= 0 && b.get(4).getHp()<= 0) {
                                System.out.println(h.getName() + "赢了");
                                return;
                            }
                            if (b.get(chose - 1).getHp() - a < 0) {
                                b.get(chose - 1).setHp(0);
                            } else {
                                b.get(chose - 1).setHp(b.get(chose - 1).getHp() - 20);
                            }
                        }
                    }
                    break;
                    case 2: {
                        System.out.print("发动了技能:" + s.getSkillName() + "\t");
                        //下面的temp记录伤害
                        int temp = s.getSkillProperty(h);
                        //下面的temp1记录小兵原来血量
                        int temp1 = b.get(chose - 1).getHp();
                        System.out.println("对敌方造成伤害：" + temp);

                        if (b.get(0).getHp() - temp < 0 && b.get(1).getHp() - temp < 0 && b.get(2).getHp() - temp < 0 && b.get(3).getHp() - temp < 0 && b.get(4).getHp() - temp < 0) {
                            System.out.println(h.getName() + "赢了");
                            return;
                        }
                        if(b.get(chose-1).getHp()-s.getSkillProperty(h)<0){
                            b.get(chose-1).setHp(0);
                        }else {
                            b.get(chose - 1).setHp(b.get(chose - 1).getHp() - s.getSkillProperty(h));
                        }
                        // System.out.println("目前小兵的血量：" + (temp1 - temp));
                        //以下sk变量用来接受技能效果方法返回的值，用于下方if判断
                        sk = s.skillEffect();
                        if (sk == 1) {
                            CD++;
                            System.out.println("技能效果实现，闪避一次敌方攻击。");
                            continue outer1;
                        }
                        if (sk == 2) {
                            //这里使用技能后会给英雄加血100
                            CD++;
                            System.out.println("技能效果实现，英雄回复100单位血量。");
                            if(h.getHp()+100<9999) {
                                h.setHp(h.getHp() + 100);
                            }else{
                                h.setHp(9999);
                            }
                        }
                        //由于sk==3时其实没有任何效果，所以可以直接不接收 王兮姐姐这么单纯能有个啥花里胡哨的效果/doge
                    }

                }


                //下面为小兵对英雄伤害判断

                int c = (int) (b.get(chose - 1).getDamage() * 100 / (100 + h.getDefense()));
                System.out.println(b.get(chose-1).getName()+"小兵伤害" + h.getName() + "：" + c);
                if (h.getHp() - c < 1) {
                    System.out.println(h.getName() + "输了");
                    return;
                }
                h.setHp(h.getHp() - c);
                h.automaticCounter();
                if (b.get(0).getHp()<= 0 && b.get(1).getHp()<=0 && b.get(2).getHp() <= 0 && b.get(3).getHp() <= 0 && b.get(4).getHp() <= 0) {
                    System.out.println(h.getName() + "赢了");
                    return;
                }

                if (way == 2 || (CD>=1&&CD<=10) ){
                    CD++;
                }

            }
        }
    }
}
