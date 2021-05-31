import java.util.ArrayList;

public class OutputConstant {
    public static void manageOutput() {
        ArrayList<ArrayList<Citta>> tutteCittaFile = Reader.readerCitta();
        String[] output_file = new String[]{"src/xml/risultati/Ruote_Map_5.xml", "src/xml/risultati/Ruote_Map_12.xml", "src/xml/risultati/Ruote_Map_50.xml", "src/xml/risultati/Ruote_Map_200.xml", "src/xml/risultati/Ruote_Map_2000.xml", "src/xml/risultati/Ruote_Map_10000.xml"};

        int counter = 0;
        for (ArrayList<Citta> cittadine : tutteCittaFile) {
            Grafo grafo = new Grafo(cittadine);
            //ArrayList<ArrayList<Citta>> percorsi=Dijkstra.cercaPercorsoMigliore(grafo, cittadine.get(0));
            Printer.write(tutteCittaFile, output_file[counter]);
        }
    }
}
