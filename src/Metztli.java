import java.util.ArrayList;

public class Metztli{

    public static int calcolaDistanza(Coordinate c1, Citta c2) {
        return Math.round(Math.abs(c1.getH()-c2.getCoord().getH()));
    }
}
