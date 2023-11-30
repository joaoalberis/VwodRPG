package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
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
        Console.narrator("[Narrador]: Todos do bando estavam descansando em suas respectivas cabines, quando de repente escutam um grande estrondo no mar, todos se levantaram rapidamente e foram ver oque tinha acontecido.\n");
        Console.narrator("[Narrador]: Quando sairam de suas cabines observaram que estavam sobre ataque de um bando pirata inimigo, todos pegaram suas armas e se prepararam para o combate!\n");
        
        System.out.println("Aperte ENTER para continuar...");
        input.nextLine();

        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Bando Pirata", 61, 13.5, 40, 40),
                input, true);
        if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
            if (battleResult == BattleResult.ESCAPE) {
                int randomGold = (int) (Math.random() * 15) + 1;
                double gold = character.getGold() * (randomGold / 100.0);
                Console.narrator("[Narrador]: Vocês tentaram fugir, mas não estavam conseguindo, por sorte um monstro marinho apareceu e comeu a parte do barco onde a tripulação inimiga se encontrava. Vocês ficaram surpresos e jogaram " + character.getGold() + " ouro(s) no mar, lendas dizem que monstros marinhos  seguem coisas brilhantes!\n");
                character.removeGold(gold);
            } else
                Console.dialogf("[%s]: Essa foi por pouco, embora eles tivessem em grande quantidade todos eram fracos, nem o capitão era descente em batalhas!\n", character.getNickname());
            Console.sleep(6000);
            Console.clearConsole();
            Console.dialog("[Oklama]: Vamos ver oque eles tinham em seus navios, espero que tenha uma boa quantidade de dinheiro para nossos suplimentos, já estamos quase chegando em avalon.\n");
            Console.narrator("[Narrador]: Vocês foram analisar a embarcação inimiga, para surpresa de todos, embora eles parecerem fracos tinham uma quantidade razoavel em tesouros e ouro!\n");
            Console.dialog("[Liz]: Acho que essa quantidade vai ser mais que o suficiente para comprar os suplementos, vamos voltar e ir diretamente a avalon!\n");
            Console.narrator("[Narrador]: Após alguns dias navegando finalmente a ilha avalon estava a vista!\n");
            
            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();

            BoatAnimation.boatTrasition(10);
            Console.clearConsole();
            Console.dialogf("[%s]: Vamos se dividir, Liz eu vou com você comprar os suplementos e Oklama você vai em busca de informações sobre algum carpiteiro para o reparo do barco!\n", character.getNickname());
            Console.dialog("[Oklama]: Pode deixar comigo!\n");
            Console.narratorf("[Narrador]: %s e Liz encontra um local para comprar os suplementos, ele parece suspeito, mas vocês entram no local. Ao entrar vocẽs caem em uma armadilha, era um grupo de pessoas que capturam piratas para entregar a marinha e ganhar a recompensa.\n", character.getNickname());
            Console.dialogf("[%s]: Quem voces pensam que são para nos prender aqui? Se arrependam e nos soltem antes que seja tarde demais para vocês!\n", character.getNickname());
            Console.enemy("[Caçadores de Piratas]: Com certeza será tarde, mas não para gente, a marinha ja foi notificada em alguns dias eles chegaram aqui e vocês serão decapitados!\n");
            Console.dialog("[Liz]: *Susurra* Espero que o Oklama consiga nos achar antes da marinha chegar!\n");
            Console.dialogf("[%s]: *Susurra* Não se preocupe nos sairemos daqui!\n", character.getNickname());
            Console.enemy("[Caçadores de Piratas]: O que tanto voces susurram aí?\n");
            Console.narrator("[Narrador]: 2 dias se passam.\n");
            Console.enemy("[Caçadores de Piratas]: Falta pouco para que a marinha chegue, estejam preparados!\n");
            Console.dialog("[Liz]: *Susurra* Capitão, acho que estamos perdidos dessa vez, a marinha em poucas horas chegará aqui e nada do Oklama!\n");
            Console.dialogf("[%s]: *Susurra* Não se preocupe!\n", character.getNickname());
            Console.narrator("[Narrador]: Mais algumas horas passam e de repente um enorme estrondo acontece do lado de fora, após alguns minutos Oklama entra e liberta vocês!\n");
            Console.dialogf("[%s]: Eu falei para não se preocupar liz, agora se preparem com certeza deve ter reforço chegando, precisamos ser rapidos a  marinha jaja estará por aqui!\n", character.getNickname());
            
            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();

            Console.clearConsole();
            battleResult = BattleSystem.startBattle(character, new Enemy("Caçadores de Piratas", 75, 15.5, 40, 40), input, true);
            if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                if (battleResult == BattleResult.ESCAPE) {
                    int randomGold = (int) (Math.random() * 15) + 1;
                    double gold = character.getGold() * (randomGold / 100.0);
                    System.out.println(randomGold);
                    Console.narrator("Vocês acharam uma porta nos fundos da casa que foram presos, escaparam por la, mas esqueceram uma pequena bolsa de dinheiro no chão!");
                    Console.narrator("A bolsinha continha " + gold + " Golds\n");
                    character.removeGold(gold);
                } else
                    Console.dialogf("[%s] Eu avisei para nos soltar antes que fosse tarde demais\n", character.getNickname());

                Console.dialogf("[%s]: Vamos voltar a nossa compra de suplementos e tentar sair o mais rapido possivel!\n", character.getNickname());
                Console.dialog("[Oklama]: Sobre a busca por um carpiteiro consegui informações, quando a gente tiver indo para o navio falarei sobre!\n");
                Console.dialog("[Liz]: Não se esqueçam que a marinha em breve estará aqui. Seria bom, caso a gente consiga sair sem precisar lutar com eles!\n");
                Console.narrator("[Narrador]: Vocês procuram outra loja para compra dos suplementos, felizmente acharam e consiguiram finalizar a compra, agora estão indo em direção ao navio para ir embora!\n");
                Console.narrator("[Narrador]: Quando vocês estavam chegando no navio, a marinha aparece, um dos membros dos caçadores tinha saído antes e foi avisar a marinha, assim possibilitando que eles procurassem pelo navio de vocês!\n");
                Console.dialog("[Liz]: Pelo jeito não conseguiremos sair daqui sem um pouco de luta!\n");
                
                System.out.println("Aperte ENTER para continuar...");
                input.nextLine();

                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Marinheiros", 86, 17, 70, 50), input, true);
                if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                    if (battleResult == BattleResult.ESCAPE) {
                        int randomGold = (int) (Math.random() * 15) + 1;
                        double gold = character.getGold() * (randomGold / 100.0);
                        System.out.println(randomGold);
                        Console.narrator("Vocês decidem se dividir pela cidade e se encontrar no barco!");
                        Console.narrator("Cada membro acabou deixando cair " + gold + " Golds");
                        character.removeGold(gold);
                    } else
                        Console.narrator("Cada um dos integrantes derrotou seus oponentes e foram se encontrar no barco!\n");
                    Console.dialogf("[%s]: Agora que todos estão aqui vamos nos organizar e decidir a proxima parada!\n", character.getNickname());
                    Console.dialog("[Oklama]: Sobre o carpiteiro, eu descobri que é possivel encontrar um na ilha de Blefuscu, obtive a informação que la é uma ilha feita por moradores especializados em carpintaria!\n");
                    Console.dialogf("[%s]: Parece que Blefuscu é o destino perfeito para encontrarmos um bom carpinteiro. Vamos nos preparar e zarpar para lá.\n", character.getNickname());
                    Console.narratorf("[Narrador]: Com a vitória sobre a marinha em Avalon, a tripulação liderada por %s decide seguir em direção à ilha de Blefuscu em busca de um habilidoso carpinteiro para reparar o navio danificado\n", character.getNickname());
                    Console.dialog("Parabéns por concluir mais uma parte de sua aventura, se prepare para proxima, não esqueça de comprar suprimentos na loja!");
                    
                    System.out.println("Aperte ENTER para continuar...");
                    input.nextLine();

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
                        + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS CAÇADORES DE PIRATAS!)");
                Console.sleep(3000);
                return false;
            }
        } else {
            Console.narrator("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO BANDO PIRATA!)");
            Console.sleep(3000);
            return false;
        }
    }
}
