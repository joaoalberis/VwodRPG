package com.rpgjam.screens;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.inputs.Selection;
import com.rpgjam.story.Avalon;
import com.rpgjam.story.Blefuscu;
import com.rpgjam.story.Nublar;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Screen {
  private Boolean selected = false;
  private Scanner input = new Scanner(System.in);
  private Selection selection = new Selection();
  public Character character;
  private Shop shop;
  private boolean adventureContinue = false;

  public void menu() {
    while (!selected) {
      Console.clearConsole();
      Console.printGreen(Color.BOLD + " ___      ___ ___       __   ________  ________     \r\n" + //
          "|\\  \\    /  /|\\  \\     |\\  \\|\\   __  \\|\\   ___ \\    \r\n" + //
          "\\ \\  \\  /  / | \\  \\    \\ \\  \\ \\  \\|\\  \\ \\  \\_|\\ \\   \r\n" + //
          " \\ \\  \\/  / / \\ \\  \\  __\\ \\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\  \r\n" + //
          "  \\ \\    / /   \\ \\  \\|\\__\\_\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\ \r\n" + //
          "   \\ \\__/ /     \\ \\____________\\ \\_______\\ \\_______\\\r\n" + //
          "    \\|__|/       \\|____________|\\|_______|\\|_______|\r\n");
      Console.printGreen("****************************************");
      Console.printGreen("*             " + Color.BOLD + "MENU PRINCIPAL" + "           *");
      Console.printGreen("****************************************");
      Console.printGreen("*            1. Novo Jogo              *");
      Console.printGreen("*            2. Tutorial               *");
      Console.printGreen("*            3. Créditos               *");
      Console.printGreen("*            4. Sair                   *");
      Console.printGreen("****************************************\n");

      String option = input.nextLine();
      switch (option) {
        case "1":
          newGame();
          selected = true;
          break;
        case "2":
          Tutorial.displayTutorial();
          selected = true;
          break;
        case "3":
          Credits.displayCredits();
          selected = true;
          break;
        case "4":
          System.exit(1);
          break;
        default:
          Console.printRed("Escolha entre as opções sugeridas: 1, 2, 3 ou 4.");
          Console.clearConsole();
          continue;
      }
    }
  }

  public void menuAction() {
    Console.clearConsole();
    while (!selected) {
      if (!adventureContinue){
        Console.printCyan(
            "Selecione uma ação:\n1. Iniciar uma nova aventura\n2. Visitar a loja\n3. Verificar seu status\n4. Verificar seu inventário\n5. Voltar");
        int option = input.nextInt();
        switch (option) {
          case 1:
            adventure();
            return;
          case 2:
            shop.openShop();
            return;
          case 3:
            status();
            return;
          case 4:
            inventory();
            return;
          case 5:
            menu();
            return;
          default:
            Console.printRed("Escolha entre as opções sugeridas: 1, 2, 3, 4 ou 5.");
            continue;
        }
      }else {
        Console.printCyan(
            "Selecione uma ação:\n1. Continuar aventura\n2. Visitar a loja\n3. Verificar seu status\n4. Verificar seu inventário\n5. Voltar");
        int option = input.nextInt();
        switch (option) {
          case 1:
            return;
          case 2:
            shop.openShop();
            return;
          case 3:
            status();
            return;
          case 4:
            inventory();
            return;
          case 5:
            menu();
            return;
          default:
            Console.printRed("Escolha entre as opções sugeridas: 1, 2, 3, 4 ou 5.");
            continue;
        }
      }
    }
  }

  public void adventure() {
    Nublar islandOne = new Nublar(character);
    Avalon islandTwo = new Avalon(character);
    Blefuscu islandThree = new Blefuscu(character);
    adventureContinue = islandOne.start();
    menuAction();
    adventureContinue = islandTwo.start();
    menuAction();
    adventureContinue = islandThree.start();
  }

  public void status() {
    Console.clearConsole();
    Console.dialogf("%s Seus status atuais são:", Color.BOLD);
    Console.dialogf("Nivel - %d", character.getNivel());
    Console.dialogf("Experiencia Atual - %.2f", character.getExperiencia());
    Console.dialogf("Arma Atual - %s", character.getNameWeapon());
    Console.dialogf("Dano da Arma - %.1f", character.getDamageWeapon());
    Console.dialogf("Ataque - %.2f", character.getAtack());
    Console.dialogf("Defesa - %.2f", character.getDefense());
    Console.dialogf("Vida - %.2f/%.2f", character.getHealth(), character.getMaxHealth());
    Console.dialogf("Gold - %.2f", character.getGold());
    String[] options = { "Você retornou ao menu principal" };
    selection.newSelection(1, options, "1- Voltar");
    menuAction();
  }

  public void inventory() {
    Console.clearConsole();
    character.showInventory();
    String[] options = { "Você retornou ao menu principal" };
    selection.newSelection(1, options, "1- Voltar");
    menuAction();
  }

  public void newGame() {
    String[] options = {
        "Espadachim",
        "Atirador",
        "Guerreiro",
    };
    Console.clearConsole();
    Console.dialog("\nVold: Olá jovem pirata, me chamo vold vejo que decidiu se aventurar pelos mares de viwod.");
    Console.dialog("- Qual seria o nome do jovem pirata?");
    String nick = input.nextLine();
    Console.clearConsole();

    Console.dialogf("\nVold: Fico feliz em lhe conhecer %s%s%s", Color.RED, Color.BOLD, nick);
    Console.dialog(
        "- Agora preciso que você decida entre 3 estilos de luta, escolha sabiamente, pois seu estilo irá lhe acompanhar por toda sua navegação pirata.\n");

    String classe = selection.newSelection(4,
        options, "1. Espadachim\n2. Atirador\n3. Guerreiro\n");
    Console.clearConsole();
    Console.dialogf("- Perfeito %s, Você irá aprender e lutará que nem um %s. Mas preciso que você me diga qual será o nome de seu bando pirata: ", Color.RED + Color.BOLD + nick + Color.RESET + Color.GREEN, Color.CYAN + Color.BOLD + classe + Color.RESET + Color.GREEN);

    String bevy = input.nextLine();

    character = new Character(classe, nick, bevy);
    Console.clearConsole();
    Console.dialogf(
        "\nVold: %s, Agora que você é um %s está apto para enfrentar os desafios do mar de viwod, mas tome cuidado, pois pode dar de cara com uma tripulação mais forte. Desejo sorte em sua navegação e que encontre bons companheiro para o seu bando dos %s\n",
        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN, Color.CYAN + Color.BOLD + character.getClasse() + Color.RESET + Color.GREEN, Color.RED + Color.BOLD + character.getBevy());
    shop = new Shop(this);
    menuAction();
  }
}