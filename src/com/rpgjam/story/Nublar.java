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
        Console.narrator("[Narrador]: Você está em um mundo que se passa em meados do século 17. Um lugar onde a navegação e o mundo pirata estão em alta,nesse mundo é bastante comum ver barcos com bandeiras piratas erguidas, vilas sendo saqueadas e pessoas morrendo.\n");
        Console.narrator("[Narrador]: Neste vasto mundo chamado" + (Color.BOLD + " Viwod" + Color.RESET) + ", há diversos piratas famosos da antiga e nova era, entre os mais velhos, temos os famosos piratas da tripulação Regor e Abrab Acnarb. Já na nova era temos os Sknahs e Odiak. Você está decidido em entrar nesse mundo e conquistar todos os tesouros e riquezas existentes.\n");
        Console.narrator("[Narrador]: Você um certo dia acorda e decide começar a sua navegação em busca de companheiros para conquistar o vasto mundo de viwod.\n");
        Console.dialogf("[%s]: Finalmente vou me aventurar por esse mundo! Formarei minha tripulação e conquistaremos riquezas e fama, hein!\n", character.getNickname());
        Console.narrator("[Narrador]: " + character.getNickname() + ", o brincalhão, encontra um pequeno bote na praia de sua ilha e decide zarpar em sua jornada.\n");
        Console.narrator("[Narrador]: Após alguns dias navegando, depara-se com um navio naufragado e uma pessoa a bordo. Decide abordar o desconhecido.\n");
        Console.dialogf("[%s]: Ei, tudo bem por aí?\n", character.getNickname());
        Console.dialog("[Desconhecido]: Morrendo de fome. Passe tudo o que tem aí, ou vou matá-lo!\n");
        Console.dialogf("[%s]: Que tal uma proposta melhor? Torne-se meu companheiro, conquistaremos juntos esse vasto mundo!\n", character.getNickname());
        Console.dialog("[Desconhecido]: Nunca me juntarei a você!\n");
        Console.dialogf("[%s]: Fechado! Te dou comida e uma semana para se recuperar, depois duelaremos. Se eu vencer, jura lealdade e entra para a tripulação!\n", character.getNickname());
        Console.narrator("[Narrador]: LA ELE MIL VEZES\n");
        Console.dialog("[Desconhecido]: Aceito, não vou perder para você!\n");
        Console.dialogf("[%s]: Qual é o seu nome? Eu sou %s!\n", character.getNickname(), character.getNickname());
        Console.dialog("[Oklama]: Me chamo Oklama Tsugee, mas pode me chamar de Oklama!\n");
        Console.narratorf("[Narrador]: %s alimenta Oklama. Após uma semana, é hora do duelo entre %s e Oklama!\n", character.getNickname(), character.getNickname());

        System.out.println("Aperte ENTER para continuar...");
        input.nextLine();

        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Oklama", 25, 8, 25, 10), input, false);
        Console.narratorf("[Narrador]: Com dificuldade, %s vence Oklama!\n", character.getNickname());
        Console.dialogf("[%s]: Agora, jure lealdade e una-se a mim!\n", character.getNickname());
        Console.dialog("[Oklama]: Não posso acreditar que perdi. Juro lealdade a você!\n");
        Console.dialogf("[%s]: Seja bem-vindo à nossa tripulação, Oklama. Alias, nossa tripulação se chama %s, e você será meu imediato!\n", character.getNickname(), character.getBevy());
        Console.dialog("[Oklama]: Para onde estávamos indo antes de nos encontrarmos?\n");
        Console.dialogf("[%s]: Planejo ir para Nublar. Ouvi dizer que vendem barcos lá. Com esse bote, não chegaremos muito longe nesse vasto mar!\n", character.getNickname());
        Console.dialog("[Oklama]: Concordo. Além de um barco, precisamos de um navegador!\n");

        System.out.println("Aperte ENTER para continuar...");
        input.nextLine();

        BoatAnimation.boatTrasition(5);
        Console.clearConsole();
        Console.narrator("Narrador: Ao pisar na ilha, vocês já se deparam com ladrões que tentam roubar seu dinheiro!\n");
        Console.enemy("[Bandidos]: Passem tudo, estou vendo que vocês tem bastante dinheiro aí, quero tudo e nem tentem esconder!\n");
        Console.dialog("[Oklama]: Essa será a única chance de vocês saírem daqui, não avisarei uma segunda vez!\n");
        Console.enemy("[Bandidos]: Quem vocês acham que são, a gente manda nessa área. Vocês irão se arrepender por não fugir!\n");
        Console.dialogf("[%s]: Oklama, esquece! Com eles não vai ter dialogo, teremos que mostrar quem são os mais fortes!\n", character.getNickname());
        
        System.out.println("Aperte ENTER para continuar...");
        input.nextLine();

        Console.clearConsole();
        battleResult = BattleSystem.startBattle(character, new Enemy("Bandidos", 30, 10, 30, 10),
                input, true);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                System.out.println(randomGold);
                Console.narrator(
                        "Vocês não conseguiram derrotá-los, então decidem fugir, acabam deixando cair algumas moedas de ouro no processo! " + gold + " golds\n");
                character.removeGold(gold);
            } else
            Console.dialog("[Oklama]: Eu avisei à vocês que não teriam um segundo aviso!");
            
            
            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();

            Console.dialogf("[%s]: Vamos oklama, comprar o barco e sair dessa ilha, precisamos ir a procura de um navegador pra explorar!\n", character.getNickname());
            Console.dialog("[Oklama]: Ok!\n");
            Console.narrator("[Narrador]: Vocês estão andando pela ilha de nublar, quando se deparam com uma moça conversando com uma navegadora.\n");
            Console.narrator("[Narrador]: A navegadora fala que a marinha tinha confiscado seu dinheiro e estava a procura de ajuda, e estava disposta até a virar uma pirata, caso alguem a ajudasse!\n");
            Console.dialogf("[%s]: Olá dona moça, escutei que está precisando de ajuda contra a marinha e está disposta à entrar em um bando. Que tal eu te ajudar e você virar nossa navegadora?\n", character.getNickname());
            Console.dialog("[Desconhecida]: Eu aceito, mas primeiro você precisa recuperar meu dinheiro, me chamo Liz, irei lhe passar algumas informações. Quando conseguir recuperar meu dinheiro, me encontre na loja do Renner.\n");
            Console.dialogf("[%s]: Tudo bem.\n", character.getNickname());
            Console.narrator("[Narrador]: Você recebe informações importantes sobre o local e quantidade de inimigos!\n");
            Console.narrator("[Narrador]: Vocês vão até o local e se deparam com vários marinheiros!\n");
            
            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();

            Console.clearConsole();

            battleResult = BattleSystem.startBattle(character, new Enemy("Marinheiros", 40, 12, 60, 25), input, true);
            if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                if (battleResult == BattleResult.ESCAPE) {
                    int randomGold = (int) (Math.random() * 15) + 1;
                    double gold = character.getGold() * (randomGold / 100.0);
                    System.out.println(randomGold);
                    Console.narrator(
                            "Você distraiu os marinheiros, enquanto o Oklama pegou o dinheiro confiscado e então fugiram, mas infelizmente, não consiguiram pegar todo o dinheiro deixando um pouco lá. Terão que realocar do dinheiro de vocês o restante!" + gold + " golds Foram esquecidos.\n");
                    character.removeGold(gold);
                } else
                    Console.dialogf("[%s]: Estou muito cansado, mas valerá a pena, iremos conseguir a nossa navegadora!\n", character.getNickname());

                Console.dialogf("[%s]: Agora só basta encontrar ela no local e após isso comprar nosso barco!\n", character.getNickname());
                Console.narrator("[Narrador]: Vocês vão até o local marcado!\n");
                Console.dialog("[Liz]: Vejo que conseguiram recuperar meu dinheiro, aliás aqui é a loja da minha amiga, ela fabrica barcos!\n");
                Console.dialogf("[%s]: Perfeito, estávamos em busca de uma loja para comprar nosso barco, aqui está o seu dinheiro, e seja bem-vinda a nossa tripulação. Eu me chamo %s e esse é meu imediato Oklama\n", character.getNickname(), character.getNickname());
                Console.dialog("[Oklama]: Seja bem-vinda a nossa tripulação, com você, finalmente poderemos navegar por novas aventuras!\n");
                Console.dialog("[Amiga da liz]: Vocês querem encomendar um barco, correto?\n");
                Console.dialogf("[%s]: Exatamente, quanto tempo para ele ficar pronto?\n", character.getNickname());
                Console.dialog("[Amiga da Liz]: Já temos alguns modelos prontos, vocês podem olhar e decidir se gostarem de algo, caso gostem dos modelos podem levar imediatamente!\n");
                Console.narrator("[Narrador]: Vocês olham algumas dezenas de barcos e finalmente escolhem um.\n");
                Console.dialog("[Liz]: Podem ir indo para o litoral, eu irei pegar o barco e encontro com vocês lá.\n");
                Console.dialogf("[%s]: Certo.\n", character.getNickname());
                Console.narrator("[Narrador]: Vocês vão até o litoral, chegando lá vocês encontram com o grupo de bandidos que tentaram rouba-los ao atracar na ilha, mas dessa vez eles tão com reforços!\n");
                Console.enemy("[Bandidos]: Haha, sabia que vocês iriam voltar para cá, trouxe reforços, vocês estão acabados dessa vez.\n");
                Console.dialogf("[%s]: Se preparem, pois dessa vez não sairá ninguem vivo!\n", character.getNickname());
                
                System.out.println("Aperte ENTER para continuar...");
                input.nextLine();

                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Bandidos", 50, 16, 70, 30),
                        input, true);
                if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                    if (battleResult == BattleResult.ESCAPE) {
                        int randomGold = (int) (Math.random() * 15) + 1;
                        double gold = character.getGold() * (randomGold / 100.0);
                        System.out.println(randomGold);
                        Console.narrator(
                                "Vocês decidem fugir, eles estavam em muitos, felizmente a Liz chegou rapidamnete com o barco, possibilitando uma fuga, mas acabaram deixando um pouco de ouro cair!" + gold + " golds cairam\n");
                        character.removeGold(gold);
                    } else
                        Console.dialogf("[%s]: Vocês são verdadeiros perdedores, avisei que não teria piedade dessa vez!\n", character.getNickname());
                    Console.narrator(
                            "[Narrador]: Já no barco vocês começam a discutir para qual ilha vocês irão, após uma longa conversa foi decidido ir para a ilha de Avalon, pois precisam de suplementos!\n");
                    Console.narrator(
                            "[Narrador]: Com isso a primeira ilha foi finalizada com sucesso, e sua tripulação seguirá para proxima ilha.\n");
                    
                    System.out.println("Aperte ENTER para continuar...");
                    input.nextLine();

                    Console.clearConsole();
                    return true;
                } else {
                    Console.narrator("O " + character.getNickname()
                            + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS BANDIDOS!)");
                    Console.sleep(2000);
                    return false;
                }
            } else {
                Console.narrator("O " + character.getNickname()
                        + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DA MARINHA!)");
                Console.sleep(2000);
                return false;
            }
        } else {
            Console.narrator("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS BANDIDOS!)");
            Console.sleep(2000);
            return false;
        }
    }
}
