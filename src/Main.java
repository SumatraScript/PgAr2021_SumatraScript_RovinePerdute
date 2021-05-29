import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<Citta> citta = Reader.readerCitta();
        for(int i=0;i< citta.size();i++){
            System.out.println(citta.get(i).toString());
        }
        System.out.println("Cias");
    }
}

