import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grafo {
    private Map<Citta,Double> mappa;

    public Map<Citta, Double> getMappa() {
        return mappa;
    }

    public void setPut(Citta citta, double valore) {
        this.mappa.put(citta,valore);
    }

    public Grafo(ArrayList<Citta> cittadine) {
        this.mappa=new HashMap<>();
        mappa.put(cittadine.get(0),0.0);
        for(int i=1;i<cittadine.size();i++){
            mappa.put(cittadine.get(i),Double.MAX_VALUE);
        }
    }
}
