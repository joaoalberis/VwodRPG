package com.rpgjam.battle;

import com.rpgjam.Character;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class BattleSystem {
  private static Selection selection = new Selection();

  public static BattleResult startBattle(Character player, Enemy enemy) {
    Console.dialogf("Um %s selvagem apareceu!\n", enemy.getName());

    while (player.isAlive() && enemy.isAlive()) {
      displayBattleStatus(player, enemy);

      String action = getPlayerAction();

      processPlayerAction(action, player, enemy);

      if (enemy.isAlive())
        enemyAttack(player, enemy);
    }

    if (player.isAlive()) {
      Console.dialog("\nVocê venceu a batalha!");
      return BattleResult.VICTORY;
    } else {
      Console.dialog("\nVocê foi derrotado. Mais sorte na próxima vez!");
      return BattleResult.DEFEAT;
    }
  }

  private static void displayBattleStatus(Character player, Enemy enemy) {
    Console.printCyan(" ***************************");
    Console.dialogf("* %s%s%s - %s | %s%s%s - %s *",
        Color.RED, player.getNickname(), Color.RESET, player.getHealth(),
        Color.RED, enemy.getName(), Color.RESET, enemy.getHealth());
    Console.printCyan(" ***************************\n");

  }

  private static String getPlayerAction() {
    String[] options = {
        "Atacar",
        "Item",
        "Fugir",
    };

    String option = selection.newSelection(3,
        options, "Escolha sua ação:\n1. Atacar\n2. Usar Item\n3. Fugir");

    return option;
  }

  private static void processPlayerAction(String action, Character player, Enemy enemy) {
    switch (action) {
      case "Atacar":
        playerAttack(player, enemy);
        break;
      case "Item":
        useItem(player);
        break;
      case "Fugir":
        attemptEscape();
        break;
      default:
        Console.dialog("Ação inválida. Tente novamente.");
        break;
    }
  }
  
  

  /*
  private static void useItem(Character player) {
    
    switch (items) {
      case POCAO_DE_CURA:
        double health = (player.getHealth() * 0.5);
        player.addHealth(health);
        break;
      case POCAO_DE_ATAQUE:
        double damage = (player.getAtack() * 0.75);
        player.addAttack(damage);
        break;
      case POCAO_DE_DEFESA:
        double defense = (player.getDefense() * 0.45);
        player.addDefense(defense);
        break;
    }

  }
  */
  private static void playerAttack(Character player, Enemy enemy) {
    double damageDealt = player.getAtack();
    enemy.takeDamage(damageDealt);
    Console.dialogf("Você ataca o %s e causa %.1f de dano!\n", enemy.getName(), damageDealt);
  }

  private static void enemyAttack(Character player, Enemy enemy) {
    double damageDealt = enemy.getDamage();
    player.takeDamage(damageDealt);
    Console.dialogf("O %s ataca você e causa %.1f de dano!\n", enemy.getName(), damageDealt);
  }

  private static void attemptEscape() {
    boolean escaped = Math.random() < 0.5;

    if (escaped) {
      Console.dialog("Você conseguiu escapar da batalha!");
    } else {
      Console.dialog("Você não conseguiu escapar desta vez!");
    }
  }

}