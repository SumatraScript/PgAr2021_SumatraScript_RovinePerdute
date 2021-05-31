import java.util.*;

public class Dijkstra {

    private static double distanzaTotalePercorsaMetztli =0;
    private static double distanzaTotalePercorsaTonatiuh =0;

    public static double getDistanzaTotalePercorsaMetztli() {
        return distanzaTotalePercorsaMetztli;
    }

    public static double getDistanzaTotalePercorsaTonatiuh() {
        return distanzaTotalePercorsaTonatiuh;
    }

    public static ArrayList<ArrayList<Citta>> cercaPercorsoMigliore(Grafo grafo, Citta origine){

        ArrayList<Citta> percorsoMetztli=new ArrayList<>();
        ArrayList<Citta> percorsoTonatiuh=new ArrayList<>();

        ArrayList<Citta> visitateMetztli=new ArrayList<>();
        ArrayList<Citta> visitateTonatiuh=new ArrayList<>();

        percorsoMetztli.add(origine);
        Citta cittaAttuale= cercaCittaAttualeMetztli(grafo,visitateMetztli,percorsoMetztli);
        while(!cittaAttuale.getNome().equals("Rovine Perdute")) {
            cittaAttuale = cercaCittaAttualeMetztli(grafo,visitateMetztli,percorsoMetztli);
        }

        percorsoTonatiuh.add(origine);
        cittaAttuale= cercaCittaAttualeTonatiuh(grafo,visitateTonatiuh,percorsoTonatiuh);
        while(!cittaAttuale.getNome().equals("Rovine Perdute")) {
            cittaAttuale = cercaCittaAttualeTonatiuh(grafo,visitateTonatiuh,percorsoTonatiuh);
        }

        ArrayList<ArrayList<Citta>>percorsi =new ArrayList<>();
        percorsi.add(percorsoMetztli);
        percorsi.add(percorsoTonatiuh);

        return percorsi;
    }

    public static Citta cercaCittaAttualeMetztli(Grafo grafo,ArrayList<Citta> visitate,ArrayList<Citta> percorso){
        double min=Double.MAX_VALUE;
        Citta cittaAttuale=null;
        for(Map.Entry<Citta, Double> citta: grafo.getMappa().entrySet()){
            if(citta.getValue()<min && !visitate.contains(citta.getKey())){
                cittaAttuale=citta.getKey();
            }
        }
        visitate.add(cittaAttuale);
        double peso=Double.MAX_VALUE;
        Citta cittaAdiacente=null;
        for(Map.Entry<Citta, Double> cittaCandidata: cittaAttuale.getMappaMetztli().entrySet()){
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

    public static Citta cercaCittaAttualeTonatiuh(Grafo grafo,ArrayList<Citta> visitate,ArrayList<Citta> percorso){
        double min=Double.MAX_VALUE;
        Citta cittaAttuale=null;
        for(Map.Entry<Citta, Double> citta: grafo.getMappa().entrySet()){
            if(citta.getValue()<min && !visitate.contains(citta.getKey())){
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