import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Citta {

    private int id;
    private String nome;
    private Coordinate coord;
    private Map<Citta, Integer> linked_to;

    public Citta(int id, String nome, Coordinate coord, Map<Citta, Integer> linked_to) {
        this.id = id;
        this.nome = nome;
        this.coord = coord;
        this.linked_to = linked_to;
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

    public Map<Citta, Integer> getLinked_to() {
        return linked_to;
    }

    public void setLinked_to(Map<Citta, Integer> linked_to) {
        this.linked_to = linked_to;
    }

    public boolean equals(String o) {
        if (this.nome.toLowerCase().equals(o.hashCode())) return true;
        return Objects.equals(getNome(), this.getNome()) && Objects.equals(getLinked_to(), this.getLinked_to());
    }

    public boolean equals(Citta o) {
        if (this.nome == o.nome)
            if (this.coord == o.getCoord())
                return true;
                return Objects.equals(getNome(), this.getNome()) && Objects.equals(getLinked_to(), this.getLinked_to());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getLinked_to());
    }
}
