import java.util.HashMap;
import java.util.Map;

public class Nodo {
    Map<Citta,Integer> mappa;

    public Nodo(Map<Citta, Integer> mappa) {
        this.mappa = new HashMap<>();
    }

    public void setPut(Citta citta, int valore) {
        this.mappa.put(citta,valore);
    }

    public Map<Citta, Integer> getMappa() {
        return mappa;
    }
}
