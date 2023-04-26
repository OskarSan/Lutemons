package com.example.lutemons;

import java.io.Serializable;

public class Lutemon implements Serializable {

    protected String name, color, species;
    protected Integer attack, defense, experience, health, maxHealth, wins, losses;

    public Lutemon(String name, String color, String species,Integer attack, Integer defense, Integer experience, Integer health, Integer maxHealth, Integer wins, Integer losses){
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
    }

    public String getName() {return name;}

    public String getColor() {return color;}

    public String getSpecies() {return species;}

    public Integer getAttack() {return attack;}

    public Integer getDefense() {return defense;}

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

    public void setLosses(Integer losses) {this.losses = losses;}
    //Todo levelUp metodi

    //Todo heal metodi
    public void defense(int damage){
        System.out.println(damage + " " + getDefense());
        this.setHealth(getHealth() - (damage - getDefense()));
    }
    public int attack(){
        return this.attack;
    }
}
