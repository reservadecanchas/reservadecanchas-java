package programas;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private static int count = 1;

    private int numeroReserva;
    private String nombres;
    private String apellidos;
    private String numeroDni;
    private String telefono;
    private LocalDate fechaReserva;
    private LocalTime horaReserva;
    private Cancha cancha;
    private String comprobantePago;

    public Reserva(String nombres, String apellidos, String numeroDni, String telefono, LocalDate fechaReserva, LocalTime horaReserva, Cancha cancha) {
        this.numeroReserva = count++;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroDni = numeroDni;
        this.telefono = telefono;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.cancha = cancha;
        this.comprobantePago = "Pago realizado: " + this.numeroReserva; // Simulando comprobante de pago.
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public String getComprobantePago() {
        return comprobantePago;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    @Override
    public String toString() {
        return "Reserva #" + numeroReserva + " - Cancha: " + cancha.getNombre() + ", Cliente: " + nombres + " " + apellidos + ", DNI: " + numeroDni + ", Telefono: " + telefono + ", Fecha: " + fechaReserva + ", Hora: " + horaReserva;
    }
}