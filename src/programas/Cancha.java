package programas;
public class Cancha {
    private int id;
    private String nombre;

    public Cancha(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cancha [id=" + id + ", nombre=" + nombre + "]";
    }
}