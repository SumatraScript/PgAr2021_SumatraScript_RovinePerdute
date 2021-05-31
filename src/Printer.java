import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Printer {
    private static final String ASSENTE = "ASSENTE";

    public static void write(ArrayList<Citta> percorso) {

        XMLOutputFactory xmlof = null;
        XMLStreamWriter xmlw = null;
        try {
            xmlof = XMLOutputFactory.newInstance();
            xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("src/xml/risultati/xml_out.xml"), "utf-8");
            xmlw.writeStartDocument("utf-8", "1.0");
        } catch (Exception e) {
            System.out.println("Errore nell'inizializzazione del writer:");
            System.out.println(e.getMessage());
        }

        try { // blocco try per raccogliere eccezioni
            xmlw.writeCharacters("\n");
            xmlw.writeStartElement("routes"); // scrittura del tag radice <output>

            xmlw.writeCharacters("\n\t");
            xmlw.writeStartElement("route");
            xmlw.writeAttribute("team", "Tonathiu");
            //xmlw.writeAttribute("cost",  String.valueOf(Dijkstra.getDistanzaTotalePercorsaMetztli()));
            xmlw.writeAttribute("cities", String.valueOf(percorso.size()));

            for (int i = 0; i < percorso.size(); i++) {
                xmlw.writeCharacters("\n\t\t");
                xmlw.writeStartElement("city");
                xmlw.writeAttribute("id", String.valueOf(percorso.get(i).getId()));
                xmlw.writeAttribute("name", percorso.get(i).getNome());
                xmlw.writeEndElement();
            }
            xmlw.writeCharacters("\n\t");
            xmlw.writeEndElement();

            xmlw.writeCharacters("\n");
            xmlw.writeEndDocument();
            xmlw.flush(); // svuota il buffer e procede alla scrittura
            xmlw.close(); // chiusura del documento e delle risorse impiegate
        } catch (Exception e) { // se c’è un errore viene eseguita questa parte
            System.out.println("Errore nella scrittura " + e.getMessage());
        }
    }

    public static boolean isPresente(String codice_fiscale_persona, ArrayList<String> codici_fiscali_prelevati) {
        for (int i = 0; i < codici_fiscali_prelevati.size(); i++)
            if (codice_fiscale_persona.equals(codici_fiscali_prelevati.get(i)))
                return true;
        return false;
    }
}
