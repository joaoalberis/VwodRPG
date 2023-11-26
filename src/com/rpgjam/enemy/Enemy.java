package com.rpgjam.enemy;

public class Enemy {
  private String name;
  private double health;
  private double damage;
  private double experience;
  private double gold;

  public Enemy(String name, double health, double damage, double experience, double gold) {
    this.name = name;
    this.health = health;
    this.damage = damage;
    this.experience = experience;
    this.gold = gold;
  }

  public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public void takeDamage(double damage) {
      health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setHealth(double health) {
      this.health = health;
    }

    public void setDamage(double damage) {
      this.damage = damage;
    }

    public double getExperience() {
      return this.experience;
    }

    public void setExperience(double experience) {
      this.experience = experience;
    }

    public double getGold() {
      return this.gold;
    }

    public void setGold(double gold) {
      this.gold = gold;
    }
}