package model;

import color.colour;

public class RpgHero {

    private String name;
    private int level;
    private int gold;
    private double experience;
    private double hp;
    private double mp;
    private double attack;
    private double defend;
    private int day;

    public RpgHero(String name, double experience, int gold, int day) {

        double e = 100;
        this.name = name;
        this.experience = experience;
        if (this.experience <= 100) {
            this.level = 1;
        } else {
            this.level = (int) Math.floor((experience / e)); // 100 point for 1 level 
        }
        this.hp = (level * 100);
        this.mp = (level * 60);
        this.attack = (level * 5);
        this.defend = (level * 3);
        this.gold = 500;
        this.day = 0;
    }

    public void printHeroStatus() {
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"________________________________________");
        System.out.printf(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"|Status: %s\t\t Hari: %d\t |%n", name, day);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"==========================================");
        System.out.printf(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"|Level: %d\t\t Exp: %.2f\t |%n", level, experience);
        System.out.printf(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"|Duit : %d\t\t\t\t |%n", gold);
        System.out.printf(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"|HP: %.0f\t\tMP: %.0f\t\t |%n", hp, mp);
        System.out.printf(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"|Atk: %.0f\t\t\tDef:%.0f\t\t |%n", attack, defend);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"==========================================");
    }

    public void hitToHero(double hitpoint) {
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"=========================================================");
        System.out.printf(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"%s Status:%n",name);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"Level:" + level + "\t\tMP:"+ mp );
        hp = hp - (hitpoint);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"HP:" + hp + "\t\tAtk:" + attack +"\t\tDef:" + defend);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE +"=========================================================");
    }

    public void addExperience(double exps) {
        double e = 100;
        int currentLevel = level;
        experience = experience + exps;
        level = (int) Math.floor((experience / e));
        System.out.printf(colour.ANSI_BG_PURPLE + colour.ANSI_WHITE +"Experience added : %.2f%n",exps);
        if (level > currentLevel) {
            hp = (level * 50);
            attack = (level * 5);
            defend = (level * 3);
            System.out.println(colour.ANSI_BG_PURPLE + colour.ANSI_WHITE +"Hero Level Up from " + currentLevel + " to " + level);
        }
    }

    public void addDay() {
        day++;
    }

    public void rest() {
        hp = (level * 100);
        mp = (level * 60);
    }
    
    public void addGold(int a){
        gold = gold + a;
        System.out.printf(colour.ANSI_BG_PURPLE + colour.ANSI_WHITE +"Gold added : %d%n",a);
    }
    
    public void addHp(int a){
        hp = hp+a;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public double getExperience() {
        return experience;
    }

    public double getHp() {
        return hp;
    }

    public double getMp() {
        return mp;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefend() {
        return defend;
    }

    public int getDay() {
        return day;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public void setDefend(double defend) {
        this.defend = defend;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    public void newGold(int gold){
        this.gold = this.gold - 500000;
    }
    
    public void minMp(double mp){
        this.mp = this.mp - (this.mp/4);

    }
    
}
