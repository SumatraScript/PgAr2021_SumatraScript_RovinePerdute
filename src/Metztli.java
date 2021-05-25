import java.util.ArrayList;

public class Metztli implements Veicolo{

    @Override
    public int calcoloCarburante(ArrayList<Citta> percorso){
        int carburante=0;
        for(int i=0;i<percorso.size()-1;i++){
            carburante+=calcolaDistanza(percorso.get(i), percorso.get(i++));
        }
        return carburante;
    }

    @Override
    public int calcolaDistanza(Citta c1, Citta c2) {
        return Math.round(Math.abs(c1.getCoord().getH()-c2.getCoord().getH()));
    }
}
