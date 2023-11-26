package com.rpgjam.inputs;

import java.util.Scanner;

import com.rpgjam.utils.Console;


public class Selection {
  private Scanner input;

  public Selection() {
    input = new Scanner(System.in);
  }

  public String newSelection(int options, String[] optionsMessage, String message) {
    System.out.println(message);
    int optionSelect = input.nextInt();
    for(int i = 0; i <= options - 1; i++) {
      if (i == optionSelect){
        Console.printGreen(optionsMessage[i]);
        return optionsMessage[i];
      }
      if(i == options) {
        Console.printRed("\nSelecione um valor válido!");
        Console.printPurple(message);
        i = 0;
        optionSelect = input.nextInt();
      }
    }
    Console.clearConsole();
    input.close();
    return "";
  }
}