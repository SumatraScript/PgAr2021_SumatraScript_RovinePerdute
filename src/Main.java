import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Citta>> tutteCittaFile = Reader.readerCitta();
        for(ArrayList<Citta> cittadine: tutteCittaFile) {
            Grafo grafo = new Grafo(cittadine);
            Dijkstra.cercaPercorsiPossibili(grafo);
        }

//
//        for(int i=0;i< cittadine.size();i++){
//            System.out.println(cittadine.get(i).toString());
//        }
        System.out.println("Cias");
    }
}

