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
    private Double Experiencia;
    private Double Health;
    private Double maxHealth;
    private Double Defense;
    private Double Atack;
    private Double Gold;
    private Map<String, Integer> Inventory;
    private Double requiredExperience;

    

    public Character(String classe, String nickname, String bevy) {
        this.Classe = classe;
        this.Nickname = nickname;
        this.bevy = bevy;
        this.Nivel = 1;
        this.Experiencia = 0.0;
        verifiedClasse(classe);
        this.Gold = 50.0;
        this.Inventory = new HashMap<String, Integer>() {{
            put("Poção de Cura", 0);
            put("Poção de Ataque", 0);
            put("Poção de Defesa", 0);
        }};
        this.requiredExperience = 50.0;
    }

    public void changeWeapon(Weapon newWeapon){
        this.weapon = newWeapon;
    }

    private void verifiedClasse(String classe){
        if (classe == "Atirador"){
            this.setHealth(25.0);;
            this.setMaxHealth(25.0);
            this.setAtack(8.5);
            this.setDefense(5.0);
            this.changeWeapon(new RustyGun());
        }else if (classe == "Espadachim"){
            this.setHealth(23.0);
            this.setMaxHealth(23.0);
            this.setAtack(10.0);
            this.setDefense(5.5);
            this.changeWeapon(new OldSword());
        }else if (classe == "Guerreiro"){
            this.setHealth(25.0);
            this.setMaxHealth(25.0);
            this.setAtack(8.0);
            this.setDefense(6.0);
            this.changeWeapon(new Handle());
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
    public Double getExperiencia() {
        return this.Experiencia;
    }
    public void setExperiencia(Double experiencia) {
        this.Experiencia = experiencia;
    }
    public Double getHealth() {
        return this.Health;
    }
    public void setHealth(Double health) {
        this.Health = health;
    }
    public Double getDefense() {
        return this.Defense;
    }
    public void setDefense(Double defense) {
        this.Defense = defense;
    }
    public Double getAtack() {
        return this.Atack;
    }
    public void setAtack(Double atack) {
        this.Atack = atack;
    }
    public Double getGold() {
        return this.Gold;
    }
    public void setGold(Double gold) {
        this.Gold = gold;
    }
    
    public void showInventory() {
        System.out.println("Inventario:");
        if (this.Inventory.isEmpty()){
            Console.printRed("Inventario não contém item");
            return;
        }
        for(Map.Entry<String, Integer> entry : this.Inventory.entrySet()){
            System.out.println(entry.getValue() + "x " + entry.getKey());
        }
    }
    public void addItemInvetory(String item, Integer quantity){
        this.Inventory.put(item, Inventory.getOrDefault(item, 0) + quantity);
    }
    public void removeItemInventory(String item, Integer quantity){
        this.Inventory.put(item, Inventory.getOrDefault(item, 0) - quantity);
    }

    public boolean isAlive() {
        return this.Health > 0;
    }

    public void takeDamage(Double damage) {
        this.Health -= damage;
    }

    public void addExperience(Double experience) {
        this.Experiencia += experience;
        while (this.Experiencia >= this.requiredExperience){
            upLevel();
        }
    }

    public void addGold(Double gold){
        this.Gold = this.Gold + gold;
    }

    public void removeGold(Double gold){
        this.Gold = this.Gold - gold;
    }

    public void addHealth(Double health){
        this.Health = this.Health + health;
    }

    public void addAttack(Double attack){
        this.Atack = this.Atack + attack;
    }

    public void addDefense(Double defense){
        this.Defense = this.Defense + defense;
    }
   
    public Map<String, Integer> getInventory() {
        return this.Inventory;
    }
    public void setInventory(Map<String, Integer> inventory) {
        this.Inventory = inventory;
    }

    private  void upLevel(){
        this.Nivel++;
        this.Experiencia -= this.requiredExperience;
        this.requiredExperience *= 1.3;
        this.Health = this.maxHealth * 1.5;
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
    public Double getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(Double maxHealth) {
        this.maxHealth = maxHealth;
    }
    public Double getRequiredExperience() {
        return requiredExperience;
    }
    public void setRequiredExperience(Double requiredExperience) {
        this.requiredExperience = requiredExperience;
    }
}
