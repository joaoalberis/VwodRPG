package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.utils.Console;

public class Blefuscu {
    private Character character;
    private Scanner input = new Scanner(System.in);

    public Blefuscu(Character character) {
        this.character = character;
    }

    public boolean start() {
        Console.clearConsole();
        BoatAnimation.boatTrasition(10);
        Console.narrator("[Narrador]: A viagem até Blefuscu é tranquila, e ao chegar, vocês se deparam com uma ilha repleta de construções feitas com perfeição pelos habilidosos moradores.\n");
        Console.narrator("[Narrador]: Vocês começam a procurar por informações sobre um bom carpinteiro e são indicados a ir até a oficina de um talentoso artesão chamado Grizzle. Ao chegar lá, encontram Grizzle ocupado em seu trabalho.\n");
        Console.dialog("[Grizzle]: Olá, como posso ajudar vocês?\n");
        Console.dialogf("[%s]: Estamos em busca de um carpinteiro habilidoso para reparar nosso navio.\n", character.getNickname());
        Console.dialog("[Grizzle]: Vieram ao local correto, vejo que têm um belo barco precisando de cuidados. Ficarei feliz em ajudar, deixe-me dar uma olhada nos estragos.\n");
        Console.narrator("[Narrador]: Grizzle examina o navio, avaliando os danos e fazendo planos para os reparos necessários.\n");
        Console.dialog("[Grizzle]: Não se preocupem, os danos não foram muitos, mas vai levar algum tempo. Enquanto isso, porque não aproveitam para conhecer a cidade.\n");
        Console.dialogf("[%s]: Ótimo! Enquanto isso, o que há para fazer nesta ilha?\n", character.getNickname());
        Console.dialog("[Grizzle]: Eu ouvi recentemente um rumor sobre um tesouro, aparentemente ele esta escondido na colina mais alta da ilha m uma caverna, porque não aproveitam o tempo e vão la examinar?\n");
        Console.dialogf("[%s]: Acho que é isso, oque vocês acham de irmos procurar pelo tesouro?\n", character.getNickname());
        Console.dialog("[Oklama]: Acho perfeito, se acharmos poderemos repor o dinheiro que gastamos!\n");
        Console.dialog("[Liz]: Tambem concordo em irmos!\n");
        Console.narratorf("[Narrador]: Como todos os tripulantes concordam, %s e sua tripulação parte para a colina mais alta!\n", character.getNickname());
        Console.narrator("[Narrador]: Na subida pela colina, Eles foram supreendidos por um grupo de monstros!\n");
        Console.sleep(12000);
        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Monstros", 30, 5, 50, 15), input, true);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                System.out.println(randomGold);
                Console.narrator("Eles eram fortes demais, então vocês decidem fugir e continuar a subir a colina!");
                Console.narrator(
                        "Um ganho furou um de seus bolsos e uma quantia de gold caiu."
                                + gold + " golds\n");
                character.removeGold(gold);
            } else
                Console.narrator("Vocês conseguiram derrotar com exito o grupo de monstros!\n");
            Console.dialogf("[%s]: Vamos pessoal, ja consigo ver o topo da colina, se tivermos sorte será facil achar esse tesouro!\n", character.getNickname());
            Console.dialog("[Oklama]: Com certeza não acharemos facil, se nao alguem ja o teria achado!\n");
            Console.narrator("[Narrador]: Após algumas horas procurando pela colina, vocês acham uma caverna e decidem entrar!\n");
            Console.dialogf("[%s]: Será que essa é a caverna que o rumor citava?\n", character.getNickname());
            Console.dialog("[Liz]: So descobriremos, caso tenha algum tesouro ai dentro!\n");
            Console.dialog("[Oklama]: Vamos entrar logo!\n");
            Console.narratorf("[Narrador]:  O tripulação %s entra na caverna e vai a explorando.\n", character.getBevy());
            Console.dialogf("[%s]: Nossa, essa caverna é gigante nem parece que esta numa colina!\n", character.getNickname());
            Console.dialog("[Liz]: Acho que ja devemo estar perto de terminar a exploração!\n");
            Console.narrator("[Narrador]: Apos mais alguns minutos andando, vocês finalmente chegam ao final da caverna!\n");
            Console.dialogf("[%s]: Vejam ha um baú em cima daquela pedra, acho que conseguimos encontrar o tesouro!\n", character.getNickname());
            Console.dialog("[Liz]: Estou achando meio facil isso, embora demoramos horas andando não acho que seria tão simples assim!\n");
            Console.narrator("[Narrador]: Liz estava certa, de repente um grande estrondo na caverna, ao olharem para cima aparece um dragão!\n");
            Console.dialogf("[%s]: Você e essa sua boca liz, agora teremos que derrotar esse dragão para conseguir sair daqui com vida e com o tesouro!\n", character.getNickname());

