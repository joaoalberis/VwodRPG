package com.rpgjam.screens;

import java.util.ArrayList;
import java.util.Arrays;

import com.rpgjam.Character;
import com.rpgjam.Weapon.Atirador.Pistola;
import com.rpgjam.Weapon.Atirador.PistolaDupla;
import com.rpgjam.Weapon.Atirador.Rifle;
import com.rpgjam.Weapon.Espadachim.LaminaAmaldiçoada;
import com.rpgjam.Weapon.Espadachim.LaminaFamosa;
import com.rpgjam.Weapon.Espadachim.LaminaNegra;
import com.rpgjam.Weapon.Guerreiro.GarraDaPantera;
import com.rpgjam.Weapon.Guerreiro.MaoDoDesespero;
import com.rpgjam.Weapon.Guerreiro.Soqueira;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Shop {
  private Selection selection = new Selection();
  private Screen screen;
  private Character character;

  public Shop(Screen screen) {
    this.screen = screen;
    this.character = this.screen.character;
  }

  public void openShop() {
    Console.clearConsole();
    String classes = character.getClasse();
    ArrayList<String> options = new ArrayList<>(Arrays.asList(
      "Você selecionou uma poção de cura",
      "Você selecionou uma poção de defesa",
      "Você selecionou uma poção de ataque"
    ));

    String optionsText = "+---------------------------------------------+\n" +
        "|               BEM-VINDO À LOJA               |\n" +
        "+---------------------------------------------+\n" +
        "| 1. Poção de Cura (1x)       - 25  Gold       |\n" +
        "| 2. Poção de Defesa(1x)      - 35  Gold       |\n" +
        "| 3. Poção de Ataque (1x)     - 40  Gold       |\n";

    switch (classes) {
      case "Espadachim":
        optionsText += "| 4. Lâmina Amaldiçoada(1x)    - 50  Gold       |\n" +
        "| 5. Lâmina Negra(1x)         - 80  Gold       |\n" +
        "| 6. Lâmina Famosa(1x)        - 120 Gold       |\n" +
        "| 7. Sair                                      |\n" +
        "+---------------------------------------------+\n";
        options.addAll(Arrays.asList("Você selecionou uma Lamina Amaldiçoada",
          "Você selecionou uma Lamina Negra",
          "Você selecionou uma Lamina Famosa"));
        break;
      case "Atirador":
        optionsText += "| 4. Pistola(1x)              - 50  Gold       |\n" +
        "| 5. Pistola Dupla(1x)        - 80  Gold       |\n" +
        "| 6. Rifle(1x)                - 120 Gold       |\n" +
        "| 7. Sair                                      |\n" +
        "+---------------------------------------------+\n";
        options.addAll(Arrays.asList("Você selecionou uma Pistola",
          "Você selecionou uma Pistola Dupla",
          "Você selecionou uma Rifle"));
        break;
      case "Guerreiro":
        optionsText += "| 4. Soqueira(1x)             - 50  Gold       |\n" +
        "| 5. Garra da Pantera(1x)     - 80  Gold       |\n" +
        "| 6. Mão do Desespero(1x)     - 120 Gold       |\n" +
        "| 7. Sair                                      |\n" +
        "+---------------------------------------------+\n";
        options.addAll(Arrays.asList("Você selecionou uma Soqueira",
          "Você selecionou uma Garra da Pantera",
          "Você selecionou uma Mão do Desespero"));
        break;
      default:
        break;
    }
    options.add("Você selecionou sair da loja");
    String optionSelect;
    do {
      optionSelect = selection.newSelection(7, options, Color.RED + optionsText + Color.RESET);
      if (optionSelect.contains("poção de cura") && character.getGold() >= 25) {
        character.addItemInvetory("Poção de Cura", 1);
        character.removeGold(25.0);
      } else if (optionSelect.contains("poção de ataque") && character.getGold() >= 40) {
        character.addItemInvetory("Poção de Ataque", 1);
        character.removeGold(40.0);
      } else if (optionSelect.contains("poção de defesa") && character.getGold() >= 35) {
        character.addItemInvetory("Poção de Defesa", 1);
        character.removeGold(35.0);
      } else if (optionSelect.contains("Lamina Amaldiçoada") && character.getGold() >= 50) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new LaminaAmaldiçoada(), 50.0));
      else if(optionSelect.contains("Lamina Negra") && character.getGold() >= 80) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new LaminaNegra(), 80.0));
      else if(optionSelect.contains("Lamina Famosa") && character.getGold() >= 120) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new LaminaFamosa(), 120.0));
      else if (optionSelect.contains("Pistola") && character.getGold() >= 50) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new Pistola(), 50.0));
      else if(optionSelect.contains("Pistola Dupla") && character.getGold() >= 80) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new PistolaDupla(), 80.0));
      else if(optionSelect.contains("Rifle") && character.getGold() >= 120) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new Rifle(), 120.0));
      else if (optionSelect.contains("Soqueira") && character.getGold() >= 50) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new Soqueira(), 50.0));
      else if(optionSelect.contains("Guarra de Pantera") && character.getGold() >= 80) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new GarraDaPantera(), 80.0));
      else if(optionSelect.contains("Mão do Desespero") && character.getGold() >= 120) Console.printGreen(character.changeWeapon(character.getDamageWeapon(), new MaoDoDesespero(), 120.0));
      else {
        Console.printRed(
            "Você não tem gold suficiente para essa compra!\nQuantidade de gold atual: " + character.getGold());
      }
    } while (!optionSelect.contains("sair"));
    Console.clearConsole();
    screen.menuAction();
  }
}