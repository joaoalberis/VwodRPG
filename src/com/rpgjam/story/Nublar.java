package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.inputs.Selection;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Nublar {
    private Selection selection = new Selection();
    private Character character;
    private Scanner input;

    public Nublar(Character character) {
        this.character = character;
        input = new Scanner(System.in);
    }

    public boolean startIsland1(){
        Console.clearConsole();
        Console.sleep(50);
        Console.dialog("Você começa sua navegação em vwod, um mar cheio de desafios e inimigos perigosos");
        Console.dialog("- Você começa a navegar com um pequeno bote sem rumo até que avista uma ilha chamada "+ (Color.CYAN + "Nublar " + Color.YELLOW )  + "e então decidi atracar seu bote!");
        Console.dialog("- Ao atracar seu bote, você percebe que está acontecendo uma confusão perto da marinha, então decidi ir ver de fininho e encontra uma pessoa acorretanda.");
        Console.dialog("*12 Horas se passam*");
        Console.dialog("-A noite chegou e você decidi entrar na prisão com cuidado para conversar com o prisioneiro de mais cedo!");
        Console.dialogf("%s: Porque você esta preso aqui?", Color.RED + Color.BOLD + character.getNickname() + Color.YELLOW);
        Console.dialog("Prisioneiro: Não lhe interessa o porque estou preso aqui, mas irei sair caso consiga ficar alguns dias sem comer");
        Console.dialog("- Um tempo se passa e você descobre que iram matar o prisoneiro mesmo que ele cumpra com sua parte.");
        Console.dialog("- Você vai até ele para avisar, após você contar é feito um acordo, onde você o ajudaria a pegar suas armas que foram confiscadas e ele se tornaria um membro do seu bando de piratas.");
        Console.dialog("- Você recupera as armas, mas ao chegar para entregar varios marinheiros já estavam la para matar o prisioneiro, então vocês 2 unem forças para derrota-los");
        
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Guardas da Marinha", 20, 5, 20, 10), input);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                System.out.println(randomGold);
                System.out.println(
                        "Enquanto você fugia acabou deixando cair um pouco de ouro."
                                + gold + " golds");
                character.removeGold(gold);
            } else
                Console.dialog(Color.GREEN + "Você derrotou os guardas que iriam executar o prisioneiro com sucesso!");

            Console.dialog("Finalmente conseguiu achar o primeiro tripulante para o seu bando, mas nem tudo acabou ");
            Console.dialogf("%s: Agora somos companheiros, qual seria o seu nome caro companheiro?", Color.RED + Color.BOLD + character.getNickname() + Color.YELLOW);
            Console.dialog("Remer: Me chamo remer prazer em conhece-lo, em que tipo de navio iremos navegar? ");
            Console.dialog("- Enquanto voces conversavam mais marinheiro chegaram.");
            Console.dialog("- Vocẽs correram para a costa, mas no caminho tinha varios marinheiros mais poderosos que os anteriores");
            battleResult = BattleSystem.startBattle(character, new Enemy("Guardas da Marinha 2", 35, 8, 30, 20), input);
            if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                if (battleResult == BattleResult.ESCAPE) {
                    int randomGold = (int) (Math.random() * 15) + 1;
                    double gold = character.getGold() * (randomGold / 100.0);
                    System.out.println(randomGold);
                    System.out.println(
                            "Enquanto você fugia acabou deixando cair um pouco de ouro."
                                    + gold + " golds");
                    character.removeGold(gold);
                } else
                    Console.dialog(Color.GREEN + "Vocês consiguiram derrotar os guardas que estavam no caminho!");

                Console.dialog("- Todos os guardas foram derrotados, porem esperando no pequeno bote estava o capitão da marinha.");
                Console.dialog("- Você tenta conversar com o capitão da marinha!");
                Console.dialogf("%s: Porque esta tentando nos impedir?", Color.RED + Color.BOLD + character.getNickname() + Color.YELLOW);
                Console.dialog("Capitão da Marinha: Você entra na minha prisão e solta um dos meus prisioneiros e ainda pergunta porque estamos estamos perseguindo vocês?");
                Console.dialogf("%s: Apenas o libertei, porque vocês tinham um trato com ele e não iriam o cumprir, iriam mata-lo mesmo apos o tempo definido.", Color.RED + Color.BOLD + character.getNickname() + Color.YELLOW);
                Console.dialog("Remer: Exatamente, deixe a gente passar ou então teremos que lutar");
                Console.dialog("Capitão da Marinha: Entendo, então terei que leva-los a força e executa-los para que sejam tratados como exemplo e isso nunca volte a ocorrer");
                battleResult = BattleSystem.startBattle(character, new Enemy("Capitão da Marinha", 50, 12, 50, 10), input);
                if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                    if (battleResult == BattleResult.ESCAPE) {
                        int randomGold = (int) (Math.random() * 15) + 1;
                        double gold = character.getGold() * (randomGold / 100.0);
                        System.out.println(randomGold);
                        System.out.println(
                                "Enquanto você fugia acabou deixando cair um pouco de ouro."
                                        + gold + " golds");
                        character.removeGold(gold);
                    } else
                        Console.dialog(Color.GREEN + "Vocês consiguiram derrotar o Capitação da Marinha que impedia vocês de fugirem!");
                    Console.dialog("- Agora que não tem mais ninguem no caminho, vocês decidem navegar em busca de novas aventuras!");
                    Console.dialog("Remer: Pensei que tinhamos um barco grande para navegação, mas é apenas um bote, onde eu fui me meter. Temos quantos membros na tripulação ao menos?");
                    Console.dialogf("%s: Contando comigo você é o segundo, mas não se preocupe, pois iremos montar a melhor tripulação e seremos o mais fortes de todos os mares!", Color.RED + Color.BOLD + character.getNickname() + Color.YELLOW);
                    Console.dialog("Com isso a primeira ilha foi finalizada com sucesso, e sua tripulação seguirá para proxima ilha.");
                    return true;
                }else {
                    Console.dialog("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA MARINHA!)");
                    Console.sleep(3000);
                    return false;
                }
            }else {
                Console.dialog("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA MARINHA!)");
                Console.sleep(3000);
                return false;
            }
        }else {
            Console.dialog("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA MARINHA!)");
            Console.sleep(3000);
            return false;
        }
    }
}
