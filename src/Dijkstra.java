import java.util.*;

public class Dijkstra {
    public static double getDistanzaTotalePercorsaMetztli() {
        return distanzaTotalePercorsaMetztli;
    }

    private static double distanzaTotalePercorsaMetztli =0;

    public static ArrayList<Citta> cercaPercorsoMiglioreMetztli(Grafo grafo, Citta origine){


        ArrayList<Citta> percorso=new ArrayList<>();
        ArrayList<Citta> visitate=new ArrayList<>();
        ArrayList<Citta> nonVisistate=new ArrayList<>();

        percorso.add(origine);
        Citta cittaAttuale= cercaCittaAttuale(grafo,visitate,percorso);


        while(!cittaAttuale.getNome().equals("Rovine Perdute")) {
            cittaAttuale = cercaCittaAttuale(grafo,visitate,percorso);
        }
        System.out.println("Inutike");
        return percorso;
    }

    public static Citta cercaCittaAttuale(Grafo grafo,ArrayList<Citta> visitate,ArrayList<Citta> percorso){
        double min=Double.MAX_VALUE;
        Citta cittaAttuale=null;
        for(Map.Entry<Citta, Double> citta: grafo.getMappa().entrySet()){
            if(citta.getValue()<min && !visitate.contains(citta.getKey())){
                min = citta.getValue();
                cittaAttuale=citta.getKey();
            }
        }
        visitate.add(cittaAttuale);
        double peso=Double.MAX_VALUE;
        Citta cittaAdiacente=null;
        for(Map.Entry<Citta, Double> cittaCandidata: cittaAttuale.getMappaTonatiuh().entrySet()){
            if(cittaCandidata.getValue()<peso && !visitate.contains(cittaCandidata.getKey())){
                peso = cittaCandidata.getValue();
                cittaAdiacente= cittaCandidata.getKey();
            }
        }
        distanzaTotalePercorsaMetztli +=peso;
        if(distanzaTotalePercorsaMetztli < grafo.getMappa().get(cittaAdiacente))
            grafo.setPut(cittaAdiacente, distanzaTotalePercorsaMetztli);
        percorso.add(cittaAdiacente);
        return cittaAdiacente;
    }
}


//calc_dist= distanza(origine, cittaAttuale) + peso(cittaAttuale, cittaAdiacente);