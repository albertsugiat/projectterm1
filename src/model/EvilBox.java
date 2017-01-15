package model;

import color.colour;

public class EvilBox {

    private double attack;
    private double hp;
    private double defend;
    private int level;
    private double experience;
    private String name;

    public EvilBox(String name, double experience) {
        this.name = name;
        double e = 100;
        this.experience = experience;
        if (this.experience <= 100) {
            this.level = 1;
        } else {
            this.level = (int) Math.floor((experience / e)); // 100 point for 1 level 
        }
        this.attack = level * 2;
        this.hp = level * 20;
        this.defend = level * 3;

    }

    public EvilBox(double experience) {
        this.name = "Boss";
        double e = 100;
        this.experience = experience;
        if (this.experience <= 100) {
            this.level = 1;
        } else {
            this.level = (int) Math.floor((experience / e)); // 100 point for 1 level 
        }
        this.attack = level * 6;
        this.hp = level * 75;
        this.defend = level * 4;
    }

    public void printEvilStatus() {
        System.out.printf(colour.ANSI_BG_GREEN + colour.ANSI_WHITE + "%s Status:%n", name);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE + "Level:" + level + "\t\t");
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE + "HP:" + hp + "\tDMG:" + attack + "\t\tDEF:" + defend);
    }

    public void hitToEvil(String name, double hitpoint) {
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE + "======================================================");
        System.out.printf(colour.ANSI_BG_GREEN + colour.ANSI_WHITE + "%s Status:%n", name);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE + "Level:" + level + "\t\t");
        hp = hp - (hitpoint);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE + "HP:" + hp + "\t\tDMG:" + attack + "\t\tDEF:" + defend);
        System.out.println(colour.ANSI_BG_GREEN + colour.ANSI_WHITE + "=======================================================");

    }

    public double getAttack() {
        return attack;
    }

    public double getHp() {
        return hp;
    }

    public double getDefend() {
        return defend;
    }

    public int getLevel() {
        return level;
    }

    public double getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

}
