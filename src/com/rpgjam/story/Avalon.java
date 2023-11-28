package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Avalon {
    private Character character;
    private Scanner input = new Scanner(System.in);

    public Avalon(Character character) {
        this.character = character;
    }

    public boolean start() {
        Console.clearConsole();
        Console.sleep(1000);
        Console.narrator("- Você está navegando já algum tempo com seu novo companheiro Oroz, quando de repete um passaro lhe pega e leva você e lhe joga em uma ilha");
        Console.narrator("- Oroz então rema o mais rapido possivel para perseguir o passaro e tentar lhe ajudar\n");
        Console.narrator("*Oroz percebeu que você foi deixado numa ilha, então vai até a ilha*\n");
        Console.sleep(10000);
        BoatAnimation.boatTrasition(10);
        Console.clearConsole();
        Console.narrator("- Ao cair, Você cai em cima de um pirata e por acidente acaba salvando uma jovem moça que estava sendo ameaçada!");
        Console.narrator("- A jovem moça se assusta e lhe pede ajuda, você decidi formar uma breve aliança com ela, então você a ajuda!\n");
        Console.dialogf("\n%s: Porque eles tão atras de você, aliais, como você se chama?\n",
                Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
        Console.dialogf(Color.PURPLE +
                "Iman%s: Me chamo Iman, eles são piratas e estão tentando roubar meu dinheiro!.\n",
                Color.RESET);
        Console.narrator(
                "- Ápos ajuda-la você fica andando pela ilha com ela.\n");
        Console.narrator(
                "*Após algum tempo andando pela ilha*\n");
        Console.narrator(
                "- Um tempo se passou e ela pediu para você esperar ela em um local, você foi até ele, porém ao chegar la você foi capturado por uma tripulação de piratas.\n");
        Console.narrator("*Sua aliada lhe traiu, agora você está preso dentro de uma gaiola, onde tentaram mata-lo a qualquer momento");
        Console.narrator("* Pediram que a sua aliada lhe matasse para mostrar sua lealdade ao bando, ela não consegue e com isso tem que lutar contra eles, felizmente zoro aparece a tempo de salva-la e vocês escapam!*");
        Console.narrator("- Vocês se abrigam em uma casa para poder recuperar os ferimentos de Oroz, mas 2 dos tripulantes deles consiguiram achar vocês.");
        Console.sleep(15000);
        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Eichir", 30, 5, 50, 15),
                input);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                System.out.println(randomGold);
                Console.narrator("Você esperou ele lhe atacar e desviou, fazendo com que o animal de estimação do inimigo caisse na água!");
                Console.narrator(
                        "Acabou deixando cair um pouco de ouro no mar."
                                + gold + " golds");
                character.removeGold(gold);
            } else
                Console.narrator("Você conseguiu derrotar o animal de estimação do inimigo, agora ele está furioso!");
            Console.sleep(3000);
            Console.clearConsole();
            Console.narrator(
                    "- Agora o Dono está furioso, se prepare para proxima luta.\n");
            Console.sleep(5000);
            Console.clearConsole();
            battleResult = BattleSystem.startBattle(character, new Enemy("Ijom", 55, 8, 70, 35), input);
            if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                if (battleResult == BattleResult.ESCAPE) {
                    int randomGold = (int) (Math.random() * 15) + 1;
                    double gold = character.getGold() * (randomGold / 100.0);
                    System.out.println(randomGold);
                    Console.narrator("Você foge com sua aliada e seu companheiro!");
                    Console.narrator(
                            "Enquanto você fugia acabou deixando cair um pouco de ouro."
                                    + gold + " golds");
                    character.removeGold(gold);
                } else
                    Console.narrator(Color.GREEN + "Você conseguiu derrota-lo, agora tudo está mais calmo.");

                Console.narrator(
                        "- O dono da casa decidi ir enfrentar a tripulação pirata, pois ele é o responsavel por aquela ilha.");
                Console.narrator("*Você tenta convencer ele*\n");
                Console.dialogf("%s: Não vá, eles são fortes e em grande quantidade, você sozinho não vai conseguir impedi-los!\n",
                        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                Console.dialog("Eldoob: Não importa, eu tenho que reconquistar a minha ilha, pelos cidadões que aqui moram.\n");
                Console.dialogf(
                        "%s: Já que você nos ajudou, então como forma de agradecimento irei obter a vigança por você, afinal ele machucou um membro da minha tripulação!",
                        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                Console.dialog("Oroz: Eu também irei capitão, você não irá conseguir lutar com 2 ao mesmo tempo, eu fico com o espadachim e você cuida do capitão deles!\n");
                Console.dialogf(
                        "%s: Certo!\n",
                        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                Console.dialog("*Vocês decidem ir até eles para lutar*");
                Console.dialog("- Oroz começa a lutar contra o espadachim da tripulação inimiga!");
                Console.dialog("Oroz: Você até que é forte, qual é o seu nome, Gosto de saber o nome dos oponentes que derroto!");
                Console.enemy("Me chamo Ijabac, Você tambem não é fraco, mas irá perder para mim!");
                Console.dialog("*Zoro fica lutando contra o Ijabac, enquanto você vai lutar contra o capitão deles");
                Console.sleep(10000);
                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Yggub", 70, 12, 100, 50),
                        input);
                if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                    if (battleResult == BattleResult.ESCAPE) {
                        int randomGold = (int) (Math.random() * 15) + 1;
                        double gold = character.getGold() * (randomGold / 100.0);
                        System.out.println(randomGold);
                        Console.narrator("Você não conseguiu se vingar e teve que fugir!");
                        Console.narrator(
                                "Enquanto você fugia acabou deixando cair um pouco de ouro."
                                        + gold + " golds");
                        character.removeGold(gold);
                    } else
                        Console.narrator(Color.GREEN
                                + "- Você conseguiu sua vigança, Oroz já ta quase acabando sua luta tambem!");
                    Console.narrator(
                            "Oroz: esse será meu ultimo ataque, se você aguenta-lo será o vitorioso, mas duvido que consiga.\n");
                    Console.enemy(
                            "Ijabac: Então tambem irei atacar com força total em um ultimo golpe, iremos resolver essa batalha agora.\n");
                    Console.narrator(
                            "*Oroz defere seu ultimo golpe, assim conseguindo sair vitorioso de sua batalha");
                    Console.dialogf(
                            "%s: Agora que consiguimos derrota-los oque vamos fazer?\n",
                            Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                    Console.dialog("Oroz: Acho melhor descansarmos um pouco antes de navegar novamente!");
                    Console.dialog("Iman: Esqueci de falar, mas eu sou uma navegadora");
                    Console.dialog("- Enquanto eles conversavam, os cidadões da ilha culpam " + character.getBevy() + " Pela destruição da ilha, mas Elboob os ajudam a fugir em 2 botes!\n");
                    Console.dialog("Parabéns por concluir mais uma parte de sua aventura, se prepare para proxima, não esqueça de comprar suprimentos na loja!");
                    Console.sleep(6000);
                    Console.clearConsole();
                    return true;
                } else {
                    Console.narrator("O " + character.getNickname()
                            + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA TRIPULAÇÃO DO YGGUB!)");
                    Console.sleep(3000);
                    return false;
                }
            } else {
                Console.narrator("O " + character.getNickname()
                        + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA TRIPULAÇÃO DO YGGUB!)");
                Console.sleep(3000);
                return false;
            }
        } else {
            Console.narrator("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA TRIPULAÇÃO DO YGGUB!)");
            Console.sleep(3000);
            return false;
        }
    }
}
