package com.rpgjam.screens;

import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Credits {
  private static Selection selection = new Selection();
  private static Screen screen = new Screen();

  public static void displayCredits() {
    Console.clearConsole();
    Console.printCyan("   ___                    _    .                 ");
    Console.printCyan(" .'   \\ .___    ___    ___/ ` _/_     __.    ____");
    Console.printCyan(" |      /   \\ .'   `  /   | |  |    .'   \\  (    ");
    Console.printCyan(" |      |   ' |----' ,'   | |  |    |    |  `--. ");
    Console.printCyan("  `.__, /     `.___, `___,' /  \\__/  `._.' \\___.");
    Console.printCyan("                          `                       ");
    Console.printCyan(""); 

    Console.printCyan("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    Console.printCyan("*             " + Color.BOLD + "CRÉDITOS" + "                            *");
    Console.printCyan("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    Console.printCyan("*   Gabriel Licar "+ Color.RED + "(Nykoo)"+ Color.CYAN+"                         *");
    Console.printCyan("*   João Alberis "+ Color.RED + "(MrJoão04)"+ Color.CYAN+"                       *");
    Console.printCyan("*   Github: " + Color.UNDERLINE + Color.WHITE + "https://github.com/gabriellicar" + Color.RESET + Color.CYAN + "       *");
    Console.printCyan("*   Github: " + Color.UNDERLINE + Color.WHITE + "https://github.com/joaoalberis" + Color.RESET +Color.CYAN + "        *");
    Console.printCyan("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    String[] options = {"Voltar para o Menu Principal"};
    String back = selection.newSelection(1, options, "1. Voltar");
    if (back.contains("Voltar para o Menu Principal"))
      screen.menu();
  }
}