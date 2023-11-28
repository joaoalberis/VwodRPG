package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Nublar {
    private Character character;
    private Scanner input;

    public Nublar(Character character) {
        this.character = character;
        input = new Scanner(System.in);
    }

    public boolean start() {
        Console.clearConsole();
        Console.sleep(1000);
        Console.narrator("Você começa sua navegação em vwod, um mar cheio de desafios e inimigos perigosos");
        Console.narrator("- Você começa a navegar com um pequeno bote sem rumo até que avista uma ilha chamada "
                + (Color.CYAN + "Nublar " + Color.RESET) + "e então decidi atracar seu bote!\n");
        Console.sleep(10000);
        BoatAnimation.boatTrasition(10);
        Console.clearConsole();
        Console.narrator(
                "- Ao atracar seu bote, você percebe que está acontecendo uma confusão perto da marinha, então decidi ir ver de fininho e encontra uma pessoa acorretanda.");
        Console.narrator(Color.WHITE + "\n* 12 Horas se passam *\n");
        Console.narrator(
                "-A noite chegou e você decidi entrar na prisão com cuidado para conversar com o prisioneiro de mais cedo!");
        Console.dialogf("\n%s: Porque você está preso aqui?\n",
                Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
        Console.dialogf(Color.PURPLE +
                "Prisioneiro%s: Não lhe interessa o porquê estou preso aqui, mas irei sair caso eu consiga ficar mais alguns dias sem comer.\n",
                Color.RESET);
        Console.narrator(
                "- Um tempo se passa e você descobre que irão matar o prisoneiro mesmo que ele cumpra com sua parte.");
        Console.narrator(
                "- Você vai até ele para avisar, após contar é feito um acordo. Onde você o ajudaria a pegar suas armas que foram confiscadas e ele se tornaria um membro do seu bando de piratas.\n");
        Console.narrator(
                "- Você recupera as armas, mas ao chegar para entregar, vários marinheiros já estavam lá para matar o prisioneiro, então vocês 2 unem forças para derrota-los.");
        Console.sleep(10000);
        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Guardas da Marinha", 20, 5, 20, 10),
                input);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                System.out.println(randomGold);
                Console.narrator(
                        "Enquanto você fugia acabou deixando cair um pouco de ouro."
                                + gold + " golds");
                character.removeGold(gold);
            } else
                Console.narrator("Você derrotou os guardas que iriam executar o prisioneiro com sucesso!");
            Console.sleep(3000);
            Console.clearConsole();
            Console.narrator(
                    "- Você finalmente conseguiu achar o primeiro tripulante para o seu bando, mas nem tudo acabou\n");
            Console.dialogf("%s: Agora somos companheiros, qual seria o seu nome caro companheiro?",
                    Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
            Console.dialogf(
                    Color.PURPLE
                            + "Oroz%s: Eu me chamo Oroz prazer em conhece-lo, em que tipo de navio iremos navegar? \n",
                    Color.GREEN);
            Console.narrator("- Enquanto voces conversavam mais marinheiro chegaram.");
            Console.narrator(
                    "- Vocẽs correram para a costa, mas no caminho tinha varios marinheiros mais poderosos que os anteriores.");
            Console.sleep(10000);
            Console.clearConsole();
            battleResult = BattleSystem.startBattle(character, new Enemy("Guardas da Marinha 2", 35, 8, 30, 20), input);
            if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                if (battleResult == BattleResult.ESCAPE) {
                    int randomGold = (int) (Math.random() * 15) + 1;
                    double gold = character.getGold() * (randomGold / 100.0);
                    System.out.println(randomGold);
                    Console.narrator(
                            "Enquanto você fugia acabou deixando cair um pouco de ouro."
                                    + gold + " golds");
                    character.removeGold(gold);
                } else
                    Console.narrator(Color.GREEN + "Vocês conseguiram derrotar os guardas que estavam no caminho!");

                Console.narrator(
                        "- Vocês chegam até o bote, porem esperando no pequeno bote estava o capitão da marinha.");
                Console.narrator("- Você tenta conversar com o capitão da marinha!\n");
                Console.dialogf("%s: Porque está tentando nos impedir?\n",
                        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                Console.enemy(
                        "Capitão da Marinha: Você entra na minha prisão e solta um dos meus prisioneiros e ainda pergunta porque estamos perseguindo vocês?\n");
                Console.dialogf(
                        "%s: Eu apenas o libertei. Porque vocês tinham um trato com ele e não o iriam cumprir, e sim mata-lo, mesmo após o tempo definido.",
                        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                Console.dialog("Oroz: Exatamente, deixe a gente passar ou então teremos que lutar\n");
                Console.enemy(
                        "Capitão da Marinha: Entendo, então terei que leva-los a força e executa-los para que sejam tratados como exemplo e isso nunca volte acontecer.");
                Console.sleep(10000);
                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Capitão da Marinha", 50, 12, 50, 10),
                        input);
                if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                    if (battleResult == BattleResult.ESCAPE) {
                        int randomGold = (int) (Math.random() * 15) + 1;
                        double gold = character.getGold() * (randomGold / 100.0);
                        System.out.println(randomGold);
                        Console.narrator(
                                "Enquanto você fugia acabou deixando cair um pouco de ouro."
                                        + gold + " golds");
                        character.removeGold(gold);
                    } else
                        Console.narrator(Color.GREEN
                                + "- Vocês consiguiram derrotar o Capitão da Marinha que impedia vocês de fugirem!");
                    Console.narrator(
                            "- Agora que não tem mais ninguém no caminho, vocês decidem navegar em busca de novas aventuras!\n");
                    Console.dialog(
                            "Oroz: Pensei que tinhamos um barco grande para navegação, mas é apenas um bote, onde eu fui me meter. Temos quantos membros na tripulação ao menos?\n");
                    Console.dialogf(
                            "%s: Contando comigo você é o segundo, mas não se preocupe, pois iremos montar a melhor tripulação e seremos os mais fortes de todos os mares!\n",
                            Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                    Console.narrator(
                            "Com isso a primeira ilha foi finalizada com sucesso, e sua tripulação seguirá para proxima ilha.");
                    Console.sleep(6000);
                    Console.clearConsole();
                    return true;
                } else {
                    Console.narrator("O " + character.getNickname()
                            + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA MARINHA!)");
                    Console.sleep(3000);
                    return false;
                }
            } else {
                Console.narrator("O " + character.getNickname()
                        + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA MARINHA!)");
                Console.sleep(3000);
                return false;
            }
        } else {
            Console.narrator("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA MARINHA!)");
            Console.sleep(3000);
            return false;
        }
    }
}
