
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Giovani
 */
public class Tabuleiro {

    int tabuleiroPlayer[][] = new int[5][5];
    int tabuleiroPC[][] = new int[5][5];
    String tabuleiroPlayerImpresso[][] = new String[5][5];
    String tabuleiroPCImpresso[][] = new String[5][5];
    int acertosPC = 0;
    int acertosPlayer = 0;
    int tentativas = 0;
    int navios = 0;
    int finalizar = 0;

    //iniciar e reinicar o tabuleiroPlayer que controla os navios e tiros    
    void inicializaTabuleiro() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiroPlayer[i][j] = -1;
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiroPC[i][j] = -1;
            }
        }
    }

    //Inserir os navios    
    void inserirNavio(int x, int y) {
        if (tabuleiroPlayer[x][y] != -1) {
            System.out.println("Esta coordenada já está ocupada! \n");
        } else {
            tabuleiroPlayer[x][y] = 1;
            navios += 1;
        }
    }

    void inserirNavioPC() {
        Random random = new Random();
        int i;
        int j;
        i = random.nextInt(5);
        j = random.nextInt(5);

        if (tabuleiroPC[i][j] == -1) {
            tabuleiroPC[i][j] = 1;
        } else {
            inserirNavioPC();
        }

    }

    //Este eh o tabuleiroPlayer que sera mostrado ao jogador    
    void preencherTabuleiro() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiroPlayerImpresso[i][j] = " ~ ";
                tabuleiroPCImpresso[i][j] = " ~ ";
            }
        }
    }

    //imprimir o tabuleiroPlayer e do pc    
    void imprimirTabuleiro() {
        //imprimir o tabuleiro do player
        System.out.println("");
        System.out.println("Tabuleiro do player: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tabuleiroPlayerImpresso[i][j] + " ");
            }
            System.out.println(" ");
        }

        //imprimir o tabuleiro do pc
        System.out.println("");
        System.out.println("Tabuleiro do PC: ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(tabuleiroPCImpresso[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    //metodo para atirar. Tambem chama o imprimir tabuleiroPlayer apos cada tiro
    int atirar(int x, int y) {

        if (tabuleiroPC[x][y] != -1) {
            System.out.println("");
            System.out.println("Você afundou a embarcação");
            tabuleiroPCImpresso[x][y] = " * ";
            imprimirTabuleiro();
            acertosPlayer += 1;
            tentativas += 1;
            finalizar();
            return acertosPlayer;


        } else {
            System.out.println("");
            System.out.println("Você errou o tiro");
            tabuleiroPCImpresso[x][y] = " x ";
            imprimirTabuleiro();
            tentativas += 1;
            return acertosPlayer;
        }
    }

    void atirarPC() {
        Random random = new Random();
        int x;
        int y;
        x = random.nextInt(5);
        y = random.nextInt(5);
        if (tabuleiroPlayer[x][y] != -1) {
            System.out.println("");
            System.out.println("O PC afundou sua embarcação");
            tabuleiroPlayerImpresso[x][y] = " * ";
            imprimirTabuleiro();
            acertosPC += 1;
            finalizar();
                        
        } else {
            System.out.println("");
            System.out.println("O PC errou o tiro");
            tabuleiroPlayerImpresso[x][y] = " x ";
            imprimirTabuleiro();
        }

    }
    
    void finalizar(){
        if (acertosPlayer == navios) {
            System.out.println("");
            System.out.println("VOCE AFUNDOU TODAS AS EMBARCACOES INIMIGAS");
            System.out.println("Número de tentativas: " + tentativas);
            System.out.println("");
            finalizar = 1;
            
        } else if (acertosPC == navios) {
            System.out.println("");
            System.out.println("O PC AFUNDOU TODAS AS SUAS EMBARCACOES");
            System.out.println("");
            finalizar = 1;
        }
    }
}
