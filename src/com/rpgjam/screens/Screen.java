package com.rpgjam.screens;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.inputs.Selection;
import com.rpgjam.story.Nublar;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Screen {
  private Boolean selected = false;
  private Scanner input = new Scanner(System.in);
  private Selection selection = new Selection();
  public Character character;
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
          tutorial();
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

  public void tutorial() {
    Console.clearConsole();
    Console.printBlue(
        "Chegou o momento de se aventurar pelo incrível universo de VwodRpg! Sua jornada se inicia nesse mundo intrigante chamado Vwod. Antes de começar essa épica aventura, faça uma escolha inteligente para a sua classe, pois essa decisão será permanente. Ao longo da jornada, você enfrentará decisões cruciais e monstros em um sistema empolgante de jogabilidade por turnos, onde cada escolha é crucial. Ataque, use itens estrategicamente ou arrisque uma fuga calculada.\n\nE não se esqueça das recompensas! Ao derrotar um monstro, você ganhará experiência valiosa (XP) e Gold(Moeda). No entanto, se optar por uma fuga bem-sucedida, continuará na história, mas perderá uma quantia em ouro, além de não ganhar XP. Entre os itens disponíveis, encontram-se a Poção de Cura, que restaura 50% da sua vida total, a Poção de Defesa, que aumenta sua resistência em 25%, e a Poção de Ataque, proporcionando um aumento de 20% no seu poder de ataque. Além da XP, as vitórias também renderão ouro, a moeda essencial para adquirir itens valiosos na loja.\n\nPrepare-se para uma jornada emocionante, repleta de desafios, em VwodRpg! 👾✨\n");
    selection.newSelection("Voltando para Pagina inicial", "1- Sair do Tutorial");
    menu();
  }

  public void menuAction() {
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
            shop();
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
            shop();
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
    //Adventure adv = new Adventure(character);
    //adv.startStory();
    Nublar islandOne = new Nublar(character);
    adventureContinue = islandOne.startIsland1();
    menuAction();
  }

  public void shop() {
    String[] options = {
        "Você selecionou uma poção de cura",
        "Você selecionou uma poção de defesa",
        "Você selecionou uma poção de ataque",
        "Você selecionou sair da loja"
    };

    String optionsText = "+---------------------------------------------+\n" +
        "|               BEM-VINDO À LOJA               |\n" +
        "+---------------------------------------------+\n" +
        "| 1. Poção de Cura (1x)       - 25  Gold       |\n" +
        "| 2. Poção de Defesa(1x)      - 35  Gold       |\n" +
        "| 3. Poção de Ataque (1x)     - 40  Gold       |\n" +
        "| 4. Sair                                      |\n" +
        "+---------------------------------------------+\n";
    String optionSelect;
    do {
      optionSelect = selection.newSelection(4, options, Color.RED + optionsText + Color.RESET);
      if (optionSelect.contains("poção de cura") && character.getGold() >= 25) {
        character.addItemInvetory("Poção de Cura", 1);
        character.removeGold(25.0);
      } else if (optionSelect.contains("poção de ataque") && character.getGold() >= 40) {
        character.addItemInvetory("Poção de Ataque", 1);
        character.removeGold(40.0);
      } else if (optionSelect.contains("poção de defesa") && character.getGold() >= 35) {
        character.addItemInvetory("Poção de Defesa", 1);
        character.removeGold(35.0);
      } else if (optionSelect.contains("sair")) {
        Console.clearConsole();
        menuAction();
      } else {
        Console.printRed(
            "Você não tem gold suficiente para essa compra!\nQuantidade de gold atual: " + character.getGold());
      }
    } while (!optionSelect.contains("sair"));
  }

  public void status() {
    Console.dialogf("%s Seus status atuais são:", Color.BOLD);
    Console.dialogf("Nivel - %d", character.getNivel());
    Console.dialogf("Experiencia Atual - %.2f", character.getExperiencia());
    Console.dialogf("Arma Atual - %s", character.getNameWeapon());
    Console.dialogf("Ataque - %.2f", character.getAtack());
    Console.dialogf("Defesa - %.2f", character.getDefense());
    Console.dialogf("Vida - %.2f", character.getHealth());
    Console.dialogf("Gold - %.2f", character.getGold());
    String[] options = { "Você retornou ao menu principal" };
    selection.newSelection(1, options, "1- Voltar");
    menuAction();
  }

  public void inventory() {
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

    Console.dialogf("- Perfeito %s, Você irá aprender e lutará que nem um %s Mas preciso que você diga qual será o nome de seu bando pirata?", Color.RED + Color.BOLD + nick + Color.YELLOW, Color.GREEN + Color.BOLD + classe + Color.YELLOW);

    String bevy = input.nextLine();

    character = new Character(classe, nick, bevy);
    Console.clearConsole();
    Console.dialogf(
        "\nVold: %s, Agora que você é um %s está apto para enfrentar os desafios do mar de viwod, mas tome cuidado, pois pode dar de cara com uma tripulação mais forte. Desejo sorte em sua navegação e que encontre bons companheiro para o seu bando dos %s\n",
        Color.RED + Color.BOLD + character.getNickname() + Color.YELLOW, Color.GREEN + Color.BOLD + character.getClasse() + Color.YELLOW, Color.RED + Color.BOLD + character.getBevy());
    menuAction();
  }
}