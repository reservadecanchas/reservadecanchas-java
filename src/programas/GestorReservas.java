package programas;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private List<Cancha> canchas;
    private List<Reserva> reservas;

    public GestorReservas() {
        canchas = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void agregarCancha(int id, String nombre) {
        this.canchas.add(new Cancha(id, nombre));
    }

    public Reserva hacerReserva(String nombres, String apellidos, String numeroDni, String telefono, LocalDate fechaReserva, LocalTime horaReserva, Cancha cancha) {
        Reserva reserva = new Reserva(nombres, apellidos, numeroDni, telefono, fechaReserva, horaReserva, cancha);
        this.reservas.add(reserva);
        return reserva;
    }

    public List<Cancha> obtenerCanchas() {
        return this.canchas;
    }

    public List<Reserva> obtenerReservas() {
        return this.reservas;
    }

    public boolean hayDisponibilidad(Cancha cancha, LocalDate fecha, LocalTime hora) {
        return reservas.stream().noneMatch(r -> r.getCancha().equals(cancha) && r.getFechaReserva().equals(fecha) && r.getHoraReserva().equals(hora));
    }
}