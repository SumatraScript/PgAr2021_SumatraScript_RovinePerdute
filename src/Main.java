import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Citta> citta = Reader.readerCitta();
        for (Citta value : citta) {
            System.out.println(value.toString());
        }
    }
}

