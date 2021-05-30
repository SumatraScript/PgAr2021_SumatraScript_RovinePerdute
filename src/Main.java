import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<Citta> cittadine = Reader.readerCitta();
        Grafo grafo= new Grafo(cittadine);

        ArrayList<Citta> percorso=Dijkstra.cercaPercorsoMiglioreMetztli(grafo,cittadine.get(0));
        Printer.write(percorso);

        for(int i=0;i< cittadine.size();i++){
            System.out.println(cittadine.get(i).toString());
        }
        System.out.println("Cias");
    }
}

