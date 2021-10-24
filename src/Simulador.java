import java.util.Scanner;
import veiculo.ListaEncadeadaCarro;

public class Simulador{
    public static void main(String[] args) {
        tela s = new tela();
        
        ListaEncadeadaCarro lista = new ListaEncadeadaCarro();
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        int key;

        do{
            s.menu();
            System.out.print("Escolha: ");
            escolha = teclado.nextInt();

            switch(escolha){
                case 1:
                    lista.add_car();
                    s.limpar_terminal();
                    break;
                case 2:
                    System.out.print("Id do carro: ");
                    key = teclado.nextInt();
                    lista.remove_car(key);  
                    s.limpar_terminal();
                    break;
                case 3:
                    System.out.print("Id do carro: ");
                    key = teclado.nextInt();
                    System.out.println("Quantidade de combustivel: ");
                    double combustivel = teclado.nextDouble();
                    lista.abastecer_carro(key, combustivel);
                    s.limpar_terminal();
                    break;
                case 4:
                    System.out.print("Id do carro: ");
                    key = teclado.nextInt();
                    lista.movimentar_carro(key);
                    s.limpar_terminal();
                    break;
                case 5:
                    lista.movimentar_carros();
                    s.limpar_terminal();
                    break;
                case 6:
                    System.out.print("Id do carro: ");
                    key = teclado.nextInt();
                    System.out.print("Roda: ");
                    int roda = teclado.nextInt();
                    lista.calibrar_esvaziar_carro(key, roda, true);
                    s.limpar_terminal();
                    break;
                case 7:
                    lista.calibrar_esvaziar_todos_carros(true);
                    s.limpar_terminal();
                    break;
                case 8:
                    s.limpar_terminal();
                    lista.imprimir_carros();
                    break;
                case 9:
                    s.limpar_terminal();
                    lista.imprimir_dados_carros();
                    break;
                default:
                    System.out.println("Digite um escolha valida");         
            }
        }while(escolha != 11);

        teclado.close();
    }
}

class tela{
    public void menu(){
        System.out.println("1 - Incluir Veiculo\n2 - Remover Veiculo\n3 - Abastecer Veiculo\n4 - Movimentar Veiculo\n5 - Movimentar Todos os Veiculos");
        System.out.println("6 - Calibrar roda de um Veiculo\n7 - Calibrar todos Veiculos\n8 - Imprimir Veiculos\n9 - Imprimir dados dos Veiculos");
        System.out.println("10 - Corrida\n11 - Sair");
    }
    public void limpar_terminal(){
        if(System.getProperty("os.name").contains("Windows")){
            try {
                new ProcessBuilder("cmd","/c", "cls").inheritIO().start().waitFor();
            }catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        else{
            try{
                Runtime.getRuntime().exec("clear");
            }
            catch(Exception e){
                System.err.println(e.toString());
            }
        }
    }
}