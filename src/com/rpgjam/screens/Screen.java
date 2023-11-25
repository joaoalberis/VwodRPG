package com.rpgjam.screens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.inputs.Selection;

public class Screen {
    private Boolean selected = false;
    private Scanner input = new Scanner(System.in);
    private Game game;
    private Selection selection = new Selection();

  public void menu() {
    String newGame = "Novo Jogo";
    String tutorial = "Tutorial";
    String credits = "Creditos";


    while (selected == false) {
      System.err.printf("%s - (1)\n%s - (2)\n%s - (3)\n", newGame, tutorial, credits);
      String option = input.nextLine();
      switch (option) {
        case "1":
          newGame();
          selected = true;
          break;
        case "2":
          System.out.println("\nEscolheu tutorial.\n");
          selected = true;
          break;
        case "3":
          System.out.println("\nEscolheu créditos.\n");
          selected = true;
          break;
        default:
          System.out.println("\nEscolha entre as opções sugeridas: 1, 2 ou 3.\n");
          continue;
      }
    }
  }

  public void menuAction(){
    while(true){
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

  public void adventure(){

  }

  public void shop(){
    System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------+\n" + //
        "| ____        _         ____                    __     ___           _          __     _   _                       _          _       |\n" + //
        "|/ ___|  ___ (_) __ _  | __ )  ___ _ __ ___     \\ \\   / (_)_ __   __| | ___     \\_\\_  | \\ | | ___  ___ ___  __ _  | |    ___ (_) __ _ |\n" + //
        "|\\___ \\ / _ \\| |/ _` | |  _ \\ / _ \\ '_ ` _ \\ ____\\ \\ / /| | '_ \\ / _` |/ _ \\   / _` | |  \\| |/ _ \\/ __/ __|/ _` | | |   / _ \\| |/ _` ||\n" + //
        "| ___) |  __/| | (_| | | |_) |  __/ | | | | |_____\\ V / | | | | | (_| | (_) | | (_| | | |\\  | (_) \\__ \\__ \\ (_| | | |__| (_) | | (_| ||\n" + //
        "||____/ \\___|/ |\\__,_| |____/ \\___|_| |_| |_|      \\_/  |_|_| |_|\\__,_|\\___/   \\__,_| |_| \\_|\\___/|___/___/\\__,_| |_____\\___// |\\__,_||\n" + //
        "|          |__/                                                                                                            |__/       |\n" + //
        "+-------------------------------------------------------------------------------------------------------------------------------------+");
      
        String[] options = {
          "Você selecionou uma poção de cura", "Você selecionou uma arma de iniciante", "Você selecionou uma arma intermediaria", "Você selecionou uma arma avançada", "Você selecionou uma poção de ataque"
        };


        selection.newSelection(6, options, "1- Poção de Cura(1x) - 20 Gold\n2- Arma Iniciante(1x) - 30 Gold\n3- Arma Intermediaria(1x) - 60 Gold\n4- Arma Avançada(1x) - 100 Gold\n5- Arma Suprema(1x) - 150 Gold\n6- Porção de Ataque(1x) - 25 Gold");
    }

  public void newGame() {
    System.out.println("Olá Jovem Aventureiro, Me Chamo vold vejo que decidiu se aventurar pelas terras de viwod,\n Qual seria o nome do jovem aventureiro?");
    String nick = input.nextLine();
    System.out.println("Fico feliz em lhe conhecer " + nick + ". Agora preciso que você decida entre 4 classes, escolha sabiamente, pois essa classe não poderá ser mudada em nenhum momento de sua aventura.");
    
    String[] options = {
          "Guerreiro.", "Mago.", "Assasino.", "Arqueiro."
    };
    String classe = selection.newSelection(4, options, "1- Guerreiro\n2- Mago\n3- Assasino\n4- Arqueiro");
    
    Character character = new Character(classe, nick);
    System.out.printf("%s, Agora que você é um %s está apto para enfrentar os desafios de viwod, mas tome cuidado, pois pode dar de cara com um monstro forte.", character.getNickname(), character.getClasse());

    menuAction();
  }
}