import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Reader {

    public static ArrayList<Citta> readerCitta() {

        File input = new File("src//xml//PgAr_Map_10000.xml");

        ArrayList<Citta> cittadine = new ArrayList<>();
        ArrayList<String> nomi = new ArrayList<>();
        ArrayList<Coordinate> coordinate = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Integer> h = new ArrayList<>();

        XMLInputFactory xmlif = XMLInputFactory.newFactory();
        XMLStreamReader xmlr = null;

        try {
            xmlr = xmlif.createXMLStreamReader(new FileInputStream(input));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XMLStreamException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while (xmlr.hasNext()) {
                if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    // lettura id
                    if (xmlr.getLocalName().equals("city")) {
                        String letto;
                        for (int i = 0; i < xmlr.getAttributeCount(); i++) {
                            switch (xmlr.getAttributeLocalName(i)) {
                                //lettura id
                                case "id":
                                    letto = xmlr.getAttributeValue(i);
                                    id.add(Integer.parseInt(letto));
                                    break;
                                //lettura nome
                                case "name":
                                    nomi.add(xmlr.getAttributeValue(i));
                                    break;
                                //lettura x
                                case "x":
                                    letto = xmlr.getAttributeValue(i);
                                    x.add(Integer.parseInt(letto));
                                    break;
                                //lettura y
                                case "y":
                                    letto = xmlr.getAttributeValue(i);
                                    y.add(Integer.parseInt(letto));
                                    break;
                                //lettura h
                                case "h":
                                    letto = xmlr.getAttributeValue(i);
                                    h.add(Integer.parseInt(letto));
                                    break;
                            }
                        }
                    }
                    // lettura link
                    //da aggiungere
//                    else if (xmlr.getLocalName().equals("link")) {
//                        xmlr.next();
//                        if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
//                            String nome = xmlr.getText();
//                            x.add(nome);
//                        }
//                    }
                }
                xmlr.next();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        //iserimento dei dati in cordinate
        for (int i = 0; i < x.size(); i++) {
            Coordinate coordinata = new Coordinate(x.get(i), y.get(i), h.get(i));
            coordinate.add(coordinata);
        }
        //inserimento dei dati in Città
        for (int i = 0; i < id.size(); i++) {
            Citta citta = new Citta(id.get(i), nomi.get(i), coordinate.get(i));
            cittadine.add(citta);
        }
        return cittadine;
    }
}