import java.util.*;

public class Dijkstra {
    public static double getDistanzaTotalePercorsaMetztli() {
        return distanzaTotalePercorsaMetztli;
    }

    private static double distanzaTotalePercorsaMetztli =0;

    public static ArrayList<Citta> cercaPercorsoMigliore(Grafo grafo, Citta origine){

        Citta cittaAttuale= cercaCittaAttuale(grafo);
        ArrayList<Citta> percorso=new ArrayList<>();

        percorso.add(origine);
        while(!cittaAttuale.getNome().equals("Rovine Perdute")) {
            cittaAttuale = distanzaMinoreCittaAuttuale(cittaAttuale, grafo);
            percorso.add(cittaAttuale);
        }
        System.out.println("Inutike");
        return percorso;
    }

    public static Citta distanzaMinoreCittaAuttuale(Citta citta, Grafo grafo){
        double peso=Double.MAX_VALUE;
        Citta cittaAdiacente=null;
        for(Map.Entry<Citta, Double> cittaCandidata: citta.getMappaMetztli().entrySet()){
            if(cittaCandidata.getValue()<peso){
                peso = cittaCandidata.getValue();
                cittaAdiacente= cittaCandidata.getKey();
            }
        }
        distanzaTotalePercorsaMetztli +=peso;
        if(distanzaTotalePercorsaMetztli <grafo.getMappa().get(cittaAdiacente))
            grafo.setPut(cittaAdiacente, distanzaTotalePercorsaMetztli);
        return cittaAdiacente;
    }

    public static Citta cercaCittaAttuale(Grafo grafo){
        double min=Double.MAX_VALUE;
        Citta cittaAttuale=null;
        for(Map.Entry<Citta, Double> citta: grafo.getMappa().entrySet()){
            if(citta.getValue()<min){
                min = citta.getValue();
                cittaAttuale=citta.getKey();
            }
        }
        return cittaAttuale;
    }
}
//calc_dist= distanza(origine, cittaAttuale) + peso(cittaAttuale, cittaAdiacente);