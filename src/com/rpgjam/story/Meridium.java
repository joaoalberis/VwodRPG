package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.utils.Console;

public class Meridium {
    private Character character;
    private Scanner input = new Scanner(System.in);

    public Meridium(Character character) {
        this.character = character;
    }

    public boolean start() {
        BoatAnimation.boatTrasition(10);
        Console.clearConsole();
        Console.narrator("[Narrador]: A viagem até Meridium é repleta de descobertas, e ao chegar, vocês se deparam com uma paisagem exuberante, cheia de fauna e flora única.\n");
        Console.narrator("[Narrador]: Ao explorar a ilha, vocês encontram uma vila cujos habitantes são especialistas em mineração. Decidem se aproximar para saber mais!\n");
        Console.dialog("[Chefe da Vila]: Bem-vindos a Meridium! Se estão interessados em nossas gemas, voçẽs podem a obte-la comprando ou oferecendo algum serviço de proteção para um minerador, mas cuidado,pois a mina é cheia de perigos!\n");
        Console.dialogf("[%s]: Desafios não nos assustam. Vamos acompanhar um minerador!\n", character.getNickname());
        Console.narrator("[Narrador]: Vocês vão ate um minerador, o qual contrata vocês para fazer sua proteção.\n");
        Console.narrator("[Narrador]: Ao entrar na mina, vocês se deparam com túneis escuros e desafios inesperados, incluindo criaturas subterrâneas.\n");
        Console.dialog("[Liz]: Parece que essa mina não é tão fácil quanto pensávamos.\n");
        Console.dialog("[Minerador]: Não se preocupem, ja estamos chegando perto de uma veia de gemas, quando chegarmos se preparem para fazer minha proteção, pois as criaturas viram com o barulho da picareta.\n");
        Console.narrator("[Narrador]: Vocês finalmente encontram uma veia de gema, o minerador começa a minerar, enquanto isso vocês escutam o barulho de algo vindo do subsolo.\n");
        
        System.out.println("Aperte ENTER para continuar...");
        input.nextLine();

        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Vermes", 108, 34, 55, 35), input, false);
        if (battleResult == BattleResult.VICTORY) {
            Console.narrator("[Narrador]: Você e sua tripulação conseguiram derrotar o verme, o minerador ja está finalizando a mineração!\n");
            Console.dialog("[Minerador]: Vamos voltar agora, não é indicado ficar muito tempo nas minas!\n");
            Console.narrator("[Narrador]: Ao sair da mina, o minerador faz a divisão pela das gemas pela sua proteção, ele fez a divisão de 50 a 50!\n");
            Console.narrator("[Narrador]: Com as gemas divididas, vocês decidem explorar mais a ilha de Meridium. Enquanto caminham pela bela paisagem, avistam uma torre misteriosa no horizonte. Parece ser um antigo observatório abandonado.\n");
            Console.dialogf("[%s]: Aquela torre parece estranha. O que acham de darmos uma olhada?\n", character.getNickname());
            Console.dialog("[Liz]: Pode ser interessante, quem sabe encontramos algo valioso lá dentro.\n");
            Console.narrator("[Narrador]: Ao se aproximarem da torre, percebem que a porta está entreaberta. Ao adentrar, descobrem que o local está infestado de bandidos que utilizaram a torre como esconderijo.\n");
            
            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();

            Console.clearConsole();
            battleResult = BattleSystem.startBattle(character, new Enemy("Bandidos", 115, 35.5, 65, 35), input, true);
            if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                if (battleResult == BattleResult.ESCAPE) {
                    int randomGold = (int) (Math.random() * 15) + 1;
                    double gold = character.getGold() * (randomGold / 100.0);
                    System.out.println(randomGold);
                    Console.narrator("Os bandidos eram numerosos e bem armados, então decidem recuar estrategicamente da torre.\n");
                    Console.narrator("Vocês deixaram cair " + gold + " Golds\n");
                    character.removeGold(gold);
                } else
                    Console.dialogf("[%s] Esses bandidos não eram páreo para nós. Vamos continuar explorando e ver o que mais podemos descobrir.\n", character.getNickname());

                Console.narrator("[Narrador]: Vocês encontram uma pequena entrada atras do colina em que a torre estava, vocês decidem entrar!\n");
                Console.narrator("[Narrador]: Ao entrar na caverna, vocês encontram um explorador solitário que estava perdido há dias. Ele agradece por ser resgatado e oferece informações valiosas sobre a ilha.\n");
                Console.dialog("[Explorador]: Estava prestes a desistir, mas vocês apareceram! Posso compartilhar dicas sobre os perigos e oportunidades desta ilha.\n");
                Console.dialog("[Oklama]: Claro, toda informação é bem-vinda. O que você tem para nos contar?\n");
                Console.narrator("[Narrador]: O explorador compartilha informações sobre locais estratégicos, esconderijos de recursos e possíveis desafios na ilha. Agradecidos, vocês continuam a exploração.\n");
                Console.dialog("[Liz]: Com essas informações, nossa jornada fica mais fácil. Vamos ver o que mais podemos encontrar.\n");
                Console.narrator("[Narrador]: Enquanto se aventuram, são surpreendidos por uma emboscada de feras selvagens.\n");
                
                System.out.println("Aperte ENTER para continuar...");
                input.nextLine();

                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Feras Selvagens", 142.5, 53, 100, 50), input, true);
                if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                    if (battleResult == BattleResult.ESCAPE) {
                        int randomGold = (int) (Math.random() * 15) + 1;
                        double gold = character.getGold() * (randomGold / 100.0);
                        System.out.println(randomGold);
                        Console.narrator("As feras selvagens eram ágeis e ferozes demais. Decidem recuar temporariamente.");
                        Console.narrator("Uma das feras conseguiu puxar uma bolsa com dinheiro. Nessa bolsa continha " + gold + " Golds");
                        character.removeGold(gold);
                    } else
                        Console.narrator("Com  trabalho em equipe, vocês conseguem derrotar as feras selvagens, garantindo a segurança no momento.\n");
                    Console.dialogf("[%s]: Essa ilha está cheia de desafios, mas também de oportunidades. Vamos continuar explorando?\n", character.getNickname());
                    Console.dialog("[Liz]: Claro, estamos aqui para desbravar e enfrentar o que vier!\n");
                    Console.narrator("[Narrador]: Enquanto avançam pela ilha, notam uma movimentação estranha em uma área obscura da floresta. Ao se aproximar, deparam-se com um grupo de caçadores furtivos que estavam prejudicando a floresta.\n");
                    
                    System.out.println("Aperte ENTER para continuar...");
                    input.nextLine();

                    Console.clearConsole();
                    battleResult = BattleSystem.startBattle(character, new Enemy("Caçadores Furtivos", 182, 58.5, 130, 50), input, false);
                    if (battleResult == BattleResult.VICTORY) {
                        Console.narrator("[Narrador]: A batalha contra os caçadores é intensa, mas vocês conseguem derrotá-los.\n");
                        Console.dialog("[Oklama]: Esses caçadores estavam causando estragos por aqui. Vamos dar uma olhada mais de perto.\n");
                        Console.dialog("[Narrador]: Após derrotar os caçadores, descobrem que eles estavam contrabandeando itens valiosos da fauna local, como peles exóticas.\n");
                        Console.dialogf("[%s]: Parece que nossa intervenção ajudou a preservar a fauna.\n", character.getNickname());
                        Console.narrator("[Narrador]: Você já esta junto com sua tripulação em grandes e varias aventuras ha anos.\n");
                        Console.dialogf("[%s]: Acho que está na hora de irmos em uma definitiva aventura para ecoar nossa bandeira por todo o mundo!\n", character.getNickname());
                        Console.narrator("[Liz]: Concordo, ja estamos nos aventurando por anos, acho que deve ser a hora de fazer algo grande!\n");
                        Console.dialog("[Oklama]: Para onde vamos?\n");
                        Console.dialog("[Liz]: Temos a ilha de Peniel, A Ilha de Peniel é famosa por ser o lar de uma antiga civilização que acumulou grandes tesouros ao longo dos séculos. A lenda conta que um artefato lendário, capaz de conceder grande poder e riquezas, está escondido em um templo sagrado nesta ilha. Acho que seria uma boa para finalizarmos nossa aventura!\n");
                        Console.dialogf("[%s]: Está decidido, vamos para uma ultima aventura na ilha de Peniel.\n", character.getNickname());
                        Console.narrator("Você finalizou mais uma ilha, estamos muito proximo do fim dessa incrivel saga. Não se esqueça de passar na loja e comprar poções para enfrentar a ilha final!");
                        
                        System.out.println("Aperte ENTER para continuar...");
                        input.nextLine();

                        Console.clearConsole();
                        return true;
                    } else {
                        Console.narrator("O " + character.getNickname()
                                + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS CAÇADRES FURTIVOS!)");
                        Console.sleep(3000);
                        return false;
                   }
                } else {
                    Console.narrator("O " + character.getNickname()
                            + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DAS FERAS SELVAGENS!)");
                    Console.sleep(3000);
                    return false;
                }
            } else {
                Console.narrator("O " + character.getNickname()
                        + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS BANDIDOS!)");
                Console.sleep(3000);
                return false;
            }
        } else {
            Console.narrator("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS VERMES!)");
            Console.sleep(3000);
            return false;
        }
    }
}
