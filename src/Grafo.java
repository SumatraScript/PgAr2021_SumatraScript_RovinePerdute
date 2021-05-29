import java.util.HashSet;
import java.util.Set;

public class Grafo {
    private Set<Citta> nodi = new HashSet<>();

    public void addNode(Citta CittaAgiunta) {
        nodi.add(CittaAgiunta);
    }

    public Set<Citta> getNodi() {
        return nodi;
    }

    public void setNodi(Set<Citta> nodi) {
        this.nodi = nodi;
    }

}
