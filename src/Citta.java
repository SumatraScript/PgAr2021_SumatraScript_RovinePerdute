import java.util.*;

public class Citta {

    private int id;
    private String nome;
    private Coordinate coord;
    private ArrayList<Integer> collegamentiCitta;
    private Map<Citta, Integer> mappaTonatiuh;
    private Map<Citta, Integer> mappaMetztli;

    public Map<Citta, Integer> getMappaTonatiuh() {
        return mappaTonatiuh;
    }

    public Map<Citta, Integer> getMappaMetztli() {
        return mappaMetztli;
    }

    public void setCollegamentiCitta(ArrayList<Integer> collegamentiCitta) {
        this.collegamentiCitta = collegamentiCitta;
    }

    public Citta(Coordinate coord){
        this.coord = coord;
        this.collegamentiCitta = new ArrayList<>();
        this.mappaTonatiuh = new HashMap<>();
        this.mappaMetztli = new HashMap<>();
    }

    public Citta(int id, String nome, Coordinate coord, Map<Citta, Integer> linked_to) {
        this.id = id;
        this.nome = nome;
        this.coord = coord;
        this.collegamentiCitta = new ArrayList<>();
        this.mappaTonatiuh = new HashMap<>();
        this.mappaMetztli = new HashMap<>();
    }

    public Citta(int id, String nome, Coordinate coord) {
        this.id = id;
        this.nome = nome;
        this.coord = coord;
        this.collegamentiCitta = new ArrayList<>();
        this.mappaTonatiuh = new HashMap<>();
        this.mappaMetztli = new HashMap<>();
    }

    public void setArr(int x){
        collegamentiCitta.add(x);
    }

    public  ArrayList<Integer> getCollegamentiCitta(){
        return collegamentiCitta;
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

    /**
     * Creazione delle due mappe a seconda del veicolo
     * */
    public void setLinked_to(Citta collegata_a) {
        this.mappaTonatiuh.put(collegata_a, Tonatiuh.calcolaDistanza(this.coord, collegata_a));
        this.mappaMetztli.put(collegata_a, Metztli.calcolaDistanza(this.coord, collegata_a));
    }

    public boolean equals(String o) {
        if (this.nome.toLowerCase().equals(o.hashCode())) return true;
        return false;
    }

    public boolean equals(Citta o) {
        if (this.nome.equals(o.nome))
            if (this.coord.equals(o.getCoord()))
                return true;
                return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    @Override
    public String toString() {
        StringBuffer risultato=new StringBuffer();
        risultato.append("Citta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", coord=" + coord +
                '}'+
                "array di citta linked to{" + getCollegamentiCitta() +
                "}");
        return risultato.toString();
    }
}
