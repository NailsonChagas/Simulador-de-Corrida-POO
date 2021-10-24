package veiculo;

class Node{
    private int key;
    private Carro dataCarro;
    private Node previous, next;

    public Node(){
        dataCarro = new Carro();
        key = dataCarro.get_id();
        previous = next = null;
    }

    public Carro get_carro(){
        return dataCarro;
    }
    public int get_key(){
        return key;
    }
    public void set_next(Node next){
        this.next = next;
    }
    public Node get_next(){
        return this.next;
    }
    public void set_previous(Node previous){
        this.previous = previous;
    }
    public Node get_previous(){
        return this.previous;
    }
}

public class ListaEncadeadaCarro {
    private Node head;

    public ListaEncadeadaCarro(){
        head = null;
    }
    public String toString(){
        String retorno = "Lista:";
        Node aux = head;

        while(aux != null){
            retorno += " " + aux.get_key();
            aux = aux.get_next();
        }

        return retorno;
    }

    public void add_car(){
        Node newCar = new Node();

        if(head == null){
            head = newCar;
        }
        else{
            Node aux = head;

            while(aux.get_next() != null){
                aux = aux.get_next();
            }

            aux.set_next(newCar);
            newCar.set_previous(aux);
        }
    }
    public boolean remove_car(int key){
        if(head != null){
            Node aux = head;

            while(aux != null){
                if(aux.get_key() == key){
                    if(aux.get_next() == null){//ultimo elemento
                        aux.get_previous().set_next(null);
                        return true;
                    }
                    else if(aux.get_previous() == null){//primeiro elemento
                        head = aux.get_next();
                        aux.get_next().set_previous(null);
                        return true;
                    }
                    else{//meio
                        aux.get_previous().set_next(aux.get_next());
                        aux.get_next().set_previous(aux.get_previous());
                        return true;
                    }
                }
                aux = aux.get_next();
            }
        }
        return false;
    }
    public void calibrar_esvaziar_carro(int key, int roda,boolean calibragem){
        Carro aux = search_car(key);

        if(aux != null){
            aux.calibrar_esvaziar_roda(roda, calibragem);
        }
        else{
            System.out.println("Erro: Carro não existe na lista");
        }
    }
    public void calibrar_esvaziar_todos_carros(boolean calibragem){
        Node aux = head;

        while(aux != null){
            aux.get_carro().calibrar_esvaziar_todas_rodas(calibragem);
            aux = aux.get_next();
        }
    }
    public Carro search_car(int key){
        Node aux = head;

        while(aux != null){
            if(aux.get_key() == key){
                return aux.get_carro();
            }
            aux = aux.get_next();
        }
        return null;
    }
    public void abastecer_carro(int key, double combustivel){
        Carro aux = search_car(key);

        if(aux != null){
            aux.abastecer_carro(combustivel);
        }
        else{
            System.out.println("Erro: Carro não existe na lista");
        }
    }
    public void movimentar_carro(int key){
        Carro aux = search_car(key);

        if(aux != null){
            aux.movimentar_carro();
        }
        else{
            System.out.println("Erro: Carro não existe na lista");
        }
    }
    public void movimentar_carros(){
        Node aux = head;

        while(aux != null){
            aux.get_carro().movimentar_carro();
            aux = aux.get_next();
        }
    }
    public void imprimir_carros(){
        Node aux = head;

        while(aux != null){
            aux.get_carro().imprimir_carro();
            aux = aux.get_next();
        }
    }
    public void imprimir_dados_carros(){
        Node aux = head;

        while(aux != null){
            System.out.println(aux.get_carro());
            aux = aux.get_next();
        }
    }
    public void preparar_carros(){
        Node aux = head;

        while(aux != null){
            aux.get_carro().calibrar_esvaziar_todas_rodas(true);
            aux.get_carro().set_ipva(true);
            aux = aux.get_next();
        }
    }
}
