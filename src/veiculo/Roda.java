package veiculo;

public class Roda {
    private boolean calibragem;

    public Roda(){
        calibragem = false;
    }
    public String toString(){
        if(calibragem == true){
            return "Roda calibrada";
        }
        return "Roda não calibrada";
    }
    
    public void set_calibragem(boolean calibragem){
        this.calibragem = calibragem;
    }
    public boolean get_calibragem(){
        return calibragem;
    }
}