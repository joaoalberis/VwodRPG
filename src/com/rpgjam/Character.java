package com.rpgjam;

import java.util.HashMap;
import java.util.Map;

import com.rpgjam.Weapon.Handle;
import com.rpgjam.Weapon.OldSword;
import com.rpgjam.Weapon.RustyGun;
import com.rpgjam.Weapon.Weapon;
import com.rpgjam.utils.Console;

public class Character {
    private String Classe;
    private String bevy;
    private String Nickname;
    private Weapon weapon;
    private int Nivel;
    private double Experiencia;
    private double Health;
    private double maxHealth;
    private double Defense;
    private double Atack;
    private double Gold;
    private Map<String, Integer> Inventory;
    private double requiredExperience;

    public Character(String classe, String nickname, String bevy) {
        this.Classe = classe;
        this.Nickname = nickname;
        this.bevy = bevy;
        this.Nivel = 1;
        this.Experiencia = 0.0;
        this.Gold = 50.0;
        verifiedClasse(classe);
        this.Inventory = new HashMap<String, Integer>() {
            {
                put("Poção de Cura", 0);
                put("Poção de Ataque", 0);
                put("Poção de Defesa", 0);
            }
        };
        this.requiredExperience = 50.0;
    }

    public String changeWeapon(double damageOldWeapon, Weapon newWeapon, double valueWeapon) {
        if (damageOldWeapon >= newWeapon.getDamage()) {
            return "Essa arma é inferior ou igual a que você tem com você!";
        }
        this.weapon = newWeapon;
        this.removeGold(valueWeapon);
        return "Parabéns, sua nova arma se chama " + newWeapon.getName() + ". Você está pronto para novos desafios.";
    }

    private void verifiedClasse(String classe) {
        if (classe == "Atirador") {
            this.setHealth(25.0);
            this.setMaxHealth(25.0);
            this.setAtack(8.0);
            this.setDefense(6.0);
            this.changeWeapon(0, new RustyGun(), 0.0);
        } else if (classe == "Espadachim") {
            this.setHealth(23.0);
            this.setMaxHealth(23.0);
            this.setAtack(10.0);
            this.setDefense(5.5);
            this.changeWeapon(0, new OldSword(), 0.0);
        } else if (classe == "Guerreiro") {
            this.setHealth(25.0);
            this.setMaxHealth(25.0);
            this.setAtack(8.5);
            this.setDefense(5.0);
            this.changeWeapon(0, new Handle(), 0.0);
        }
    }

    public double getDamageWeapon() {
        return this.weapon.getDamage();
    }

    public String getNameWeapon() {
        return this.weapon.getName();
    }

    public String getClasse() {
        return this.Classe;
    }

    public void setClasse(String classe) {
        this.Classe = classe;
    }

    public String getNickname() {
        return this.Nickname;
    }

    public void setNickname(String nickname) {
        this.Nickname = nickname;
    }

    public int getNivel() {
        return this.Nivel;
    }

    public void setNivel(int nivel) {
        this.Nivel = nivel;
    }

    public double getExperiencia() {
        return this.Experiencia;
    }

    public void setExperiencia(double experiencia) {
        this.Experiencia = experiencia;
    }

    public double getHealth() {
        return this.Health;
    }

    public void setHealth(double health) {
        this.Health = health;
    }

    public double getDefense() {
        return this.Defense;
    }

    public void setDefense(double defense) {
        this.Defense = defense;
    }

    public double getAtack() {
        return this.Atack;
    }

    public void setAtack(double atack) {
        this.Atack = atack;
    }

    public double getGold() {
        return this.Gold;
    }

    public void setGold(double gold) {
        this.Gold = gold;
    }

    public void showInventory() {
        System.out.println("Inventario:");
        if (this.Inventory.isEmpty()) {
            Console.printRed("Inventario não contém item");
            return;
        }
        for (Map.Entry<String, Integer> entry : this.Inventory.entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey());
        }
    }

    public void addItemInvetory(String item, Integer quantity) {
        this.Inventory.put(item, Inventory.getOrDefault(item, 0) + quantity);
    }

    public void removeItemInventory(String item, Integer quantity) {
        this.Inventory.put(item, Inventory.getOrDefault(item, 0) - quantity);
    }

    public boolean isAlive() {
        return this.Health > 0;
    }

    public void takeDamage(double damage) {
        this.Health -= damage;
    }

    public void addExperience(double experience) {
        this.Experiencia += experience;
        while (this.Experiencia >= this.requiredExperience) {
            upLevel();
        }
    }

    public void addGold(double gold) {
        this.Gold = this.Gold + gold;
    }

    public void removeGold(double gold) {
        this.Gold = this.Gold - gold;
    }

    public void addHealth(double health) {
        this.Health = this.Health + health;
    }

    public void addAttack(double attack) {
        this.Atack = this.Atack + attack;
    }

    public void addDefense(double defense) {
        this.Defense = this.Defense + defense;
    }

    public Map<String, Integer> getInventory() {
        return this.Inventory;
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.Inventory = inventory;
    }

    private void upLevel() {
        this.Nivel++;
        this.Experiencia -= this.requiredExperience;
        this.requiredExperience *= 1.3;
        this.maxHealth = this.maxHealth * 1.35;
        this.Health = this.maxHealth;
        this.Defense *= 1.3;
        this.Atack *= 1.25;
        Console.printGreen("\nParabéns! Você alcançou o nivel " + this.Nivel + "!\nVerifique seus novos status.\n");
    }

    public String getBevy() {
        return bevy;
    }

    public void setBevy(String bevy) {
        this.bevy = bevy;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(double requiredExperience) {
        this.requiredExperience = requiredExperience;
    }
}
