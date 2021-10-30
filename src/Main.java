/*
*
*  感谢郭祥瑞学长和涂智强学长的指导。
*
*/



//下面是导包

import classes.*;
import interfaces.*;
import sub.*;


//下面是java自带方法的导包
import java.util.ArrayList;
import java.util.Scanner;

//下面是设置英雄的方法
public class Main {
    public static void makeHero(Hero hero) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入英雄名称(20字内，不留空格)：");
        hero.setName(scanner.next());
        System.out.println("请输入英雄血量(1-9999)：");
        hero.setHp(scanner.nextInt());
        System.out.println("请输入英雄攻击力(1-999)：");
        hero.setDamage(scanner.nextInt());
        System.out.println("请输入英雄防御力(1-999)：");
        hero.setDefense(scanner.nextInt());
    }

    //下面是设置小兵的方法
    public static void makeBatman(ArrayList<BatmanClass> m) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("设置小兵血量（1-999）：");
        int hp =scanner.nextInt();
        for (int i = 0; i < m.size(); i++) {
            if(m.get(i).getName().equals("炮兵")){
                if(hp+100>999){
                    m.get(i).setHp(999);
                }else {
                    m.get(i).setHp(hp + 100);
                }
            }
            else if(m.get(i).getName().equals("远程小兵")){
                if(hp-100<=0){
                    m.get(i).setHp((int)hp/2);
                }else {
                    m.get(i).setHp(hp - 100);
                }
            }else {
                m.get(i).setHp(hp);
            }
        }

        System.out.println("设置小兵攻击力（1-999）：");
        int damage =scanner.nextInt();
        for (int i = 0; i < m.size(); i++) {
            if(m.get(i).getName().equals("炮兵")){
                if(damage+100>999){
                    m.get(i).setDamage(999);
                }else {
                    m.get(i).setDamage(damage + 100);
                }
            }
            else if(m.get(i).getName().equals("远程小兵")){
                if(damage+100>999){
                    m.get(i).setDamage(999);
                }else {
                    m.get(i).setDamage(damage + 100);
                }
            }else {
                m.get(i).setDamage(damage);
            }
        }

        System.out.println("设置小兵防御力（1-999）：");

        int defense=scanner.nextInt();
        for (int i = 0; i < m.size(); i++) {
            if(m.get(i).getName().equals("炮兵")){
                if(defense+100>999){
                    m.get(i).setDefense(999);
                }else {
                    m.get(i).setDefense(defense + 100);
                }
            }
            else if(m.get(i).getName().equals("远程小兵")){
                if(defense-100<=0){
                    m.get(i).setDefense((int)defense/2);
                }else {
                    m.get(i).setDefense(defense - 100);
                }
            }else {
                m.get(i).setDefense(defense);
            }
        }
    }


    //main方法在这里呀+++++++++++++++++++++++++++++++++（主要是防止找不到，代码多了就找不到）+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        HeroClass hero = new HeroClass();
        makeHero(hero);

    //下面懂的都懂，不懂的我也不在这里说，利益相关，这里面水很深，你把握不住。

        ArrayList<BatmanClass> r= new ArrayList<>(5);
        BatmanClass m = new MeleeCreeps();
        BatmanClass m1 = new MeleeCreeps();
        BatmanClass m2 = new MeleeCreeps();
        BatmanClass remo = new RemoteBatman();
        BatmanClass sup =new SuperSoldier();
        //这几步自然不必多说
        r.add(m);
        r.add(m1);
        r.add(m2);
        r.add(remo);
        r.add(sup);



       makeBatman(r);


        FightClass f = new FightClass();
        Skills s;

        System.out.println("选择一个技能：1.祥瑞斩\t2.智蔷杀\t3.王兮砍");
        //以下temp记录选择的技能
        int temp =scanner.nextInt();
        while (temp!=1&&temp!=2&&temp!=3){
            System.out.println("给你个技能还这么费劲？？？你到底要不要你？？？");
            temp =scanner.nextInt();
        }

        switch (temp){
            case 1:
            {
                System.out.println("你选择了祥瑞斩");
                s=new Skills();
                f.fight(r, hero, s);
                break;
            }
            case 2:
            {
                System.out.println("你选择了志蔷杀");
                s=new Skill2();
                f.fight(r, hero, s);
                break;
            }
            case 3:
            {
                System.out.println("你选择了王兮砍");
                s=new Skill3();
                f.fight(r, hero, s);
                break;
            }
        }


/*
 做到这里了我有了进行多局的思路，如下：

 在Main方法里面设置一个循环，设置一个变量，这个变量记录局数，完成一局（即Main方法里面循环完成一次）则加一，直到达到
 我想要的局数，这个局数作为循环的判断条件，每一局都传不同的对象进入Arraylist，这样即可实现无缝衔接。

  以上思路我觉得实现起来应该没有太大问题，但是我转念一想，应该没人真的会坚持玩儿那么久（我lan），没有太大意义，于是乎就并没有去实现这个想法。
 */

    }
}
