import java.util.ArrayList;

public class Tonatiuh{

    public static double calcolaDistanza(Coordinate c1, Citta c2){
        return Math.sqrt(Math.pow(c1.getX() - c2.getCoord().getX(),2) + Math.pow(c1.getY() - c2.getCoord().getY(),2));
    }
}
