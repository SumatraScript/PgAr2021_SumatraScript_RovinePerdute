import java.util.ArrayList;

public class Metztli{
    private static int carburante=0;

    public static int getCarburante() {
        return carburante;
    }

    public static void setCarburante(int carburante) {
        carburante = carburante;
    }

    public static double calcolaDistanza(Coordinate c1, Citta c2) {
        return Math.abs(c1.getH()-c2.getCoord().getH());
    }
}
