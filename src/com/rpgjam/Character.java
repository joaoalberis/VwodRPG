package com.rpgjam;
import java.util.HashMap;
import java.util.Map;

public class Character {
    private String Classe;
    private String Nickname;
    private int Nivel;
    private Double Experiencia;
    private Double Health;
    private Double Defense;
    private Double Atack;
    private Double Gold;
    private Map<String, Integer> Inventory;

    public Character(String classe, String nickname) {
        this.Classe = classe;
        this.Nickname = nickname;
        this.Nivel = 1;
        this.Experiencia = 0.0;
        this.Health = 10.0;
        this.Defense = 5.0;
        this.Atack = 8.0;
        this.Gold = 50.0;
        this.Inventory = new HashMap<String, Integer>() {{
            put("poção de cura", 0);
            put("poção de ataque", 0);
            put("poção de defesa", 0);
        }};
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
        this.Experiencia = this.Experiencia + experience;
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
}
