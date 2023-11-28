package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.utils.Color;
import com.rpgjam.utils.Console;

public class Blefuscu {
    private Character character;
    private Scanner input = new Scanner(System.in);

    public Blefuscu(Character character) {
        this.character = character;
    }

    public boolean start() {
        Console.clearConsole();
        Console.sleep(1000);
        Console.narrator("- A Navegadora do grupo está conduzindo o barco para a ilha mais proxima chamada Blefuscu");
        Console.narrator("*Após alguns dias navegando em mar aberto, a ilha que estavam a procura é avistada*\n");
        Console.sleep(8000);
        BoatAnimation.boatTrasition(10);
        Console.clearConsole();
        Console.narrator(
                "- Vocês atracam os 2 navios no litoral, mas não esperavam que seriam recebido por um cidadão segurando um estilingue com 3 crianças medrosas para proteger a cidade de piratas!");
        Console.narrator("*Você tenta dialogar com eles.*");
        Console.dialogf("\n%s: Não precisam se assustar não estamos aqui para invadir ou saquear, apenas estamos se aventurando em busca de companheiros! Quais são seus nomes?\n",
                Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
        Console.dialog("Pposu: Me chamo Pposu e essa é minha tripulação não deixarei que entrem nessa ilha!\n");
        Console.dialogf("\n%s: Você me é familiar, acho que conheço o seu pai, ele é da tripulação do Sknahs, seu nome é Pposay?\n",
                Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
        Console.dialog("Pposu: De onde você conhece o meu pai?\n");
        Console.dialogf("\n%s: Seu pai me contava muitas historias quando ele visitava minha ilha, ele falava muito de seu filho! Não viemos para lutar!\n",
                Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
        Console.dialog("Pposu: Se você conhece meu pai você não deve querer fazer mal a essa ilha!\n");
        Console.narrator(
                "*Vocês ficam pela ilha por alguns dias aproveitando e conhecendo a ilha*\n");
        Console.narrator("- Pposu conta para vocês que ele tem uma amiga que mora na masão e ele gosta de contar historias para ela, embora a maioria seja mentira!\n");
        Console.narrator("- Você e Pposu está andando pela colina quando avistam 2 pessoas conversando sobre invadir a ilha, além disso eles falam algo sobre o mordomo da amiga de Pposu, disseram que ele pertence a um bando pirata e planeja mata-la para pegar a herança!");
        Console.narrator("*Pposu tenta avisar a todos os cidadões, mas ninguem acredita nele pelo seu historico de mentira, então ele decidi que irá enfrentar os piratas sozinho!*");
        Console.narrator("- Pposu tenta ir ate a casa de sua amiga Ayak e alerta-la, porem o mordomo Erodahslk o expulsa antes dele conseguir falar com ela!");
        Console.narrator("- Sua tripulação decidi ajudar Pposu, mas cada um quer algo em troca!");
        Console.dialogf("\n%s: Eu quero muita carne após a luta!\n",
                Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
        Console.dialog("Oroz: Eu quero muito saquê");
        Console.dialog("Iman: Eu quero todo o tesouro que tiver dentro do navio deles!");
        Console.narrator("*Após algumas horas os invasores chegaram*");
        Console.dialog("Oroz: Eles chegaram em 3 será 1 para cada!");
        Console.narrator("- Iman fica com o mais fraco para distrai-lo enquanto vocês derrotam os outros 2, Zoro pega os irmãos e você fica com o ultimo e mais forte!");
        Console.dialog("Oroz: Vocês 2 ai, eu irei lutar com vocês não estão permitidos subir nessa colina!");
        Console.sleep(15000);
        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Ognaj, O Hipnotizador", 30, 5, 50, 15),
                input);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                System.out.println(randomGold);
                Console.narrator("Você esperou ele lhe atacar e desviou, fazendo com que Ognaj ficasse preso no oleo que estava no chão!");
                Console.narrator(
                        "Acabou deixando cair um pouco de ouro no oleo."
                                + gold + " golds");
                character.removeGold(gold);
            } else
                Console.narrator("Você conseguiu derrotar o Ognaj, O hipnotizador!");
            Console.sleep(3000);
            Console.clearConsole();
            Console.narrator(
                    "- Após derrotar seu oponente você vai ajudar o oroz\n");
            Console.dialogf("\n%s: Oroz aguenta mais um pouco, ja estou indo lhe ajudar\n",
                Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
            Console.narrator("*Você corre até onde oroz está!*");
            Console.sleep(3000);
            Console.clearConsole();
            battleResult = BattleSystem.startBattle(character, new Enemy("Gemêo 1", 55, 8, 70, 35), input);
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
                    Console.narrator(Color.GREEN + "Você derrotou o primeiro gemeo, como será que o oroz está");

                Console.narrator(
                        "- Oroz ja tinha derrotado seu oponente!");
                Console.dialogf("%s: Finalmente conseguimos acabar com todos, não vejo a hora de comer bastante carne!\n",
                        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                Console.dialog("Oroz: Espero que tenham muito saquê, porque hoje vamos festejar bastante!\n");
                Console.dialog("Iman: Vou aproveitar pra analisar o barco deles e pegar todos as coisas valiosas!");
                Console.narrator("- Enquanto vocês conversavam chegou uma pessoa na colina, aparentemente ele é da tripulação!");
                Console.narrator("- Quando Pposu olha para traz, ele identifica o 4 membro e ele é o mordomo de sua amiga Ayak!");
                Console.enemy("Erodahslk: Vocês acham que venceram? não deixarei que acabem com meu plano de anos dessa forma, se preparem para morrer!");
                Console.narrator("*Erodahslk conta seu plano, que ele formulou e começou a por em pratica a anos*");
                Console.dialogf("%s: Pensei que poderia ir comer carne em paz!\n",
                        Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                Console.narrator("*Todos se juntam para derrotar Erodahslk*");
                Console.sleep(8000);
                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Erodahslk", 70, 12, 100, 50),
                        input);
                if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                    if (battleResult == BattleResult.ESCAPE) {
                        int randomGold = (int) (Math.random() * 15) + 1;
                        double gold = character.getGold() * (randomGold / 100.0);
                        System.out.println(randomGold);
                        Console.narrator("Ele foi atacar vocẽs e acabou caindo num navio que passava pelas costa!");
                        Console.narrator(
                                "Infelizmente quando ele caiu acabou puxando um pouco do seu gold."
                                        + gold + " golds");
                        character.removeGold(gold);
                    } else
                        Console.narrator(Color.GREEN
                                + "- Você e sua tripulação conseguiu derrotar Erodahslk com sucesso.");
                    Console.narrator(
                            "Oroz: Finalmente, agora essa ilha ta livre e protegida.\n");
                    Console.dialogf(
                            "%s: Agora que finalmente acabou vamos fazer uma festa e comer bastante!\n",
                            Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                    Console.dialog("Iman: Enquanto vocês vão preparar o banquete, eu vou ver oque tinha no navio deles!");
                    Console.enemy(
                            "Pposu: *Chorando* Muito obrigado pela ajuda pessoal, muito obrigado mesmo.\n");
                    Console.narrator(
                            "- Vocês passaram a noite toda festejando a vitoria");
                    Console.narrator("- No dia seguinte Ayka vem agradecer a todos e diz que tem um presente para os " + character.getBevy() + " e pede que esperem alguns dias!");
                    Console.narrator("*Alguns dias depois*");
                    Console.dialog("Ayka: Oi pessoal, o presente que prometi para vocês está na costa, vamos la!\n");
                    Console.narrator("*Vocês vão até a costa*");
                    Console.dialog("Ayka: Como agradedimento quero entregar esse barco para que sua tripulação possa navegar nesse imenso mar e conquistar varias coisas!");
                    Console.dialogf(
                            "%s: Nossa tem uma vela nele poderemos pintar nossa bandeira pirata!\n",
                            Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                    Console.narrator(
                            "Oroz: Finalmente um navio digno!\n");
                    Console.narrator(
                            "Iman: Não precisaremos mais andar no barco da tripulação do Yggub\n");
                    Console.dialogf(
                            "%s: Pposu quero que você vire nosso companheiro e entre para a tripulação!\n",
                            Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                    Console.dialog("Pposu: Não sei se posso aceitar, não posso deixar todos aqui sem minha proteção!\n");
                    Console.dialog("Ayka: Pode ir Pposu sempre foi seu sonho ter aventuras no mar igual seu pai, você poderá navegar e depois voltar para cá e contar todas suas aventuras com seus companheiros para mim!");
                    Console.dialog("Pposu: vou pensar!");
                    Console.narrator("*Alguns dias passam*");
                    Console.dialog("Iman: Acho que está na hora de irmos, acho que o Pposu não vai querer se juntar a tripulação!");
                    Console.dialogf(
                            "Oroz e %s: Vamos!\n",
                            Color.RED + Color.BOLD + character.getNickname() + Color.RESET + Color.GREEN);
                    Console.narrator("- Quando vocês tavam perto de desatracar o navio, chega Pposu");
                    Console.dialog("Pposu: Eu vou com vocês, eu quero navegar e descobrir esse imenso mar de viwod");
                    Console.narrator("Com isso você finaliza mais uma ilha, espero que esteja gostando da historia e de sua aventura, e não esqueça de passar na loja e comprar poções ou armas melhores!");
                    Console.sleep(10000);
                    Console.clearConsole();
                    return true;
                } else {
                    Console.narrator("O " + character.getNickname()
                            + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO Erodahslk!)");
                    Console.sleep(2000);
                    return false;
                }
            } else {
                Console.narrator("O " + character.getNickname()
                        + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS PIRATAS!)");
                Console.sleep(2000);
                return false;
            }
        } else {
            Console.narrator("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS PIRATAS!)");
            Console.sleep(2000);
            return false;
        }
    }
}