            Console.sleep(7000);
            Console.clearConsole();
            battleResult = BattleSystem.startBattle(character, new Enemy("Dragão", 55, 8, 70, 35), input, false);
            if (battleResult == BattleResult.VICTORY) {
                Console.dialogf("[%s]: Esse dragão era incrivelmente forte, ainda bem que viemos nos 3 para cá, agora vamos ver oque tem dentro desse baú!\n", character.getNickname());

                Console.narrator("[Narrador]: Ao abrir o bau, vocês se deparam com varias peças de ouro e ouro bruto!\n");
                Console.dialogf("[%s]: Haha, nossas finanças estão salvas, com isso teremos mais que o suficiente para pagar o barco!\n", character.getNickname());
                Console.dialog("[Liz]: Vamos voltar imediatamente, pelo tempo demoramos para chegar aqui e vamos demorar para voltar, o navio deverá esta pronto!\n");
                Console.narrator("[Narrador]: Vocês começam a voltar todo o caminho pecorrido, horas se passam quando estavam quase chegando a saida, um barulho vindo da entrada, alguns minutos depois vocês se deparam com outro dragão!\n");
                Console.dialog("[Liz]: Obvio que teria outro dragão, provavelmente o dragão que derrotamos era o fêmea, esse deve ser o macho!\n");
                Console.dialogf("[%s]: espero que as fêmeas sejam as mais fortes do grupo!\n", character.getNickname());
                Console.sleep(5000);
                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Dragão Macho", 70, 12, 100, 50), input, false);
                if (battleResult == BattleResult.VICTORY) {
                        Console.narrator("[Narrador]: Vocês conseguiram subjugar o dragão, porém Oklama ficou severamente ferido, vocês tem que leva-lo urgentemente para receber cuidados!\n");
                    Console.dialogf("[%s]: Liz você leva o tesouro, eu irei com Oklama na frente.\n", character.getNickname());
                    Console.dialog("[Liz]: Ok.\n");
                    Console.narratorf("[Narrador]: %s pega Oklama e corre intensamente e sem descanso, felizmente ele consegue achar um curandeiro na ilha, mesmo que ela seja de carpinteiros.\n", character.getNickname());
                    Console.dialogf("[%s]: Olhe meu companheiro, tivemos uma intensa luta com 2 dragões conseguimos vencer, mas ele foi severamnente ferido!\n", character.getNickname());
                    Console.dialog("[Curandeiro]: Eu posso ajuda-lo, mas vocẽ acabou de falar que enfrentou 2 dragões?\n");
                    Console.dialogf("[%s]: Exatamente!\n", character.getNickname());
                    Console.dialog("[Curandeiro]: Eu vou ajuda-lo, mas preciso que em troca você me traga, algumas escamas do dragão!\n");
                    Console.dialogf("[%s]: Não se preocupe, eu vou imediatamente pegar!\n", character.getNickname());
                    Console.narrator("[Narrador]: Você volta imediatamente para a caverna pegar algumas escamas!\n");
                    Console.narrator("[Narrador]: Vocẽ pega todas as escamas necessarias e volta ao curandeiro, ao chegar você entrega as escamas a ele, seu companheiro ja foi tratado e se recuperando.\n");
                    Console.narrator("[Narrador]: Alguns dias se passam e Oklama está melhor, então vocês decidem ir pegar o navio.\n");
                    Console.dialogf("[%s]: Grizzle desculpa a demora, fomos atras do tesouro que você mencionou, ele realmente existia, mas enfretamos problemas, meu companheiro foi ferido por um dragão, por isso demoramos a vim!", character.getNickname());
                    Console.dialog("[Grizzle]: Vocês realmente acharam o tesouro, pensei que era apenas um boato, mas que historia é essa de dragão pensei que eles estavam extintos!\n");
                    Console.dialogf("[%s]: pelo visto não, mas talvez agora estejam tivermos que matar 2 para conseguir sair da caverna, onde o tesouro estava guardado. E nosso barco já esta pronto?\n", character.getNickname());
                    Console.dialog("[Grizzle]: Sim, ele está pronto faz um tempo, ja estava pensando que vocês tinham desistido dele!\n");
                    Console.dialogf("[%s]: Hehe que nada, ele é nosso primeiro barco, não iriamos deixa-lo assim, aqui esta o pagamento pelo concerto.\n", character.getNickname());
                    Console.dialog("[Grizzle]: Obrigado, boa aventura para vocês, qualquer coisa podem voltar aqui!\n");
                    Console.narratorf("[Narrador]: Com o tesouro em mãos e o navio reparado, a tripulação liderada por %s parte de Blefuscu rumo à próxima ilha em sua jornada.\n", character.getNickname());
                    Console.dialogf("[%s]: Finalmente, estamos prontos para novas aventuras! Para onde devemos ir agora?", character.getNickname());
                    Console.dialog("[Liz]: Temos algumas opções de ilhas para explorar. Podemos escolher entre a ilha de Meridium, conhecida por suas riquezas naturais, ou a ilha de Zephyr, famosa por seus fortes ventos que impulsionam a navegação.\n");
                    Console.dialogf("[%s]: Vamos para a ilha de Meridium. Parece um lugar cheio de oportunidades e riquezas naturais.\n", character.getNickname());
                    Console.narrator("Parabéns pela conclusão de mais uma ilha, compre itens e se abasteça para os proximos desafios!");
                    Console.sleep(13000);
                    Console.clearConsole();
                    return true;
                } else {
                    Console.narrator("O " + character.getNickname()
                            + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO DRAGÃO MACHO!)");
                    Console.sleep(2000);
                    return false;
                }
            } else {
                Console.narrator("O " + character.getNickname()
                        + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO DRAGÃO!)");
                Console.sleep(2000);
                return false;
            }
        } else {
            Console.narrator("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS MONSTROS!)");
            Console.sleep(2000);
            return false;
        }
    }
}
