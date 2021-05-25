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

        File input = new File("src//xml//PgAr_Map_5.xml");

        ArrayList<Citta> cittadine = new ArrayList<>();

        XMLInputFactory xmlif = XMLInputFactory.newFactory();
        XMLStreamReader xmlr = null;

        try {
            xmlr = xmlif.createXMLStreamReader(new FileInputStream(input));
        } catch (FileNotFoundException | XMLStreamException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            int j = 0;
            while (xmlr.hasNext()) {
                if (xmlr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    // lettura id
                    if (xmlr.getLocalName().equals("city")) {
                        String letto;
                        Coordinate coord = new Coordinate(0,0,0);
                        Citta citta = new Citta(coord);
                        for (int i = 0; i < xmlr.getAttributeCount(); i++) {
                            switch (xmlr.getAttributeLocalName(i)) {
                                //lettura id
                                case "id":
                                    letto = xmlr.getAttributeValue(i);
                                    citta.setId(Integer.parseInt(letto));
                                    break;
                                //lettura nome
                                case "name":
                                    citta.setNome(xmlr.getAttributeValue(i));
                                    break;
                                //lettura x
                                case "x":
                                    letto = xmlr.getAttributeValue(i);
                                    citta.getCoord().setX(Integer.parseInt(letto));
                                    break;
                                //lettura y
                                case "y":
                                    letto = xmlr.getAttributeValue(i);
                                    citta.getCoord().setY(Integer.parseInt(letto));
                                    break;
                                //lettura h
                                case "h":
                                    letto = xmlr.getAttributeValue(i);
                                    citta.getCoord().setH(Integer.parseInt(letto));
                                    break;
                            }
                        }
                        cittadine.add(citta);
                    }
                    // lettura link
                    else if (xmlr.getLocalName().equals("link")) {
                        cittadine.get(j).setArr(Integer.parseInt(xmlr.getAttributeValue(0)));
                    }
                }
                if (xmlr.getEventType() == XMLStreamConstants.END_ELEMENT){
                    if (xmlr.getLocalName().equals("city"))
                        j++;
                }
                xmlr.next();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        collegaCitta(cittadine);
        return cittadine;
    }

    private static void collegaCitta(ArrayList<Citta> cittadine) {
        for (Citta citta: cittadine) {
            for (int x: citta.getArr()) {
            citta.setLinked_to(cittadine.get(x));
            }
        }
    }
}