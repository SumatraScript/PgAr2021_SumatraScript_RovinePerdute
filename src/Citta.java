public class Citta {

    private int id;
    private String nome;
    Coordinate coord;

    public Citta(int id, String nome, Coordinate coord) {
        this.id = id;
        this.nome = nome;
        this.coord = coord;
    }

    @Override
    public String toString() {
        return "Citta{" + "id=" + id + ", nome=" + nome  + ", coord=" + coord.toString() + '}';
    }
}
