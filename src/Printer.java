import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Printer {

    public static void write(ArrayList<ArrayList<Citta>> percorsi, String output) {

            XMLOutputFactory xmlof = null;
            XMLStreamWriter xmlw = null;
            try {
                xmlof = XMLOutputFactory.newInstance();
                xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(output), "utf-8");
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
                xmlw.writeAttribute("team", "Metztli");
                xmlw.writeAttribute("cost", String.valueOf(Dijkstra.getDistanzaTotalePercorsaMetztli()));
                xmlw.writeAttribute("cities", String.valueOf(percorsi.get(0).size()));

                for (int i = 0; i < percorsi.get(0).size(); i++) {
                    xmlw.writeCharacters("\n\t\t");
                    xmlw.writeStartElement("city");
                    xmlw.writeAttribute("id", String.valueOf(percorsi.get(0).get(i).getId()));
                    xmlw.writeAttribute("name", percorsi.get(0).get(i).getNome());
                    xmlw.writeEndElement();
                }
                xmlw.writeCharacters("\n\t");
                xmlw.writeEndElement();

                xmlw.writeStartElement("route");
                xmlw.writeAttribute("team", "Tonatiuh");
                xmlw.writeAttribute("cost", String.valueOf(Dijkstra.getDistanzaTotalePercorsaTonatiuh()));
                xmlw.writeAttribute("cities", String.valueOf(percorsi.get(1).size()));

                for (int i = 0; i < percorsi.get(1).size(); i++) {
                    xmlw.writeCharacters("\n\t\t");
                    xmlw.writeStartElement("city");
                    xmlw.writeAttribute("id", String.valueOf(percorsi.get(1).get(i).getId()));
                    xmlw.writeAttribute("name", percorsi.get(1).get(i).getNome());
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
}
