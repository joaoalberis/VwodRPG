package com.rpgjam.battle;

import java.util.Map;
import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class BattleSystem {
  private static Selection selection = new Selection();

  public static BattleResult startBattle(Character player, Enemy enemy, Scanner sc) {
    Console.dialogf("Um %s selvagem apareceu!\n", enemy.getName());

    while (player.isAlive() && enemy.isAlive()) {
      displayBattleStatus(player, enemy);

      String action = getPlayerAction();
      if (action.equalsIgnoreCase("item")) {
        while (!processPlayerAction(action, player, enemy, sc)) {
          action = getPlayerAction();
        }
      } else if (action.equalsIgnoreCase("fugir")) {
        return BattleResult.ESCAPE;
      } else {
        processPlayerAction(action, player, enemy, sc);
      }

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
    Console.printCyan(" ****************************");
    Console.dialogf("* %s%s%s - %s | %s%s%s - %s *",
        Color.RED, player.getNickname(), Color.RESET, player.getHealth(),
        Color.RED, enemy.getName(), Color.RESET, enemy.getHealth());
    Console.printCyan(" ****************************\n");

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

  private static boolean processPlayerAction(String action, Character player, Enemy enemy, Scanner sc) {
    switch (action) {
      case "Atacar":
        playerAttack(player, enemy);
        break;
      case "Item":
        return useItem(player, sc);
      case "Fugir":
        return attemptEscape();
      default:
        Console.dialog("Ação inválida. Tente novamente.");
        break;
    }
    return false;
  }

  private static boolean useItem(Character player, Scanner sc) {
    Console.clearConsole();
    player.showInventory();

    System.out.println("1. Poção de Defesa, 2. Poção de Cura, 3. Poção de Ataque");

    int itemSelect = sc.nextInt();
    Map<String, Integer> inventory = player.getInventory();

    for (Map.Entry<String, Integer> inv : inventory.entrySet()) {
        String key = inv.getKey();
        Integer value = inv.getValue();

        if (isValidSelection(itemSelect, key, value, player)) {
            applyItemEffects(player, itemSelect, key, value);
            return true;
        }
    }

    Console.dialog("Meu querido, você não tem esse item. Por que quer usar?");
    return false;
}

private static boolean isValidSelection(int itemSelect, String key, int value, Character player) {
    if (key.equalsIgnoreCase("Poção de Defesa") && itemSelect == 1) {
        return value > 0;
    } else if (key.equalsIgnoreCase("Poção de Cura") && itemSelect == 2) {
        return value > 0;
    } else return key.equalsIgnoreCase("Poção de Ataque") && itemSelect == 3 && value > 0;
}

private static void applyItemEffects(Character player, int itemSelect, String key, int value) {

    if (itemSelect == 1) {
        Double newDefense = player.getDefense() * 0.25;
        player.setDefense(newDefense + player.getDefense());
        Console.dialog("Você usou uma Poção de Defesa e fortaleceu temporariamente sua resistência!");
    } else if (itemSelect == 2) {
        Double cura = player.getHealth() * 0.5;
        player.setHealth(player.getHealth() + cura);
        Console.dialog("Você usou uma Poção de Cura e recuperou parte da sua saúde!");
    } else if (itemSelect == 3) {
        Double newAttack = player.getAtack() * 0.2;
        player.setAtack(newAttack + player.getAtack());
        Console.dialog("Você usou uma Poção de Ataque");
    }

    player.removeItemInventory(key, 1);
}

  private static void playerAttack(Character player, Enemy enemy) {
    double damageDealt = player.getAtack();
    enemy.takeDamage(damageDealt);
    Console.dialogf("Você ataca o %s e causa %.1f de dano!\n", enemy.getName(), damageDealt);
  }

  private static void enemyAttack(Character player, Enemy enemy) {
    double damageDealt = enemy.getDamage() - player.getDefense() / 2;
    player.takeDamage(damageDealt);
    Console.dialogf("O %s ataca você e causa %.1f de dano!\n", enemy.getName(), damageDealt);
  }

  private static boolean attemptEscape() {
    boolean escaped = Math.random() < 0.5;

    if (escaped) {
      Console.dialog("Você conseguiu escapar da batalha!");
      return true;
    } else {
      Console.dialog("Você não conseguiu escapar desta vez!");
      return false;
    }
  }

}