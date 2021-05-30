import java.util.ArrayList;

public class Tonatiuh{
    private static int  carburante=0;

    public static int getCarburante() {
        return carburante;
    }

    public static void setCarburante(int carburante) {
       carburante = carburante;
    }

    public static double calcolaDistanza(Coordinate c1, Citta c2){
        return Math.sqrt(Math.pow(c1.getX() - c2.getCoord().getX(),2) + Math.pow(c1.getY() - c2.getCoord().getY(),2));
    }
}
