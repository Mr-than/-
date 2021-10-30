package classes;

import interfaces.*;

import java.util.Scanner;

/*
 *这是所有小兵的父类，遵循小兵接口。
 */

//小兵
public class BatmanClass implements Batman {
    private String name;
    private int HP;
    private int damage;
    private int defense;

    //因为题目要求必须要用构造器构造器来构造，所以我水了一个空的。。。。。。（反正我就是有，你能拿我怎么样 /doge （小声bb））
    public BatmanClass() {}

    //小兵血条
    public void articleBlood(){
        for (int i = 0; i < this.HP/100; i++) {
            System.out.print("█");

        }
        System.out.println();
    }

    //设置小兵的属性
    public void setDefense(int defense) {
        while (defense>500||defense<1) {
            System.out.println("小兵防御力输入有误，请重新输入：");
            Scanner scanner =new Scanner(System.in);
            int defense1 =scanner.nextInt();
            if (defense1<=9999&&defense1>=1){
                this.defense=defense1;
                return;
            }
        }
        this.defense=defense;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setHp(int hp) {
        while (hp>5000||hp<0) {
            System.out.println("小兵血量输入有误，请重新输入：");
            Scanner scanner =new Scanner(System.in);
            int hp1 =scanner.nextInt();
            if (hp1<=5000&&hp1>=0){
                this.HP=hp1;
                return;
            }
        }
        this.HP=hp;
    }

    public void setDamage(int damage) {
        while (damage>999||damage<1) {
            System.out.println("小兵攻击力输入有误，请重新输入：");
            Scanner scanner =new Scanner(System.in);
            int damage1 =scanner.nextInt();
            if (damage1<=999&&damage1>=1){
                this.damage=damage1;
                return;
            }
        }
        this.damage=damage;
    }



    //返回小兵的属性
    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.HP;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getDefense() {
        return this.defense;
    }

    //这个方法实现接口回调。
    public void automaticCounter(Hero he){
        he.back();
    }

}
