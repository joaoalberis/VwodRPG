package com.rpgjam.screens;

import com.rpgjam.Character;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Epilogue {
    
    public static void epilogue(Character character) {
        Console.printYellowsf(" ______       ___                   \n" );
        Console.printYellowsf("|  ____|     /_/ |                  \n");
        Console.printYellowsf("| |__   _ __  _| | ___   __ _  ___  \n");
        Console.printYellowsf("|  __| | '_ \\| | |/ _ \\ / _` |/ _ \\ \n");
        Console.printYellowsf("| |____| |_) | | | (_) | (_| | (_) |\n");
        Console.printYellowsf("|______| .__/|_|_|\\___/ \\__, |\\___/ \n");
        Console.printYellowsf("       | |               __/ |      \n");
        Console.printYellowsf("       |_|              |___/       \n\n\n");
        String[] titulos = {
            character.getNickname() + " - Capitão Destemido",
            "Liz - A Ágil Navegadora",
            "Oklama - O Forte e Corajoso"
        };

        String[] storyEpilogue = {
            "Após a conquista do tesouro na Ilha de Ouroboros, " + character.getNickname() + " decidiu estabelecer-se como um comerciante respeitado. Sua habilidade em liderança e tomada de decisões sagazes transformou seu nome em sinônimo de sucesso nos sete mares.",
            "Liz seguiu sua paixão pela exploração, tornando-se uma cartógrafa renomada. Suas mapas detalhados e conhecimento das águas desconhecidas abriram novas rotas para os aventureiros que buscavam desbravar o desconhecido.",
            "Oklama encontrou seu propósito em treinar uma nova geração de lutadores. Sua força e coragem inspiraram jovens a se unirem à sua academia. Formando uma academia de renome em todos os mares."
        };

        for(int i = 0; i < titulos.length; i++){
            Console.narrator(Color.BLUE + "                   --- " + titulos[i] + " ---\n");
            Console.narrator(Color.BLACK + storyEpilogue[i] + "\n\n");
        }
        Console.narrator("[Narrador Final]: E assim, a tripulação do " + character.getBevy() + " seguiu caminhos diferentes, independente disso continuaram amigos e em contato constante. Suas histórias deixaram uma marca no mundo dos piratas. Suas aventuras inspiraram outras gerações a levantarem velas e explorarem o desconhecido, na busca por tesouros, fama e, acima de tudo, pela emoção da jornada. E assim, o universo vasto e misterioso de Vwood continuou a acolher novas histórias de coragem e determinação. O que o futuro reserva para aqueles corajosos o suficiente para enfrentar os mares desconhecidos? Isso, somente o tempo dirá.");
    return;
  }
}
