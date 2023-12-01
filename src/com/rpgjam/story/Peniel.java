package com.rpgjam.story;

import java.util.Scanner;

import com.rpgjam.Character;
import com.rpgjam.battle.BattleResult;
import com.rpgjam.battle.BattleSystem;
import com.rpgjam.enemy.Enemy;
import com.rpgjam.utils.Console;

public class Peniel {
    private Character character;
    private Scanner input = new Scanner(System.in);

    public Peniel(Character character) {
        this.character = character;
    }

    public boolean start() {
        BoatAnimation.boatTrasition(10);
        Console.clearConsole();
        Console.narrator("[Narrador]: A jornada até a Ilha de Peniel é desafiadora, mas ao chegarem, vocês se deparam com uma paisagem majestosa, repleta de ruínas antigas e segredos enterrados.\n");
        Console.narrator("[Narrador]: Rumores sobre um artefato lendário circulam entre os habitantes locais, alimentando as esperanças de sua tripulação em obter riquezas incomparáveis.\n");
        Console.dialog("[Liz]: Olhem só para esse lugar! Parece que estamos em uma era antiga.\n");
        Console.dialog("[Oklama]: Espero que esse artefato realmente exista e seja tão valioso quanto as lendas dizem.\n");
        Console.dialog("[Morador Local]: Bem-vindos, forasteiros! Em busca do lendário tesouro?\n");
        Console.dialogf("[%s]: Exatamente! O que vocês podem nos contar sobre isso?\n", character.getNickname());
        Console.dialog("[Morador Local]: Diz a lenda que está guardado no templo, protegido por guardiões ancestrais.\n");
        Console.narrator("[Narrador] A atmosfera na entrada do templo é de misterio e perigo, enquanto vocês se preparam para enfrentar os guardiões ancestrais.\n");
        Console.dialog("[Liz]: Guardiões ancestrais, huh? Devem ser fortes. Estejam prontos para qualquer coisa, pessoal.\n");
        Console.dialogf("[%s]: Não subestimem a força deles. Vamos com cuidado.\n", character.getNickname());
        Console.narrator("[Narrador]: Ao explorar as ruínas, vocês se deparam com a primeira adversidade: guardiões ancestrais protegendo o caminho para o templo sagrado.\n");
        Console.enemy("[Guardião Ancestral]: Apenas os corajosos podem passar por aqui. Quem são vocês?\n");
        Console.dialogf("[%s]: Somos a tripulação %s. Estamos em busca do artefato lendário.\n", character.getNickname(), character.getBevy());
        Console.enemy("[Guardião Ancestral]: Se quiserem passar, terão que provar sua força.\n");

        System.out.println("Aperte ENTER para continuar...");
        input.nextLine();

        Console.clearConsole();
        BattleResult battleResult = BattleSystem.startBattle(character, new Enemy("Guardiões Ancestrais", 240, 77, 120, 60), input, false);
        if (battleResult == BattleResult.VICTORY) {
            Console.dialog("[Oklama]: Esses guardiões são mais resistentes do que eu imaginava.\n");
            Console.dialog("[Liz]: E parece que a jornada está apenas começando. Continuem com cuidado pessoal.\n");
            Console.dialog("[Morador Local]: Poucos ousam desafiar os guardiões, Vocês são corajosos.\n");
            Console.dialogf("[%s]: A recompensa vale a pena. Vamos em frente, mas eu diria que você é mais por está nos acompanhando! Você não tem medo?.\n", character.getNickname());
            Console.dialog("[Morador Local]: Nunca perderia uma aventura historica como essa, quem sabe não entro para a historia, como o historiador que guiou o dono do artefato divino!\n");
            Console.dialogf("[%s]: Haha, você é muito engraçado, creio que fez a escolha certa, porque sairei daqui e meu nome ecoará por toda vwood!\n", character.getNickname());
            Console.narrator("[Narrador] À medida que se aproximavam do centro do tempo, a prese\n");
            Console.enemy("[Guardião]: Aqueles que desejam o tesouro devem provar ser merecedores. Estão prontos?\n");
            Console.dialog("[Oklama]: Mais do que nunca!\n");
            
            System.out.println("Aperte ENTER para continuar...");
            input.nextLine();

            Console.clearConsole();
            battleResult = BattleSystem.startBattle(character, new Enemy("Guardião", 260, 79, 163, 35), input, false);
            if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                Console.sleep(2000);
                Console.clearConsole();
                Console.dialogf("[%s]: Seja lá quem você for, a porta agora está aberta.\n", character.getNickname());
                Console.dialog("[Morador Local]: Vocês realmente derrotaram o Guardião do Templo? Impressionante!\n");
                Console.narrator("[Narrador]: O caminho os leva a enfrentar caçadores rivais que também estavam atras do tesouro lendário.\n");
                Console.dialog("[Liz]: Esses caçadores parecem não querer dialogar.\n");
                Console.dialogf("[%s]: Não podemos deixar que atrapalhem nossa busca. Estejam prontos para o confronto.\n", character.getNickname());
                Console.enemy("[Caçador Rival]: Parece que chegaram tarde demais. Essa riqueza será nossa!\n");
                Console.dialogf("[%s]: Não conte com isso!\n", character.getNickname());

                System.out.println("Aperte ENTER para continuar...");
                input.nextLine();

                Console.clearConsole();
                battleResult = BattleSystem.startBattle(character, new Enemy("Caçador", 150, 50, 100, 50), input, false);
                if (battleResult == BattleResult.VICTORY || battleResult == BattleResult.ESCAPE) {
                    Console.sleep(2000);
                    Console.clearConsole();
                    Console.dialog("[Oklama]: Cada desafio superado nos aproxima do tesouro.\n");
                    Console.dialog("[Morador Local]: Os verdadeiros merecedores prevalecerão. Boa sorte, forasteiros apartir daqui não poderei acompanhar vocês, espero pelo retorno triufante! Se preparem, pois estão proximos do guardião final.\n");
                    Console.dialogf("[%s]: Obrigado por nos guiar até aqui, pode ter certeza que voltaremos com o tesouro!\n", character.getNickname());
                    Console.narrator("[Narrador]: Enquanto vocês vão avançando o ar vai ficando mais pesado cada vez que ficam mais proximo do centro do templo.\n");
                    Console.narrator("[Narrador]: Uma ameaça preenche o ar, quando a figura imponente do Guardião Final se materializa à frente.\n");
                    Console.enemy("[Guardião Final]: Aqueles que chegaram até aqui devem provar sua dignidade e bravura diante de mim.\n");
                    Console.dialog("[Liz]: Mais um? Espero que este seja o último desafio.\n");
                    Console.dialogf("[%s]: Esse guardião deve ser o final, so pela sua presença exala uma áurea poderosa, pessoal se prepare, esse será nosso ultimo desafio!\n", character.getNickname());
                    Console.dialog("[Oklama]: Estava esperando por isso!\n");
                    Console.enemy("[Guardião Final]: Vocês estão confiantes, eu admito que vocês tem muita corajem e ego alto, mas não consiguiram tirar o tesouro daqui, estou guardando esse templo a mais de mil anos, e nunca ninguem conseguiu!\n");
        
                    System.out.println("Aperte ENTER para continuar...");
                    input.nextLine();

                    Console.clearConsole();
                    battleResult = BattleSystem.startBattle(character, new Enemy("Guardião Final", 350, 120, 500, 50), input, false);
                    if (battleResult == BattleResult.VICTORY) {
                        Console.sleep(2000);
                        Console.clearConsole();
                        Console.narrator("[Narrador]: Apos a longa e ardua batalha contra o guardião final, vocês finalmente o derrotam e de repente surge uma tumba no local do corpo do guardião!\n");
                        Console.dialogf("[%s]: Acho que nosso tesouro deve esta ai, espero que a lenda seja verdadeira!\n", character.getNickname());
                        Console.dialog("[Liz]: Vamos abrir isso logo, não vejo a hora de ver oque conseguimos!\n");
                        Console.narrator("[Narrador]: Ao abrir a tumba, vocês se deparam com muito ouro, calices e itens preciosos, mas entre os itens tinha um que se destaca, sim, esse era o tão desejado tesouro, um calice banhado a ouro com 6 pedras de ferro negro, um minerio extinto, o qual não era visto a centenas de anos!\n");
                        Console.dialog("[Liz]: Incrivel, além de todo esse tesouro, um calice banhado a ouro com 6 pedras de ferro negro, so esse calice deve vale um valor imensuravel, com apenas 1 dessas pedras pode ser feita uma das melhores armas!\n");
                        Console.dialogf("[%s]: Primeiro vamos sair daqui!\n", character.getNickname());
                        Console.narrator("[Narrador]: Vocês voltam para o vilarejo local!\n");
                        Console.dialogf("[Morador Local]: Oi pessoal, vejo que realmente consiguiram, irei ajuda-los a ecoar o nome de vocês por toda vwood, como os piratas dos(as) %s que conseguiu o tesouro da ilha Peniel.\n", character.getBevy());
                        Console.dialogf("[%s]: Fico agradecido, infelizmente essa será nossa ultima aventura!\n", character.getNickname());
                        Console.dialog("[Liz]: Pelo menos conseguimos alcançar nosso objetivo!\n");
                        Console.narratorf("[Narrador]: Com isso a aventura da tripulação %s foi encerrada.", character.getBevy());

                        System.out.println("Aperte ENTER para continuar...");
                        input.nextLine();

                        Console.clearConsole();
                        return true;
                    } else {
                        Console.narrator("O " + character.getNickname()
                                + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO GUARDIÃO FINAL!)");
                        Console.sleep(3000);
                        return false;
                   }
                } else {
                    Console.narrator("O " + character.getNickname()
                            + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO CAÇADOR!)");
                    Console.sleep(3000);
                    return false;
                }
            } else {
                Console.narrator("O " + character.getNickname()
                        + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DO GUARDIÃO!)");
                Console.sleep(3000);
                return false;
            }
        } else {
            Console.narrator("O " + character.getNickname()
                    + " infelizmente foi derrotado, sua jornada acaba aqui! (LA ELE MIL VEZES, LEVOU POR TRAZ DOS GUARDIÕES ANCESTRAIS!)");
            Console.sleep(3000);
            return false;
        }
    }
}
