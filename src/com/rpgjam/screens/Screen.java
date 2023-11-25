package com.rpgjam.screens;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;

public class Screen {
  private Boolean selected = false;
  private Scanner input = new Scanner(System.in);
  private Selection selection = new Selection();

  public void menu() {
    while (!selected) {
      clearConsole();
      System.out.println("***************************");
      System.out.println("*       MENU PRINCIPAL     *");
      System.out.println("***************************");
      System.out.println("*  1. Novo Jogo           *");
      System.out.println("*  2. Tutorial            *");
      System.out.println("*  3. Créditos            *");
      System.out.println("*  4. Sair                *");
      System.out.println("***************************");

      String option = input.nextLine();
      switch (option) {
        case "1":
          newGame();
          selected = true;
          break;
        case "2":
          Color.printBold("Escolheu tutorial.");
          selected = true;
          break;
        case "3":
          Color.printPurple("Escolheu tutorial.");
          selected = true;
          break;
        case "4":
          System.exit(1);
          break;
        default:
          System.out.println("\u001B[31mEscolha entre as opções sugeridas: 1, 2 ou 3.\u001B[0m");
          clearConsole();
          continue;
      }
    }
  }

  public void menuAction() {
    while (true) {
      System.out.println("Selecione uma ação:\n1-Aventura\n2-Shop\n3-Ver Status\n4-Ver Inventario");
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
        default:
          System.out.println("Selecione um valor válido!");
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
        "+---------------------------------------------+";

    selection.newSelection(6, options, optionsText);

    // selection.newSelection(6, options,
    // "1- Poção de Cura(1x) - 20 Gold\n2- Arma Iniciante(1x) - 30 Gold\n3- Arma
    // Intermediaria(1x) - 60 Gold\n4- Arma Avançada(1x) - 100 Gold\n5- Arma
    // Suprema(1x) - 150 Gold\n6- Porção de Ataque(1x) - 25 Gold");
  }

  public void newGame() {
    System.out.println(
        "Olá Jovem Aventureiro, Me Chamo vold vejo que decidiu se aventurar pelas terras de viwod,\n Qual seria o nome do jovem aventureiro?");
    String nick = input.nextLine();
    System.out.println("Fico feliz em lhe conhecer " + nick
        + ". Agora preciso que você decida entre 4 classes, escolha sabiamente, pois essa classe não poderá ser mudada em nenhum momento de sua aventura.");

    String[] options = {
        "Guerreiro.", "Mago.", "Assasino.", "Arqueiro."
    };
    String classe = selection.newSelection(4, options, "1- Guerreiro\n2- Mago\n3- Assasino\n4- Arqueiro");

    Character character = new Character(classe, nick);
    System.out.printf(
        "%s, Agora que você é um %s está apto para enfrentar os desafios de viwod, mas tome cuidado, pois pode dar de cara com um monstro forte.",
        character.getNickname(), character.getClasse());

    menuAction();
  }

  private void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}