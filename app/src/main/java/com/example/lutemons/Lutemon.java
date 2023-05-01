package com.example.lutemons;

import java.io.Serializable;

import java.util.Random;

import java.util.Comparator;


public class Lutemon implements Serializable {

    protected String name, color, species;
    protected Integer attack, defense, experience, health, maxHealth, wins, losses, image, level;

    public Lutemon(String name, String color, String species,Integer attack, Integer defense, Integer experience, Integer health, Integer maxHealth, Integer wins, Integer losses, Integer image, Integer level){
        this.name = name;
        this.color = color;
        this.species = species;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.wins = wins;
        this.losses = losses;
        this.image = image;
        this.level = level;
    }

    public String getName() {return name;}

    public String getColor() {return color;}
    public Integer getImage(){return image;}
    public String getSpecies() {return species;}

    public Integer getAttack() {return attack;}

    public Integer getDefense() {return defense;}
    public Float getFloatDefence() {return (float)defense;}

    public Integer getExperience() {return experience;}

    public Integer getHealth() {return health;}

    public Integer getMaxHealth() {return maxHealth;}

    public Integer getWins() {return wins;}

    public Integer getLosses() {return losses;}

    public void setAttack(Integer attack) {this.attack = attack;}

    public void setDefense(Integer defense) {this.defense = defense;}

    public void setExperience(Integer experience) {this.experience = experience;}

    public void setHealth(Integer health) {this.health = health;}

    public void setMaxHealth(Integer maxHealth) {this.maxHealth = maxHealth;}

    public void setWins(Integer wins) {this.wins = wins;}

    public Integer getLevel(){return level;}
    public void setLevel(Integer level){this.level = level;}

    public void setLosses(Integer losses) {this.losses = losses;}
    public void levelUp(){
        String lutemonClass = this.getSpecies();
        switch (lutemonClass){
            case "Tank":
                this.setAttack(this.getAttack() + 2);
                this.setDefense(this.getDefense() + 5);
                this.setMaxHealth(this.getMaxHealth() + 10);
                this.setHealth(this.getHealth() + 20);
                this.setLevel(this.getLevel() + 1);
                break;
            case "Warrior":
                this.setAttack(this.getAttack() + 5);
                this.setDefense(this.getDefense() + 2);
                this.setMaxHealth(this.getMaxHealth() + 5);
                this.setHealth(this.getHealth() + 20);
                this.setLevel(this.getLevel() + 1);
                break;
            case "Scout":
                this.setAttack(this.getAttack() + 5);
                this.setDefense(this.getDefense() + 10);
                this.setMaxHealth(this.getMaxHealth() + 5);
                this.setHealth(this.getHealth() + 20);
                this.setLevel(this.getLevel() + 1);
                break;
        }
        this.setExperience(0);
    }
    public void heal(Integer healAmount){
        if(this.getHealth() + healAmount < this.getMaxHealth()){
            this.setHealth(this.getHealth() + healAmount);
        }
        else{
            this.setHealth(this.getMaxHealth());
        }
    }

    public void trainLutemon(){
        Integer trainingDamage = 0;
        Random rand = new Random();
        Integer randomNumber = rand.nextInt(11);
        if(randomNumber >= 10){
            trainingDamage = 4;
        } else if (randomNumber >= 6) {
            trainingDamage = 3;
        } else if (randomNumber >= 3) {
            trainingDamage = 2;
        }else if (randomNumber >= 1) {
            trainingDamage = 1;
        }else if (randomNumber == 0) {
            trainingDamage = 0;
        }
        this.setHealth(this.getHealth() - trainingDamage);
        this.setExperience(this.getExperience() + 1);
    }


    public int defense(int damage){
        Random random = new Random();
        double randomValue = 0.5 + (0.5 - 0.1) * random.nextDouble();
        System.out.println(damage + " " + getDefense());
        int DMG = (int)(damage*1.5) - (int)(getFloatDefence() *  randomValue);

        if( DMG > 0){
            this.setHealth(getHealth() - DMG);
        }else{
            DMG = 0;
        }
        return DMG;
    }
    public int attack(){
        return this.attack;
    }

    public static Comparator<Lutemon> AttackComparator = new Comparator<Lutemon>() {
        @Override
        public int compare(Lutemon p1, Lutemon p2) {
            return p1.getAttack().compareTo(p2.getAttack());
        }
    };

    public static Comparator<Lutemon> HPComparator = new Comparator<Lutemon>() {
        @Override
        public int compare(Lutemon p1, Lutemon p2) {
            return p1.getMaxHealth().compareTo(p2.getMaxHealth());
        }
    };

    public static Comparator<Lutemon> WinsComparator = new Comparator<Lutemon>() {
        @Override
        public int compare(Lutemon p1, Lutemon p2) {
            return p1.getWins().compareTo(p2.getWins());
        }
    };

}
