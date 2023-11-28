package com.rpgjam.utils;

public class Console extends Color {
    private static final int TEMPINMILLISECONDS = 50;

    public static void dialog(String msg) {
        System.out.print(GREEN);
        for (char c : msg.toCharArray()) {
            System.out.print(c);
            sleep(TEMPINMILLISECONDS);
        }
        System.out.println(Color.RESET);
    }

    public static void dialog(String msg, int TEMPINMILLISECONDS) {
        System.out.print(GREEN);
        for (char c : msg.toCharArray()) {
            System.out.print(c);
            sleep(TEMPINMILLISECONDS);
        }
        System.out.println(Color.RESET);
    }

    public static void dialogf(String msg, Object... args) {
        String formattedMsg = String.format(msg, args);

        System.out.print(GREEN);
        for (char c : formattedMsg.toCharArray()) {
            System.out.print(c);
            sleep(TEMPINMILLISECONDS);
        }
        System.out.println(Color.RESET);
    }

    public static void narrator(String msg) {
        System.out.print(WHITE);
        for (char c : msg.toCharArray()) {
            System.out.print(c);
            sleep(TEMPINMILLISECONDS);
        }
        System.out.println(Color.RESET);
    }
    
    public static void enemy(String msg) {
        System.out.print(RED);
        for (char c : msg.toCharArray()) {
            System.out.print(c);
            sleep(TEMPINMILLISECONDS);
        }
        System.out.println(Color.RESET);
    }

    public static void narratorf(String msg, Object... args) {
        String formattedMsg = String.format(msg, args);

        System.out.print(WHITE);
        for (char c : formattedMsg.toCharArray()) {
            System.out.print(c);
            sleep(TEMPINMILLISECONDS);
        }
        System.out.println(Color.RESET);
    }

    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printBlack(String msg) {
        System.out.printf("%s%s%s\n", BLACK, msg, RESET);
    }

    public static void printRed(String msg) {
        System.out.printf("%s%s%s\n", RED, msg, RESET);
    }

    public static void printGreen(String msg) {
        System.out.printf("%s%s%s\n", GREEN, msg, RESET);
    }

    public static void printYellow(String msg) {
        System.out.printf("%s%s%s\n", YELLOW, msg, RESET);
    }

    public static void printBlue(String msg) {
        System.out.printf("%s%s%s\n", BLUE, msg, RESET);
    }

    public static void printPurple(String msg) {
        System.out.printf("%s%s%s\n", PURPLE, msg, RESET);
    }

    public static void printCyan(String msg) {
        System.out.printf("%s%s%s\n", CYAN, msg, RESET);
    }

    public static void printWhite(String msg) {
        System.out.printf("%s%s%s\n", WHITE, msg, RESET);
    }

    public static void printBold(String msg) {
        System.out.printf("%s%s%s\n", BOLD, msg, RESET);
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
