package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Console;

public class Adventure {
    private Selection selection = new Selection();
    private Character character;
    private Scanner input;

    public Adventure(Character character) {
        this.character = character;
        input = new Scanner(System.in);
    }

    public void startStory() {
        Console.clearConsole();
        Console.sleep(50);
        Console.dialog("Você começa sua jornada em Vwod, uma terra cheia de mistérios e perigos.");
        Console.dialog("Enquanto caminha pela floresta, você encontra um grupo de goblins furiosos!");

        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Goblin", 10, 5, 10, 10), input);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                Double gold = character.getGold() * (randomGold / 100);
                System.out.println(randomGold);
                System.out.println(randomGold / 100);
                System.out.println(
                        "Enquanto você fugia do monstro acabou deixando cair uma bolsa de gold, você deixou para traz "
                                + gold + " golds");
                character.removeGold(gold);
            } else
                Console.dialog("Você derrotou os goblins com sucesso!");

            Console.dialog("Você encontra uma antiga entrada para uma masmorra.");
            Console.dialog("Deseja entrar na masmorra?");

            boolean enterDungeon = selection.newSelection(2, new String[] { "Sim", "Não" }, "1. Sim\n2. Não")
                    .equals("Sim");

            if (enterDungeon) {
                Console.dialog("Você entra na masmorra escura, cheia de corredores sombrios e armadilhas mortais.");
                Console.dialog("Após explorar por um tempo, você encontra um baú trancado.");

                // Escolher método para abrir o baú
                String[] chestOptions = { "Força", "Magia", "Destreza" };
                String chosenMethod = selection.newSelection(3, chestOptions,
                        "Escolha um método para abrir o baú:\n1. Força\n2. Magia\n3. Destreza");

                switch (chosenMethod) {
                    case "Força":
                        Console.dialogf("Você usa toda a sua força para abrir o baú e encontra uma %sPoção de Ataque",
                                Console.RED);
                        break;
                    case "Magia":
                        Console.dialogf(
                                "Você canaliza seus poderes mágicos para destrancar o baú e encontra uma %sPoção de Cura!", Console.RED);
                        break;
                    case "Destreza":
                        Console.dialogf(
                                "Com habilidade e destreza, você desarma a armadilha no baú e encontra uma %sPoção de Defesa!", Console.RED);
                        break;
                }

                Console.dialog("Com sua nova poção, você decide continuar explorando a masmorra.");

                // Mais eventos da masmorra...

                Console.dialog(
                        "Após enfrentar vários desafios, você finalmente alcança o fim da masmorra e encontra um portal mágico.");
                Console.dialog("O portal parece levar a um lugar desconhecido. O que você deseja fazer?");

                String[] portalOptions = { "Entrar no portal", "Ficar em Viwod" };
                String portalDecision = selection.newSelection(2, portalOptions,
                        "Deseja entrar no portal e explorar um novo mundo, ou prefere ficar em Viwod?");

                if (portalDecision.equals("Entrar no portal")) {
                    Console.dialog(
                            "Você decide entrar no portal, ansioso por novas aventuras em terras desconhecidas.");
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
            Console.dialog("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO GLOBIN)");
            Console.sleep(3000);

        }
    }
}