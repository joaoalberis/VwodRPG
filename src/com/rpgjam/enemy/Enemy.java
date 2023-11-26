package com.rpgjam.enemy;

public class Enemy {
  private String name;
  private double health;
  private double damage;

  public Enemy(String name, double health, double damage) {
    this.name = name;
    this.health = health;
    this.damage = damage;
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
}