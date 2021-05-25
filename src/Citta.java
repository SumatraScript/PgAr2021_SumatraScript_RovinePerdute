import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class Citta {

    private int id;
    private String nome;
    private Coordinate coord;
    private ArrayList<Integer> Arr = new ArrayList<>();
    private Map<Citta, Integer> linked_to;

    public Citta(Coordinate coord){
        this.coord = coord;
    }

    public Citta(int id, String nome, Coordinate coord, Map<Citta, Integer> linked_to) {
        this.id = id;
        this.nome = nome;
        this.coord = coord;
        this.linked_to = linked_to;
    }

    public Citta(int id, String nome, Coordinate coord) {
        this.id = id;
        this.nome = nome;
        this.coord = coord;
    }

    public void setArr(int x){
        Arr.add(x);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public void setLinked_to(Citta collegata_a) {
        this.linked_to.put(collegata_a, calcolaDist(collegata_a));
    }

    public boolean equals(String o) {
        if (this.nome.toLowerCase().equals(o.hashCode())) return true;
        return false;
    }

    public boolean equals(Citta o) {
        if (this.nome == o.nome)
            if (this.coord == o.getCoord())
                return true;
                return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    public int calcolaDist(Citta altra_citta){
        return (int)Math.round(Math.sqrt(Math.pow(this.getCoord().getX() - altra_citta.getCoord().getX(),2) +
                Math.pow(this.getCoord().getY() - altra_citta.getCoord().getY(),2) +
                Math.pow(this.getCoord().getH() - altra_citta.getCoord().getH(),2)));
    }

    @Override
    public String toString() {
        return "Citta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", coord=" + coord +
                '}';
    }
}
