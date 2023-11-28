package com.rpgjam.screens;

import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Tutorial {
  private static Selection selection = new Selection();
  private static Screen screen = new Screen();

  public static void displayTutorial() {
    Console.clearConsole();
    Console.printCyan("  _______        .                           .  ");
    Console.printCyan(" '   /    ,   . _/_     __.  .___  `   ___   |  ");
    Console.printCyan("     |    |   |  |    .'   \\ /   \\ |  /   `  |  ");
    Console.printCyan("     |    |   |  |    |    | |   ' | |    |  |  ");
    Console.printCyan("     /    `._/|  \\__/  `._.' /     / `.__/| /\\__");
    Console.printCyan("                                                ");

    Console.narrator(Color.CYAN +
        "Chegou o momento de se aventurar pelo incrível universo de VwodRPG! Sua jornada se inicia nesse mundo intrigante chamado Vwod. Antes de começar essa épica aventura, faça uma escolha inteligente para a sua classe, pois essa decisão será permanente. Ao longo da jornada, você enfrentará decisões cruciais e monstros em um sistema empolgante de jogabilidade por turnos, onde cada escolha é crucial. Ataque, use itens estrategicamente ou arrisque uma fuga calculada.\n\n"
            + "E não se esqueça das recompensas! Ao derrotar um inimigo, você ganhará experiência valiosa (XP) e Gold (Moeda). No entanto, se optar por uma fuga bem-sucedida, continuará na história, mas perderá uma quantia em ouro, além de não ganhar XP. Entre os itens disponíveis, encontram-se a Poção de Cura, que restaura 50% da sua vida total, a Poção de Defesa, que aumenta sua resistência em 25%, e a Poção de Ataque, proporcionando um aumento de 20% no seu poder de ataque. Além da XP, as vitórias também renderão ouro, a moeda essencial para adquirir itens valiosos na loja.\n\n"
            + "Prepare-se para uma jornada emocionante, repleta de desafios, em VwodRPG! 👾✨\n");

    String[] options = { "Voltando para o Menu Principal"};
    String back = selection.newSelection(1, options, "1. Voltar");
    if (back.contains("Voltando para o Menu Principal"))
      screen.menu();
  }

}