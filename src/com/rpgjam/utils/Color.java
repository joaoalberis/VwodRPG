package com.rpgjam.utils;

public class Color {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BOLD = "\u001B[1m";

    public static void printBlack(String msg) {
        System.out.printf("%s%s%s", BLACK, msg, RESET);
    }

    public static void printRed(String msg) {
        System.out.printf("%s%s%s", RED, msg, RESET);
    }

    public static void printGreen(String msg) {
        System.out.printf("%s%s%s", GREEN, msg, RESET);
    }

    public static void printYellow(String msg) {
        System.out.printf("%s%s%s", YELLOW, msg, RESET);
    }

    public static void printBlue(String msg) {
        System.out.printf("%s%s%s", BLUE, msg, RESET);
    }

    public static void printPurple(String msg) {
        System.out.printf("%s%s%s", PURPLE, msg, RESET);
    }

    public static void printCyan(String msg) {
        System.out.printf("%s%s%s", CYAN, msg, RESET);
    }

    public static void printWhite(String msg) {
        System.out.printf("%s%s%s", WHITE, msg, RESET);
    }

    public static void printBold(String msg) {
        System.out.printf("%s%s%s", BOLD, msg, RESET);
    }
}
