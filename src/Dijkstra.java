import java.util.*;

public class Dijkstra {
    /**
     * Calcola il percorso più breve a partire dalla citta di CampoBasso (per voi comuni mortali Campo Base)
     * */
    public static void calcolaIlPercorsoPiuBreve(Grafo grafo, Citta campoBase) {
        ArrayList<Citta> visitateTonatiuh = new ArrayList<>();
        ArrayList<Citta> nonVisitateTonatiuh = (ArrayList<Citta>) grafo.getNodi();

        ArrayList<Citta> visitateMetztli = new ArrayList<>();
        ArrayList<Citta> nonVisitateMetztli = (ArrayList<Citta>) grafo.getNodi();

        //seleziono la prima città dopo il campo base
        Citta cittaCorrente=trovaCittaPiuVicinaMetztli(campoBase);
        visitateMetztli.add(campoBase);
        nonVisitateMetztli.remove(campoBase);
        visitateTonatiuh.add(campoBase);
        nonVisitateTonatiuh.remove(campoBase);

        //seleziono le prossime citta a partire dalla citta ottenuta a partire dal campo base con veicolo metzil
        while(nonVisitateMetztli.size()!=0){
            cittaCorrente = trovaCittaPiuVicinaMetztli(cittaCorrente);
            if(!visitateMetztli.contains(cittaCorrente)){
                nonVisitateMetztli.remove(cittaCorrente);
                visitateMetztli.add(cittaCorrente);
            }
        }

        //seleziono le prossime citta a partire dalla citta ottenuta a partire dal campo base con veicolo Tonatiuh
        while(nonVisitateTonatiuh.size()!=0){
            cittaCorrente = trovaCittaPiuVicinaTonatiuh(cittaCorrente);
            if(!visitateTonatiuh.contains(cittaCorrente)){
                nonVisitateTonatiuh.remove(cittaCorrente);
                visitateTonatiuh.add(cittaCorrente);
            }
        }

        //estrazione del grafico



    }

    /**
     * @param citta ovvero la citta scu cui effettuare la ricerca la citta è vista come uno dei nodi
     * */
    public static Citta trovaCittaPiuVicinaMetztli(Citta citta){
        int distanza=Integer.MAX_VALUE;
        Citta cittaPiuVicina = null;
        for(Map.Entry<Citta, Integer> entrata: citta.getMappaMetztli().entrySet()){
            if(distanza>entrata.getValue()){
                distanza = entrata.getValue();
                cittaPiuVicina = entrata.getKey();
            }
        }
        return cittaPiuVicina;
    }

    /**
     * @param citta ovvero la citta scu cui effettuare la ricerca la citta è vista come uno dei nodi
     * */
    public static Citta trovaCittaPiuVicinaTonatiuh(Citta citta){
        int distanza=Integer.MAX_VALUE;
        Citta cittaPiuVicina = null;
        for(Map.Entry<Citta, Integer> entrata: citta.getMappaTonatiuh().entrySet()){
            if(distanza>entrata.getValue()){
                distanza = entrata.getValue();
                cittaPiuVicina = entrata.getKey();
            }
        }
        return cittaPiuVicina;
    }
}
