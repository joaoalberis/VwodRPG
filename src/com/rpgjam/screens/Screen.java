package com.rpgjam.screens;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Screen {
  private Boolean selected = false;
  private Scanner input = new Scanner(System.in);
  private Selection selection = new Selection();

  public void menu() {
    while (!selected) {
      Console.clearConsole();
      Console.printGreen("***************************");
      Console.printGreen("*       " + Color.BOLD + "MENU PRINCIPAL" + "     *");
      Console.printGreen("***************************");
      Console.printGreen("*  1. Novo Jogo           *");
      Console.printGreen("*  2. Tutorial            *");
      Console.printGreen("*  3. Créditos            *");
      Console.printGreen("*  4. Sair                *");
      Console.printGreen("***************************\n");

      String option = input.nextLine();
      switch (option) {
        case "1":
          newGame();
          selected = true;
          break;
        case "2":
          Console.printBold("Escolheu tutorial.");
          selected = true;
          break;
        case "3":
          Console.printPurple("Escolheu tutorial.");
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
    while (!selected) {
      Console.printPurple("Selecione uma ação:\n1. Aventura\n2. Loja\n3. Ver Status\n4. Ver Inventario\n5. Voltar");
      int option = input.nextInt();
      switch (option) {
        case 1:
          adventure();
          return;
        case 2:
          shop();
          return;
        case 3:
          return;
        case 4:
          return;
        case 5:
        return;
        default:
          Console.printRed("Escolha entre as opções sugeridas: 1, 2, 3, 4 ou 5.");
          continue;
      }
    }
  }

  public void adventure() {

  }

  public void shop() {
    String[] options = {
        "Você selecionou uma poção de cura",
        "Você selecionou uma arma de iniciante",
        "Você selecionou uma arma intermediaria",
        "Você selecionou uma arma avançada",
        "Você selecionou uma poção de ataque"
    };

    String optionsText = "+---------------------------------------------+\n" +
        "|               BEM-VINDO À LOJA               |\n" +
        "+---------------------------------------------+\n" +
        "| 1. Poção de Cura (1x)       - 20  Gold       |\n" +
        "| 2. Arma Iniciante (1x)      - 30  Gold       |\n" +
        "| 3. Arma Intermediária (1x)  - 60  Gold       |\n" +
        "| 4. Arma Avançada (1x)       - 100 Gold       |\n" +
        "| 5. Arma Suprema (1x)        - 150 Gold       |\n" +
        "| 6. Poção de Ataque (1x)     - 25  Gold       |\n" +
        "+---------------------------------------------+\n";
    Console.clearConsole();
    selection.newSelection(6, options, Color.RED + optionsText + Color.RESET);

    // selection.newSelection(6, options,
    // "1- Poção de Cura(1x) - 20 Gold\n2- Arma Iniciante(1x) - 30 Gold\n3- Arma
    // Intermediaria(1x) - 60 Gold\n4- Arma Avançada(1x) - 100 Gold\n5- Arma
    // Suprema(1x) - 150 Gold\n6- Porção de Ataque(1x) - 25 Gold");
  }

  public void newGame() {
    String[] options = {
        "Guerreiro.",
        "Mago.",
        "Assasino.",
        "Arqueiro."
    };
    Console.clearConsole();
    Console.dialog("\nVold: Olá jovem aventureiro, me chamo vold vejo que decidiu se aventurar pelas terras de viwod.");
    Console.dialog("- Qual seria o nome do jovem aventureiro?\n");
    String nick = input.nextLine();
    Console.clearConsole();

    Console.dialogf("\nVold: Fico feliz em lhe conhecer %s%s%s", Color.RED, Color.BOLD, nick);
    Console.dialog(
        "- Agora preciso que você decida entre 4 classes, escolha sabiamente, pois essa classe não poderá ser mudada em nenhum momento de sua aventura.\n");

    String classe = selection.newSelection(4,
        options, "1. Guerreiro\n2. Mago\n3. Assasino\n4. Arqueiro\n");

    Character character = new Character(classe, nick);
    Console.clearConsole();
    Console.dialogf(
        "\nVold: %s, Agora que você é um %s está apto para enfrentar os desafios de viwod, mas tome cuidado, pois pode dar de cara com um monstro forte.\n",
        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.YELLOW, character.getClasse());
    menuAction();
  }
}