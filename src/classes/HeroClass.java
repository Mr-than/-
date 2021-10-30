package classes;

import interfaces.*;

import java.util.Random;
import java.util.Scanner;

//英雄

public class HeroClass implements Hero {
    BatmanClass be;

    //英雄名字
    private String name;
    //英雄血量
    private int HP;
    //英雄攻击力
    private int damage;
    //英雄防御力
    private int defense;
    //这个成员是被迫加的，因为必须要记录一下加了哪些装备你懂伐
    private String[] EQ;
    //记录装备数
    private int num;

    //因为要求要有一个构造器。。。这个构造器正好可以用来初始化我那个数组，美滋滋
    public HeroClass() {
        this.num=0;
    EQ =new String[5];

    }

    public void temp1(BatmanClass b){
        be=b;
    }

    public void setName(String name) {
        while (name.length() > 20) {
            System.out.println("输入的名称超过20字，请重新输入：");
            Scanner scanner = new Scanner(System.in);
            String name1 = scanner.next();
            if (name1.length() <= 20) {
                this.name = name1;
                return;
            }
        }
        this.name = name;
    }


    public void setHp(int hp) {
        while (hp > 9999 || hp < 1) {
            System.out.println("英雄血量输入有误，请重新输入：");
            Scanner scanner = new Scanner(System.in);
            int hp1 = scanner.nextInt();
            if (hp1 <= 9999 && hp1 >= 1) {
                this.HP = hp1;
                return;
            }
        }
        this.HP = hp;
    }


    public void setDamage(int damage) {
        while (damage > 999 || damage < 1) {
            System.out.println("英雄攻击力输入有误，请重新输入：");
            Scanner scanner = new Scanner(System.in);
            int damage1 = scanner.nextInt();
            if (damage1 <= 999 && damage1 >= 1) {
                this.damage = damage1;
                return;
            }
        }
        this.damage = damage;
    }


    public void setDefense(int defense) {
        while (defense > 999 || defense < 1) {
            System.out.println("英雄防御力输入有误，请重新输入：");
            Scanner scanner = new Scanner(System.in);
            int defense1 = scanner.nextInt();
            if (defense1 <= 999 && defense1 >= 1) {
                this.defense = defense1;
                return;
            }
        }
        this.defense = defense;
    }

    //英雄的血条打印
    public void articleBlood(){
        for (int i = 0; i < this.HP/100; i++) {
            System.out.print("█");
            if(this.HP<100){
                System.out.println("别慌，我能反杀！！！！");
            }
        }
        System.out.println();
    }

    //获取英雄信息
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

    //添加装备到数组
    public void addEq(String name){
        EQ[this.num]=name;
        ++this.num;
    }

    //获取加了哪些装备
    public int getEQ(){
        for (String temp:this.EQ) {
            if(temp!=null) {
                System.out.print("[" + temp + "]");
            }
            System.out.print("\t");
        }
        System.out.println();

        return this.num;
    }

//接口回调固定对敌方照成50伤害
    public void automaticCounter(){
        Random random = new Random();
        int p/*几率的意思*/=random.nextInt(9)+1;
        if(p==6){
            System.out.println("哎呀，攻击突然减少了10点呢（这是为什么呢？因为你小廖老师这么要求的）");
            if(be.getHp()-40<=0){
                be.setHp(0);
            }else {
                be.setHp(be.getHp() - 40);
            }
        }
        System.out.println("此次反击为40点伤害");
        if(p==6){
            return;
        }

        if(be.getHp()-50<=0){
            be.setHp(0);
        }else {
            be.setHp(be.getHp() - 50);
        }
    be.automaticCounter(this);
    }

    public void back(){
        System.out.println("英雄完成反击，对敌方造成伤害");
    }


}
