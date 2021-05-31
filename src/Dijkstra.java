import java.util.*;

public class Dijkstra {
    public static void cercaPercorsiPossibili(Grafo grafo) {
        ArrayList<Citta> cittaNonVisitate=new ArrayList<>();
        Map<Citta, String> tracciaPercorso= new HashMap<>();

        //Inizializzazione citta non visitate
        for(Map.Entry<Citta,Double> citta: grafo.getMappa().entrySet()){
            cittaNonVisitate.add(citta.getKey());
            tracciaPercorso.put(citta.getKey(), "v");
        }

        ArrayList<Citta> cittaVisitate=new ArrayList<>();
        ArrayList<Nodo> nodini=new ArrayList<>();


        Citta cittaAttuale = null;
        while(cittaNonVisitate.size()!=0) {
            cittaAttuale=cercaCittaAttuale(grafo,cittaVisitate);
            cittaVisitate.add(cittaAttuale);
            dijkstra(grafo,cittaAttuale,cittaVisitate);
            cittaNonVisitate.remove(cittaAttuale);

        }
        System.out.println("vitelle");
    }
    public static void dijkstra(Grafo grafo,Citta citta,ArrayList<Citta> cittaVisitate){
        for(Map.Entry<Citta,Double> nodi: citta.getMappaMetztli().entrySet()){
            for(Map.Entry<Citta,Double> nodoGrafo: grafo.getMappa().entrySet()){
                if(nodoGrafo.getKey().equals(nodi.getKey()) && !cittaVisitate.contains(nodoGrafo.getKey())){
                    double inserimento=0;
                    if(grafo.getMappa().get(cittaVisitate.get(cittaVisitate.size()-1))==Double.MAX_VALUE) {
                        inserimento = nodi.getValue();
                    }
                    else {
                        inserimento = nodi.getValue() + grafo.getMappa().get(cittaVisitate.get(cittaVisitate.size() - 1));
                    }
                    grafo.setPut(nodoGrafo.getKey(),inserimento);
                }
            }
        }
    }

    public static Citta cercaCittaAttuale(Grafo grafo, ArrayList<Citta> cittaVisitate) {
        double min = Double.MAX_VALUE;
        Citta cittaAttuale = null;
        for (Map.Entry<Citta, Double> citta : grafo.getMappa().entrySet()) {
            if (citta.getValue() < min && !cittaVisitate.contains(citta.getKey())) {
                min = citta.getValue();
                cittaAttuale = citta.getKey();
            }
        }
        return cittaAttuale;
    }
}