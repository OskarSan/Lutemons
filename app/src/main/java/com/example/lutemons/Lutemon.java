package com.example.lutemons;

public class Lutemon {

    protected String name, color, species;
    protected Integer attack, defense, experience, health, maxHealth, wins, losses, id;

    public Lutemon(String name, String color, String species){
        this.name = name;
        this.color = color;
        this.species = species;
        this.attack = 0;
        this.defense = 0;
        this.experience = 0;
        this.health = 0;
        this.maxHealth = 0;
        this.wins = 0;
        this.losses = 0;
        this.id = 0;
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

    public Integer getId() {return id;}

    public void setAttack(Integer attack) {this.attack = attack;}

    public void setDefense(Integer defense) {this.defense = defense;}

    public void setExperience(Integer experience) {this.experience = experience;}

    public void setHealth(Integer health) {this.health = health;}

    public void setMaxHealth(Integer maxHealth) {this.maxHealth = maxHealth;}

    public void setWins(Integer wins) {this.wins = wins;}

    public void setLosses(Integer losses) {this.losses = losses;}

    public void setId(Integer id) {this.id = id;}
}
