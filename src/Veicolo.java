import java.util.ArrayList;

/**
 * Interfaccia di implemntazione dei due veicoli
 * */
public interface Veicolo {
    /**
     * @return il carburante necessario a percorrere il percorso più veloce
     * */
    int calcoloCarburante(ArrayList<Citta> percorso);

    /**
     * @return la distanza tra 2 città sugli assi x,y
     * */
    int calcolaDistanza(Citta c1, Citta c2);
}
