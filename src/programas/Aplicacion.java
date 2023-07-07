package programas;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Aplicacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorReservas gestorReservas = new GestorReservas();
        gestorReservas.agregarCancha(1, "Cancha 1");
        gestorReservas.agregarCancha(2, "Cancha 2");

        while (true) {
            System.out.println("1. Reservar Cancha");
            System.out.println("2. Ver Reservas");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("Selecciona una cancha:");
                for (Cancha cancha : gestorReservas.obtenerCanchas()) {
                    System.out.println(cancha.getId() + ": " + cancha.getNombre());
                }
                int canchaId = scanner.nextInt();
                Cancha canchaSeleccionada = null;
                for (Cancha cancha : gestorReservas.obtenerCanchas()) {
                    if (cancha.getId() == canchaId) {
                        canchaSeleccionada = cancha;
                        break;
                    }
                }

                if (canchaSeleccionada == null) {
                    System.out.println("Cancha no encontrada");
                    continue;
                }

                System.out.println("Ingresa tu nombre:");
                String nombres = scanner.next();

                System.out.println("Ingresa tus apellidos:");
                String apellidos = scanner.next();

                System.out.println("Ingresa tu número de DNI:");
                String dni = scanner.next();

                System.out.println("Ingresa tu número de teléfono:");
                String telefono = scanner.next();

                System.out.println("Ingresa la fecha de reserva (yyyy-MM-dd):");
                String fechaStr = scanner.next();
                LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                System.out.println("Ingresa la hora de reserva (HH:mm):");
                String horaStr = scanner.next();
                LocalTime hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));

                if (gestorReservas.hayDisponibilidad(canchaSeleccionada, fecha, hora)) {
                    Reserva reserva = gestorReservas.hacerReserva(nombres, apellidos, dni, telefono, fecha, hora, canchaSeleccionada);
                    System.out.println("Reserva realizada con éxito. Número de reserva: " + reserva.getNumeroReserva());
                    System.out.println(reserva.getComprobantePago());
                    System.out.println(reserva);
                } else {
                    System.out.println("Lo sentimos, no hay disponibilidad para la fecha y hora seleccionada.");
                }

            } else if (opcion == 2) {
                System.out.println("Reservas:");
                for (Reserva reserva : gestorReservas.obtenerReservas()) {
                    System.out.println(reserva);
                }

            } else if (opcion == 3) {
                break;
            } else {
                System.out.println("Opción inválida");
            }
        }
    }
}