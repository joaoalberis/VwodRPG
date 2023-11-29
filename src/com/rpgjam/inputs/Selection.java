package com.rpgjam.inputs;

import java.util.ArrayList;
import java.util.Scanner;

import com.rpgjam.utils.Console;

public class Selection {
  private Scanner input;

  public Selection() {
    input = new Scanner(System.in);
  }

  public String newSelection(int options, String[] optionsMessage, String message) {
    Console.printBlue(message);
    int optionSelect = input.nextInt();
    for (int i = 0; i <= options - 1; i++) {
      if (i == optionSelect - 1) {
        Console.printBlue(optionsMessage[i]);
        return optionsMessage[i];
      }
      if (i == options - 1) {
        Console.clearConsole();
        Console.printRed("\nSelecione uma ação valida!");
        Console.printPurple(message);
        i = -1;
        optionSelect = input.nextInt();
      }
    }
    return "";
  }

  public String newSelection(int options, ArrayList<String> optionsMessage, String message) {
    System.out.println(message);
    int optionSelect = input.nextInt();
    for (int i = 0; i <= options - 1; i++) {
      if (i == optionSelect - 1) {
        Console.printBlue(optionsMessage.get(i));
        return optionsMessage.get(i);
      }
      if (i == options - 1) {
        Console.clearConsole();
        Console.printRed("\nSelecione um valor válido!");
        Console.printPurple(message);
        i = 0;
        optionSelect = input.nextInt();
      }
    }
    return "";
  }

  public String newSelection(String optionsMessage, String message) {
    Console.printBlue(message);
    int optionSelect = input.nextInt();
    while (optionSelect != 1) {
      Console.clearConsole();
      Console.printRed("\nSelecione um valor válido!");
      Console.printPurple(message);
      optionSelect = input.nextInt();

    }
    Console.printGreen(optionsMessage);
    return optionsMessage;
  }
}