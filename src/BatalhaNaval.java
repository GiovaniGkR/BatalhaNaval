
import java.util.Scanner;



/**
 * @author Giovani
 * Nesta batalha naval, os navios possuem o tamanho de 1x1.
 * Eh possivel ter no maximo 3 navios.
 * Vance quem afundar todas as embarcacoes adversarias.
 * o player eh sempre o primeiro a jogar.
 */
public class BatalhaNaval {
    Tabuleiro tab = new Tabuleiro();
    Scanner sc = new Scanner(System.in);
    int op = 0;
    
    
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        BatalhaNaval bn = new BatalhaNaval();       
        
        //menu
        do {
        System.out.println("Menu: ");
        System.out.println("1. INICIAR");
        System.out.println("2. INSERIR NAVIO");
        System.out.println("3. ATIRAR");
        System.out.println("9. SAIR");
        System.out.println("Digite a opção: ");
        bn.op = Integer.parseInt(sc1.nextLine());
        
        
        switch(bn.op) {
            case 1:
                bn.inicializar();
                System.out.println("Inicializando o tabuleiro");            
                break;
                
            case 2:
                bn.inserirNavio();
                break;

            case 3:
                bn.atirar();
                break;
                
            case 9:
                System.out.println("Finalizando");
                break;                
                
            default:
                System.out.println("Opcao invalida");
        }
        
        }while(bn.op != 9);
    }

    void inicializar(){
        tab.inicializaTabuleiro();
        tab.preencherTabuleiro();
        //tab.afundar = 0;
    }
    
    void inserirNavio(){
        BatalhaNaval bn = new BatalhaNaval();
        int x = 0;
        int y = 0;
        
        if (tab.navios != 3){
        System.out.println("Digite a coordenada X do seu navio(de 1 a 5)");
        x = Integer.parseInt(sc.nextLine()) - 1;
        if ((x > 5) || (x < 0)){
            System.out.println("Entrada inválida");
            bn.inserirNavio();
        }
        
        System.out.println("Digite a coordenada Y do seu navio(de 1 a 5)");
        y = Integer.parseInt(sc.nextLine()) - 1;
        if ((y > 5) || (y < 0)){
            System.out.println("");
            System.out.println("Entrada inválida");
            bn.inserirNavio();
        }        
        
        tab.inserirNavio(x, y);
        tab.inserirNavioPC();
        }
        
        else {
            System.out.println("");
            System.out.println("Voce ja colocou o maximo de navios possiveis");
        }
    }
    
    void atirar(){
        BatalhaNaval bn = new BatalhaNaval();
        int x = 0;
        int y = 0;

        do {
            System.out.println("");
            System.out.println("Digite a coordenada X do seu tiro(de 1 a 5)");
            x = Integer.parseInt(sc.nextLine()) - 1;
                if ((x > 5) || (x < 0)){
                System.out.println("Entrada inválida");
                bn.atirar();
            }
            System.out.println("");
            System.out.println("Digite a coordenada Y do seu tiro(de 1 a 5)");
            y = Integer.parseInt(sc.nextLine()) - 1;
                if ((y > 5) || (y < 0)){
                System.out.println("Entrada inválida");
                bn.atirar();
            }
            tab.atirar(x, y);
            
            if (tab.finalizar != 1) {
                System.out.println("Vez do PC: ");
                tab.atirarPC();
            }

        } while (tab.finalizar != 1);
           
    }
}
   


