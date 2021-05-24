import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Reader {

    public static ArrayList<Citta> readerPersona(){
        File input = new File("src//xml//PgAr_Map_5.xml");
        ArrayList<Citta> citta=new ArrayList<>();
        String nome = new String();

        ArrayList<String> nomi=new ArrayList<>();
        ArrayList<Integer> id=new ArrayList<>();
        ArrayList<Integer> x=new ArrayList<>();
        ArrayList<Integer> y=new ArrayList<>();
        ArrayList<Integer> h=new ArrayList<>();

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
                    if (xmlr.getLocalName().equals("id")) {
                        xmlr.next();
                        if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
                            String letto = xmlr.getText();
                            id.add(Integer.parseInt(letto));
                        }
                    }
                    // lettura cordinata x
                    else if (xmlr.getLocalName().equals("cognome")) {
                        xmlr.next();
                        if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
                            String letto = xmlr.getText();
                            x.add(Integer.parseInt(letto));
                        }
                    }
                    // lettura sesso e inizializzazione in  un array di string
                    else if (xmlr.getLocalName().equals("sesso")) {
                        xmlr.next();
                        if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
                            String letto = xmlr.getText();
                            y.add(Integer.parseInt(letto));
                        }
                    }
                    // lettura comune di nascita e inizializzazione in  un array di string
                    else if (xmlr.getLocalName().equals("comune_nascita")) {
                        xmlr.next();
                        if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
                            String letto = xmlr.getText();
                            h.add(Integer.parseInt(letto));
                        }
                    }
                    // lettura date di nascita e inizializzazione in  un array di string
                    else if (xmlr.getLocalName().equals("data_nascita")) {
                        xmlr.next();
                        if (xmlr.getEventType() == XMLStreamConstants.CHARACTERS) {
                            data_di_nascita = xmlr.getText();
                            date_di_nascita.add(data_di_nascita);
                        }
                    }
                }
                xmlr.next();
            }
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
        //iserimento dei dati in persona
        for(int i=0;i<nomi.size();i++) {
            Persona persona = new Persona(nomi.get(i), cognomi.get(i), sessi.get(i), comuni_di_nascita.get(i), date_di_nascita.get(i));
            persone.add(persona);
        }
        return persone;
    }
}
