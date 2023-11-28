package com.rpgjam.story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoatAnimation {

    public static void boatTrasition(int durationInSeconds) {
        int boatX = 0;
        int lineX = 0;
        for(int i = 0; i<durationInSeconds * 10; i++) {
            // Limpar o terminal
            clearScreen();
            int terminalWidth = getTerminalWidth();
            // Atualizar a posição do barco para criar a animação
            boatX += 2;
            if (boatX > terminalWidth) {
                boatX = 0; // Reiniciar a posição do barco quando atinge a borda direita
            }

            lineX = terminalWidth + 21;
            drawBoatAndLine(boatX, lineX);

            // Aguardar um curto período de tempo antes de atualizar a próxima frame
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen();
        }
    }

    private static void drawBoatAndLine(int boatX, int lineX) {
        // Desenha o barco e fazer animação dele andando
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < boatX; j++) {
                System.out.print(" ");
            }
            if (i == 0) {
                System.out.println("     v  ~.      v");
            } else if (i == 1) {
                System.out.println("        /|");
            } else if (i == 2) {
                System.out.println("       / |          v");
            } else if (i == 3) {
                System.out.println("v     /__|__");
            } else if (i == 4) {
                System.out.print("    \\--------/\n");
            }
        }

        // Desenhar a linha com tamanho correto
        String line = "~";
        for (int i = 1; i < lineX; i++){
            line += "~";
        }
        System.out.println(line);
    }

    private static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();
        // Obter largura do terminal em sistemas windows
        if (os.contains("win") || os.contains("windows 10")) {
            try {
                Process process = new ProcessBuilder("cmd", "/c", "mode", "con").start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Columns:")) {
                        return Integer.parseInt(line.substring(8).trim());
                    }
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        } else { //Obter largura do terminal em outros sistemas
            try {
                Process process = new ProcessBuilder("sh", "-c", "tput cols").start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String colsLine = reader.readLine();

                if (colsLine != null) {
                    return Integer.parseInt(colsLine.trim()) - 21;
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
        // Caso o sistema nao seja reconhecido retorna um valor padrao.
        return 80;
    }

    private static void clearScreen() {
        // Limpar o terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
