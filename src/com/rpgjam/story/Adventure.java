package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
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
        Console.dialog("- Enquanto caminha pela floresta, você encontra um grupo de goblins furiosos!");

        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Goblin", 10, 5, 150, 10), input);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                System.out.println(randomGold);
                System.out.println(
                        "Enquanto você fugia do monstro acabou deixando cair uma bolsa de gold. Você deixou para traz "
                                + gold + " golds");
                character.removeGold(gold);
            } else
                Console.dialog(Color.GREEN + "Você derrotou os goblins com sucesso!");

            Console.dialog("\nVocê encontra uma antiga entrada para uma masmorra.");
            Console.dialog("Deseja entrar na masmorra?");

            boolean enterDungeon = selection.newSelection(2, new String[] { "Sim", "Não" }, "1. Sim\n2. Não")
                    .equals("Sim");

            if (enterDungeon) {
                Console.clearConsole();
                Console.dialog("Você entra na masmorra escura, cheia de corredores sombrios e armadilhas mortais.");
                Console.dialog("- Após explorar por um tempo, você encontra um baú trancado.");

                // Escolher método para abrir o baú
                String[] chestOptions = { "Força", "Magia", "Destreza" };
                String chosenMethod = selection.newSelection(3, chestOptions,
                        "\nEscolha um método para abrir o baú:\n1. Força\n2. Magia\n3. Destreza");
                Console.clearConsole();
                switch (chosenMethod) {
                    case "Força":
                        Console.dialogf("Você usa toda a sua força para abrir o baú e encontra uma %sPoção de Ataque\n",
                                Console.RED);
                        break;
                    case "Magia":
                        Console.dialogf(
                                "Você canaliza seus poderes mágicos para destrancar o baú e encontra uma %sPoção de Cura!\n",
                                Console.RED);
                        break;
                    case "Destreza":
                        Console.dialogf(
                                "Com habilidade e destreza, você desarma a armadilha no baú e encontra uma %sPoção de Defesa!\n",
                                Console.RED);
                        break;
                }

                dungeonStory();

            } else {
                Console.dialog("Você decide não entrar na masmorra e continua explorando Vwod.");
                exploreViwod();
            }
        } else {
            Console.dialog("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO GLOBIN)");
            Console.sleep(3000);

        }
    }

    public void dungeonStory() {
        Console.dialog("Com sua nova poção, você decide continuar explorando a masmorra.");

        Console.dialog("- Você encontra um corredor misterioso com várias portas.");
        Console.dialog(Color.BLUE + "\nDeseja abrir uma das portas?");
        boolean openDoor = selection.newSelection(2, new String[] { "Sim", "Não" }, "1. Sim\n2. Não").equals("Sim");

        if (openDoor) {
            Console.clearConsole();
            Console.dialog("Você escolhe uma porta e a abre lentamente.");

            int randomEnemyChance = (int) (Math.random() * 100) + 1;
            if (randomEnemyChance <= 60) {
                Console.dialog("Ao abrir a porta, você se depara com um grupo de esqueletos hostis!");

                BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Esqueleto", 15, 7, 200, 15),
                        input);

                if (battleResult == BattleResult.VICTORY) {
                    Console.dialog("Você derrotou os esqueletos e continua explorando a masmorra.");
                } else {
                    Console.dialog("Infelizmente, os esqueletos foram demais para você. Sua jornada acaba aqui!");
                    Console.sleep(3000);
                    return;
                }
            } else {
                Console.dialog("\nA porta leva a uma sala vazia. Parece que você teve sorte desta vez.");
            }
        }

        Console.dialog(
                "Após explorar ainda mais a masmorra, você encontra um altar misterioso com inscrições antigas.\n");
        Console.dialog(Color.GREEN + "Deseja interagir com o altar?");

        boolean interactWithAltar = selection.newSelection(2, new String[] { "Sim", "Não" }, "1. Sim\n2. Não")
                .equals("Sim");

        if (interactWithAltar) {
            Console.clearConsole();
            Console.dialog("Você se aproxima do altar e sente uma energia mágica pulsante.");
            Console.dialog(
                    "- Dentre as inscrições, você identifica uma opção para conceder poder mágico ou obter conhecimento.");

            String[] altarOptions = { "Conceder Poder Mágico", "Obter Conhecimento" };
            String chosenAltarOption = selection.newSelection(2, altarOptions,
                    "Escolha uma opção:\n1. Conceder Poder Mágico\n2. Obter Conhecimento");

            switch (chosenAltarOption) {
                case "Conceder Poder Mágico":
                    Console.dialog("Você decide conceder mais poder mágico a si mesmo.");
                    double magicPower = Math.random() * 10 + 5; // Gerar um valor aleatório entre 5 e 15
                    character.addAttack(magicPower);
                    Console.dialogf("Você ganhou %.1f pontos de ataque! Agora seu ataque é mais poderoso.", magicPower);
                    break;
                case "Obter Conhecimento":
                    Console.dialog("Você busca conhecimento nas inscrições antigas.");
                    double experienceGain = Math.random() * 50 + 20; // Gerar um valor aleatório entre 20 e 70
                    character.addExperience(experienceGain);
                    Console.dialogf("Você ganhou %.1f pontos de experiência! Agora está mais experiente.",
                            experienceGain);
                    break;
            }
        } else {
            exploreViwod();
        }
    }

    public void exploreViwod() {
        Console.clearConsole();
        Console.dialog("Enquanto explora as terras de Vwod, você se depara com diversas paisagens e criaturas.");

        // Aqui você pode adicionar eventos aleatórios, escolhas do jogador, etc.
        int randomEvent = (int) (Math.random() * 3) + 1;

        switch (randomEvent) {
            case 1:
                Console.dialog("Você encontra uma cidade movimentada, cheia de comerciantes e aventureiros.");
                // Possíveis interações na cidade...
                break;
            case 2:
                Console.dialog("Uma criatura misteriosa aparece no seu caminho. O que você deseja fazer?");
                boolean confrontCreature = selection.newSelection(2, new String[] { "Confrontar", "Evitar" },
                        "1. Confrontar\n2. Evitar").equals("Confrontar");
                Console.clearConsole();
                if (confrontCreature) {
                    Console.dialog("Você decide confrontar a criatura!");

                    BattleResult battleResult = BattleSystem.startBattle(character,
                            new Enemy("Criatura Misteriosa", 12, 6, 180, 12),
                            input);

                    if (battleResult == BattleResult.VICTORY) {
                        Console.dialog("Você derrotou a criatura misteriosa e continua sua exploração.");
                    } else {
                        Console.dialog("A criatura misteriosa foi muito forte. Sua jornada acaba aqui!");
                        Console.sleep(3000);
                        return;
                    }
                } else {
                    Console.dialog("Você opta por evitar a criatura misteriosa e continua sua exploração.");
                }
                break;
            case 3:
                Console.dialog("Você encontra um mercador ambulante. Ele oferece uma troca de itens.");

                // Lógica para interagir com o mercador e trocar itens...

                break;
        }

        Console.dialog("Você prossegue em sua jornada por Viwod, curioso sobre o que o destino reserva.");
    }

}