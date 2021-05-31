import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Grafo {
    private Map<Citta,Double> mappa;

    public Map<Citta, Double> getMappa() {
        return mappa;
    }

    public void setPut(Citta citta, double valore) {
        this.mappa.put(citta,valore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grafo grafo = (Grafo) o;
        return Objects.equals(mappa, grafo.mappa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mappa);
    }

    public Grafo(ArrayList<Citta> cittadine) {
        this.mappa=new HashMap<>();
        mappa.put(cittadine.get(0),0.0);
        for(int i=1;i<cittadine.size();i++){
            mappa.put(cittadine.get(i),Double.MAX_VALUE);
        }
    }
}
