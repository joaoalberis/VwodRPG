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
        Console.narrator(
                "[Narrador]: A viagem até Blefuscu é tranquila, e ao chegar, vocês se deparam com uma ilha repleta de construções feitas com perfeição pelos habilidosos moradores.\n");
        Console.narrator(
                "[Narrador]: Ao procurar por um carpinteiro, são indicados a ir até a oficina de Grizzle, um talentoso artesão. Ao chegar lá, Grizzle está ocupado em seu trabalho.\n");
        Console.dialog("[Grizzle]: Olá, como posso ajudar vocês?\n");
        Console.dialogf(
                "[%s]: E aí, Grizzle! Estamos em busca de um carpinteiro para dar um jeito no nosso barco. Topa ajudar?\n",
                character.getNickname());
        Console.dialog(
                "[Grizzle]: Olha só, um barco todo detonado! Vocês são corajosos! Mas relaxem, vou ajudar. Deixem eu dar uma olhada nos estragos.\n");
        Console.narrator(
                "[Narrador]: Grizzle examina o navio, avaliando os danos e planejando os reparos necessários.\n");
        Console.dialog(
                "[Grizzle]: Esses danos são sérios, vai levar um tempinho para consertar tudo. Enquanto isso, que tal explorarem a cidade? Blefuscu tem seus encantos.\n");
        Console.dialogf(
                "[%s]: Ótimo! E já que estamos por aqui, ouvimos um papo sobre um tesouro escondido. Alguma chance de ser verdade?\n",
                character.getNickname());
        Console.dialog(
                "[Grizzle]: Tesouro, hein? Interessante. Dizem que está na colina mais alta da ilha, dentro de uma caverna. Que tal darem uma olhada?\n");
        Console.dialogf(
                "[%s]: Parece emocionante! O que acham, pessoal? Vamos atrás desse tesouro enquanto o navio é consertado?\n",
                character.getNickname());
        Console.dialog("[Oklama]: Concordo. Se encontrarmos algo valioso, pode ajudar nos reparos.\n");
        Console.dialog("[Liz]: Já que estamos aqui, por que não? Vamos em frente!\n");
        Console.narratorf("[Narrador]: Todos concordam e %s lidera a tripulação em direção à colina mais alta!\n",
                character.getNickname());
        Console.narrator("[Narrador]: Enquanto escalavam a colina, foram surpreendidos por um grupo de monstros!\n");

        System.out.println("Aperte ENTER para continuar...");
        input.nextLine();

        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Monstros", 114, 26, 50, 15), input,
                true);

        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                System.out.println(randomGold);
                Console.narrator(
                        "[Narrador]: Eles eram fortes demais, então vocês decidem fugir e continuar a subir a colina!");
                Console.narrator(
                        "[Narrador]: Um ganho furou um de seus bolsos e uma quantia de gold caiu."
                                + gold + " golds\n");
                character.removeGold(gold);
            } else
                Console.narrator("[Narrador]: Vocês conseguiram derrotar com sucesso o grupo de monstros!\n");
            Console.dialogf(
                    "[%s]: Beleza, pessoal! Já consigo ver o topo da colina, com sorte, será moleza achar esse tesouro!\n",
                    character.getNickname());
            Console.dialog("[Oklama]: Com certeza não será fácil. Se fosse, alguém já teria encontrado!\n");
            Console.narrator(
                    "[Narrador]: Após algumas horas procurando pela colina, vocês encontram uma caverna e decidem entrar!\n");
            Console.dialogf("[%s]: Será que essa é a caverna mencionada no rumor?\n", character.getNickname());
            Console.dialog("[Liz]: Só saberemos se tivermos algum tesouro lá dentro!\n");
            Console.dialog("[Oklama]: Sem mais delongas, vamos lá!\n");
            Console.narratorf("[Narrador]: A tripulação liderada por %s entra na caverna e começa a explorar.\n",
                    character.getBevy());
            Console.dialogf("[%s]: Nossa, essa caverna é enorme! Nem parece que está no topo da colina!\n",
                    character.getNickname());
            Console.dialog("[Liz]: Acho que já devemos estar perto de terminar a exploração!\n");
            Console.narrator(
                    "[Narrador]: Após mais alguns minutos de caminhada, vocês finalmente chegam ao final da caverna!\n");
            Console.dialogf("[%s]: Vejam, há um baú em cima daquela pedra. Acho que encontramos o tesouro.\n",
                    character.getNickname());
            Console.dialog(
                    "[Liz]: Estou achando meio fácil isso, embora tenhamos levado horas, não deveria ser tão simples.\n");
            Console.narrator(
                    "[Narrador]: Liz estava certa. De repente, um grande estrondo na caverna, e ao olharem para cima, um dragão aparece!\n");
            Console.dialogf(
                    "[%s]: Você e essa sua boca, Liz. Agora teremos que derrotar esse dragão para sair daqui com vida e com o tesouro!\n",
                    character.getNickname());

            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();

            Console.clearConsole();
            battleResult = BattleSystem.startBattle(character, new Enemy("Dragão", 176, 32, 70, 55), input, false);
            if (battleResult == BattleResult.VICTORY) {
                Console.dialogf(
                        "[%s]: Esse dragão era incrivelmente forte. Ainda bem que viemos nós três para cá. Agora, vamos ver o que tem dentro desse baú!\n",
                        character.getNickname());
                Console.narrator(
                        "[Narrador]: Ao abrir o baú, vocês se deparam com várias peças de ouro e ouro bruto!\n");
                Console.dialogf(
                        "[%s]: Haha, nossas finanças estão salvas. Com isso, teremos mais do que suficiente para pagar o barco!\n",
                        character.getNickname());
                Console.dialog(
                        "[Liz]: Vamos voltar imediatamente. Pelo tempo que demoramos para chegar aqui, e vamos demorar para voltar, o navio deve estar pronto!\n");
                Console.narrator(
                        "[Narrador]: Vocês começam a voltar todo o caminho percorrido. Horas se passam quando estavam quase chegando à saída, um barulho vindo da entrada. Alguns minutos depois, vocês se deparam com outro dragão!\n");
                Console.dialog(
                        "[Liz]: É óbvio que teria outro dragão. Provavelmente, o dragão que derrotamos era a fêmea, e esse deve ser o macho!\n");
                Console.dialogf("[%s]: Espero que as fêmeas sejam as mais fortes do grupo!\n", character.getNickname());
                System.out.println("Aperte ENTER para continuar...");
                input.nextLine();

                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Dragão Macho", 200, 48, 90, 70), input,
                        false);
                if (battleResult == BattleResult.VICTORY) {
                    Console.narrator(
                            "[Narrador]: Vocês conseguiram derrotar o dragão, porém Oklama ficou severamente ferido. Vocês têm que levá-lo urgentemente para receber cuidados!\n");
                    Console.dialogf("[%s]: Liz, você leva o tesouro. Eu irei com Oklama na frente.\n",
                            character.getNickname());
                    Console.dialog("[Liz]: Ok.\n");
                    Console.narratorf(
                            "[Narrador]: %s pega Oklama e corre intensamente e sem descanso. Felizmente, ele consegue encontrar um curandeiro na ilha, mesmo que ela seja de carpinteiros.\n",
                            character.getNickname());
                    Console.dialogf(
                            "[%s]: Olhe, meu companheiro. Tivemos uma intensa luta com 2 dragões e conseguimos vencer, mas ele foi severamente ferido!\n",
                            character.getNickname());
                    Console.dialog(
                            "[Curandeiro]: Eu posso ajudá-lo, mas você acabou de falar que enfrentou 2 dragões?\n");
                    Console.dialogf("[%s]: Exatamente!\n", character.getNickname());
                    Console.dialog(
                            "[Curandeiro]: Eu vou ajudá-lo, mas preciso que, em troca, você me traga algumas escamas do dragão!\n");
                    Console.dialogf("[%s]: Não se preocupe, eu vou imediatamente pegar!\n", character.getNickname());
                    Console.narrator(
                            "[Narrador]: Você volta imediatamente para a caverna para pegar algumas escamas!\n");
                    Console.narrator(
                            "[Narrador]: Você pega todas as escamas necessárias e volta ao curandeiro. Ao chegar, você entrega as escamas a ele. Seu companheiro já foi tratado e está se recuperando.\n");
                    Console.narrator(
                            "[Narrador]: Alguns dias se passam e Oklama está melhor. Então, vocês decidem ir pegar o navio.\n");
                    Console.dialogf(
                            "[%s]: Grizzle, desculpa a demora. Fomos atrás do tesouro que você mencionou. Ele realmente existia, mas enfrentamos problemas. Meu companheiro foi ferido por um dragão, por isso demoramos a vir!\n",
                            character.getNickname());
                    Console.dialog(
                            "[Grizzle]: Vocês realmente acharam o tesouro! Pensei que era apenas um boato, mas que história é essa de dragão? Pensei que eles estavam extintos!\n");
                    Console.dialogf(
                            "[%s]: Pelo visto não, mas talvez agora estejam. Tivemos que matar 2 para conseguir sair da caverna, onde o tesouro estava guardado. E nosso barco já está pronto?\n",
                            character.getNickname());
                    Console.dialog(
                            "[Grizzle]: Sim, ele está pronto faz um tempo. Já estava pensando que vocês tinham desistido dele!\n");
                    Console.dialogf(
                            "[%s]: Hehe, que nada. Ele é nosso primeiro barco, não iríamos deixá-lo assim. Aqui está o pagamento pelo concerto.\n",
                            character.getNickname());
                    Console.dialog(
                            "[Grizzle]: Obrigado, boa aventura para vocês. Qualquer coisa, podem voltar aqui!\n");
                    Console.narratorf(
                            "[Narrador]: Com o tesouro em mãos e o navio reparado, a tripulação liderada por %s parte de Blefuscu rumo à próxima ilha em sua jornada.\n",
                            character.getNickname());
                    Console.dialogf(
                            "[%s]: Finalmente, estamos prontos para novas aventuras! Para onde devemos ir agora?\n",
                            character.getNickname());
                    Console.dialog(
                            "[Liz]: Temos algumas opções de ilhas para explorar. Podemos escolher entre a ilha de Meridium, conhecida por suas riquezas naturais, ou a ilha de Zephyr, famosa por seus fortes ventos que impulsionam a navegação.\n");
                    Console.dialogf(
                            "[%s]: Vamos para a ilha de Meridium. Parece um lugar cheio de oportunidades e riquezas naturais.\n",
                            character.getNickname());
                    Console.narrator(
                            "Parabéns pela conclusão de mais uma ilha, compre itens e se abasteça para os próximos desafios!");

                    System.out.println("Aperte ENTER para continuar...");
                    input.nextLine();

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
