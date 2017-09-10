
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
    //atributos
    int tabuleiroPlayer[][] = new int[5][5];
    int tabuleiroPC[][] = new int[5][5];
    String tabuleiroPlayerImpresso[][] = new String[5][5];
    String tabuleiroPCImpresso[][] = new String[5][5];
    int acertosPC = 0;
    int acertosPlayer = 0;
    int tentativas = 0;
    int navios = 0;
    int finalizar = 0;

    //Inicia e reinicia os tabuleiros do player e do pc 
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

    //Inserir os navios do player  
    void inserirNavio(int x, int y) {
        //valida se a coordenada ja esta ocupada
        if (tabuleiroPlayer[x][y] != -1) {
            System.out.println("Esta coordenada já está ocupada! \n");
        } else {
            tabuleiroPlayer[x][y] = 1;
            navios += 1;
        }
    }
    
    //inserir os navios do pc
    void inserirNavioPC() {
        Random random = new Random();
        int i;
        int j;
        i = random.nextInt(5);
        j = random.nextInt(5);
        
        //valida se eh possivel inserir o navio na coordenada gerada aleatoriamente
        if (tabuleiroPC[i][j] == -1) {
            tabuleiroPC[i][j] = 1;
        } else {
            inserirNavioPC();
        }

    }

    //este metodo preenche o tabuleiro que eh mostrado ao jogador
    //o tabuleiro impresso serve apenas como uma referencia visual, enquanto que o outro eh responsavel por boa parte das intereacoes    
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

    //metodo para atirar
    //mostra o tabuleiro do pc e do player a cada tiro
    int atirar(int x, int y) {
        
        //verifica se afundou a embarcacao do pc
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

    //metodo para o pc atirar
    //mostra o tabuleiro do player e do pc a cada tiro
    void atirarPC() {
        Random random = new Random();
        int x;
        int y;
        x = random.nextInt(5);
        y = random.nextInt(5);
        //verifica se afundou a embarcacao do player
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
    
    //metodo para verificar quem foi o vencedor
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
