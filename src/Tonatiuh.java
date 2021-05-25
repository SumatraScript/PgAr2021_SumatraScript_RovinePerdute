import java.util.ArrayList;

public class Tonatiuh implements Veicolo{
    private int carburante;

    @Override
    public int calcoloCarburante(ArrayList<Citta> percorso) {
        int carburante=0;
        for(int i=0;i<percorso.size()-1;i++){
            carburante+=calcolaDistanza(percorso.get(i), percorso.get(i++));
        }
        return carburante;
    }

    @Override
    public int calcolaDistanza(Citta c1, Citta c2){
        return (int)Math.round(Math.sqrt(Math.pow(c1.getCoord().getX() - c2.getCoord().getX(),2) + Math.pow(c1.getCoord().getY() - c2.getCoord().getY(),2)));
    }
}
