import java.util.ArrayList;

public class Metztli{
    public static double calcolaDistanza(Coordinate c1, Citta c2) {
        return Math.abs(c1.getH()-c2.getCoord().getH());
    }
}
