package com.rpgjam.inputs;

import java.util.List;
import java.util.Scanner;

import com.rpgjam.screens.Screen;

public class Selection {
  private int options;
  private boolean selected = false;
  private Scanner input;

  public Selection() {
    input = new Scanner(System.in);
  }

  public String newSelection(int options, String[] optionsMessage, String message) {
    System.out.println(message);
    int optionSelect = input.nextInt();
    for(int i = 1; i <= options; i++) {
      if (i == optionSelect){
        System.out.println(optionsMessage[i - 1]);
        return optionsMessage[i - 1];
      }
      if(i == options){
        System.out.println("Selecione um valor válido!");
        System.out.println(message);
        i = 0;
        optionSelect = input.nextInt();
      }
    }
    return "";
  }
  
}