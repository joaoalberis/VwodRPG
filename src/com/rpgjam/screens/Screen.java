package com.rpgjam.screens;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Screen {
  private Boolean selected = false;
  private Scanner input = new Scanner(System.in);
  private Selection selection = new Selection();
  public Character character;

  public void menu() {
    while (!selected) {
      Console.clearConsole();
      Console.printGreen(" ___      ___ ___       __   ________  ________     \r\n" + //
          "|\\  \\    /  /|\\  \\     |\\  \\|\\   __  \\|\\   ___ \\    \r\n" + //
          "\\ \\  \\  /  / | \\  \\    \\ \\  \\ \\  \\|\\  \\ \\  \\_|\\ \\   \r\n" + //
          " \\ \\  \\/  / / \\ \\  \\  __\\ \\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\  \r\n" + //
          "  \\ \\    / /   \\ \\  \\|\\__\\_\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\ \r\n" + //
          "   \\ \\__/ /     \\ \\____________\\ \\_______\\ \\_______\\\r\n" + //
          "    \\|__|/       \\|____________|\\|_______|\\|_______|\r\n");
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
      Console.printPurple("Selecione uma ação:\n1. Iniciar uma nova aventura\n2. Visitar a loja\n3. Verificar seu status\n4. Verificar seu inventário\n5. Voltar");
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
    }
  }

  public void adventure() {
    Console.dialog("\nVocê começa sua jornada em Viwod, uma terra cheia de mistérios e perigos.");
    Console.dialog("Enquanto caminha pela floresta, você encontra um grupo de goblins furiosos!");
    
    // Luta contra os goblins
    BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Goblin", 10, 5));
    
    // BattleResult battleResult = BattleResult.VICTORY; 

    if (battleResult == BattleResult.VICTORY) {
        Console.dialog("Você derrotou os goblins com sucesso!");
        Console.dialog("Em recompensa, você encontra uma antiga entrada para uma masmorra.");
        Console.dialog("Deseja entrar na masmorra?");

        boolean enterDungeon = selection.newSelection(2, new String[]{"Sim", "Não"}, "1. Sim\n2. Não").equals("Sim");

        if (enterDungeon) {
            Console.dialog("Você entra na masmorra escura, cheia de corredores sombrios e armadilhas mortais.");
            Console.dialog("Após explorar por um tempo, você encontra um baú trancado.");
            
            // Escolher método para abrir o baú
            String[] chestOptions = {"Força", "Magia", "Destreza"};
            String chosenMethod = selection.newSelection(3, chestOptions,
                    "Escolha um método para abrir o baú:\n1. Força\n2. Magia\n3. Destreza");

            switch (chosenMethod) {
                case "Força":
                    Console.dialog("Você usa toda a sua força para abrir o baú e encontra uma espada mágica!");
                    // character.equipWeapon(new Weapon("Espada Mágica", 15));
                    break;
                case "Magia":
                    Console.dialog("Você canaliza seus poderes mágicos para destrancar o baú e encontra um cajado poderoso!");
                    // character.equipWeapon(new Weapon("Cajado Poderoso", 12));
                    break;
                case "Destreza":
                    Console.dialog("Com habilidade e destreza, você desarma a armadilha no baú e encontra um arco incrível!");
                    // character.equipWeapon(new Weapon("Arco Incrível", 10));
                    break;
            }

            Console.dialog("Com seu novo equipamento, você decide continuar explorando a masmorra.");

            // Mais eventos da masmorra...

            Console.dialog("Após enfrentar vários desafios, você finalmente alcança o fim da masmorra e encontra um portal mágico.");
            Console.dialog("O portal parece levar a um lugar desconhecido. O que você deseja fazer?");
            
            String[] portalOptions = {"Entrar no portal", "Ficar em Viwod"};
            String portalDecision = selection.newSelection(2, portalOptions,
                    "Deseja entrar no portal e explorar um novo mundo, ou prefere ficar em Viwod?");

            if (portalDecision.equals("Entrar no portal")) {
                Console.dialog("Você decide entrar no portal, ansioso por novas aventuras em terras desconhecidas.");
                // Continuação para uma nova jornada ou finalização do jogo...
            } else {
                Console.dialog("Você opta por ficar em Viwod, explorando mais desafios nesta terra mágica.");
                // Continuação para explorar Viwod...
            }
        } else {
            Console.dialog("Você decide não entrar na masmorra e continua explorando Viwod.");
            // Mais eventos em Viwod...
        }
    } else {
        Console.dialog("O " + character.getClasse() + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO GLOBIN)");
        Console.sleep(3000);
        menu(); // Volta ao menu principal
    }
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
      if (optionSelect.contains("poção de cura") && character.getGold() >= 25){
        character.addItemInvetory("Poção de Cura", 1);
        character.removeGold(25.0);
      }else if(optionSelect.contains("poção de ataque") && character.getGold() >= 40){
        character.addItemInvetory("Poção de Ataque", 1);
        character.removeGold(25.0);
      }else if(optionSelect.contains("poção de defesa") && character.getGold() >= 35){
        character.addItemInvetory("Poção de Defesa", 1);
        character.removeGold(25.0);
      }else if(optionSelect.contains("sair")){
        Console.clearConsole();
        menuAction();
      }else {
        Console.printRed("Você não tem gold suficiente para essa compra!\nQuantidade de gold atual: " + character.getGold());
      }
    } while (!optionSelect.contains("sair"));
  }

  public void status(){
    Console.printGreen("Seus status atuais são:\nNivel - " + character.getNivel() + "\nExperiencia Atual - " + character.getExperiencia() + "\nAtaque - " + character.getAtack() + "\nDefesa - " + character.getDefense() + "Vida - " + character.getHealth() + "\nGold - " + character.getGold());
    String[] options = {"Você retornou ao menu principal"};
    selection.newSelection(1, options, "1- Voltar");
    menuAction();
  }

  public void inventory(){
    character.showInventory();
    String[] options = {"Você retornou ao menu principal"};
    selection.newSelection(1, options, "1- Voltar");
    menuAction();
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

    character = new Character(classe, nick);
    Console.clearConsole();
    Console.dialogf(
        "\nVold: %s, Agora que você é um %s está apto para enfrentar os desafios de viwod, mas tome cuidado, pois pode dar de cara com um monstro forte.\n",
        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.YELLOW, character.getClasse());
    menuAction();
  }
}