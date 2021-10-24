package veiculo;

import java.util.Random;

public class Carro {
    private int id;
    private int distancia;
    private double combustivel;
    private boolean ipva;
    private Roda[] rodas;

    public Carro(){
        Random r = new Random();
        rodas = new Roda[4];

        id = r.nextInt(1000);
        ipva = r.nextBoolean();
        combustivel = 3.5;

        for(int i = 0; i < 4; i++){
            rodas[i] = new Roda();
            rodas[i].set_calibragem(r.nextBoolean());
        }
    }
    public String toString(){
        String aux = "";

        aux = "Carro_Id: " + id + "| Distancia percorrida: " + distancia + " | Combustivel: " + combustivel + "\n";
        aux += "IPVA pago: " + ipva + " | Rodas calibrada: ";
        for(int i = 0; i < 4; i++){
            if(rodas[i].get_calibragem() == true){
                aux += i + " ";
            }
        }
        aux += "\n----------------------------------------------------------\n";
        return aux;
    }
    
    public int get_id(){
        return id;
    }
    public void calibrar_esvaziar_roda(int roda, boolean calibrada){
        if(roda >= 0 && roda <= 4){
            rodas[roda].set_calibragem(calibrada);
        }
        else{
            System.out.println("Erro: Roda selecionada não é valida");
        }
    }
    public void calibrar_esvaziar_todas_rodas(boolean calibrada){
        for(int i = 0; i < 4; i++){
            rodas[i].set_calibragem(calibrada);
        }
    }
    public void abastecer_carro(double combustivel){
        this.combustivel += combustivel;
    }
    public void set_ipva(boolean a){
        this.ipva = a;
    }
    private boolean verifica_se_pode_mover(){
        if(ipva == true && combustivel >= 0.55){
            int cont = 0;

            for(Roda r : rodas){
                if(r.get_calibragem() == true) cont++;
            }

            if(cont == 4){
                return true;
            }
        }
        return false;
    }
    public void movimentar_carro(){
        if(verifica_se_pode_mover() == true){
            distancia += 5;
            combustivel -= 0.55;
        }
    }
    public void imprimir_carro(){
        String esp = new String();
        String carro = "";

        for(int i = 0; i < distancia; i++){
            esp += "   ";
        }
        
        carro += esp + "  ______\n" + esp + " /|_||_\\`.__\n" + esp + "(   _    _ _\\ \n" + esp + "=`-(_)--(_)-'\n\n";

        /*System.out.print(esp + "  ______\n");
        System.out.print(esp + " /|_||_\\`.__\n");
        System.out.print(esp + "(   _    _ _\\ \n");
        System.out.print(esp + "=`-(_)--(_)-'\n\n");*/
        System.out.println(carro);
    }
}
