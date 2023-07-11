package programas;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Aplicacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorReservas gestorReservas = new GestorReservas();
        gestorReservas.agregarCancha(1, "Cancha 1");
        gestorReservas.agregarCancha(2, "Cancha 2");

        while (true) {
            System.out.println("\n------ Sistema de Reserva de Canchas ------");
            System.out.println("1. Reservar Cancha");
            System.out.println("2. Ver Reservas");
            System.out.println("3. Salir");
            System.out.print("Por favor, selecciona una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("\n------ Reservar Cancha ------");
                System.out.println("Selecciona una cancha:");
                for (Cancha cancha : gestorReservas.obtenerCanchas()) {
                    System.out.println(cancha.getId() + ": " + cancha.getNombre());
                }
                System.out.print("Número de la cancha: ");
                int canchaId = scanner.nextInt();
                Cancha canchaSeleccionada = null;
                for (Cancha cancha : gestorReservas.obtenerCanchas()) {
                    if (cancha.getId() == canchaId) {
                        canchaSeleccionada = cancha;
                        break;
                    }
                }

                if (canchaSeleccionada == null) {
                    System.out.println("\nCancha no encontrada, volviendo al menú principal...");
                    continue;
                }

                System.out.print("\nIngresa tu nombre: ");
                String nombres = scanner.next();

                System.out.print("Ingresa tu apellido: ");
                String apellidos = scanner.next();

                System.out.print("Ingresa tu número de DNI: ");
                String dni = scanner.next();

                System.out.print("Ingresa tu número de teléfono: ");
                String telefono = scanner.next();

                System.out.print("Ingresa la fecha de reserva (yyyy-MM-dd): ");
                String fechaStr = scanner.next();
                LocalDate fecha = null;
                try {
                    fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                } catch (DateTimeParseException e) {
                    System.out.println("\nFormato de fecha inválido, volviendo al menú principal...");
                    continue;
                }

                System.out.print("Ingresa la hora de reserva (HH:mm): ");
                String horaStr = scanner.next();
                LocalTime hora = null;
                try {
                    hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm"));
                } catch (DateTimeParseException e) {
                    System.out.println("\nFormato de hora inválido, volviendo al menú principal...");
                    continue;
                }

                if (gestorReservas.hayDisponibilidad(canchaSeleccionada, fecha, hora)) {
                    Reserva reserva = gestorReservas.hacerReserva(nombres, apellidos, dni, telefono, fecha, hora, canchaSeleccionada);
                    System.out.println("\nReserva realizada con éxito.");
                    System.out.println("Número de reserva: " + reserva.getNumeroReserva());
                    System.out.println(reserva.getComprobantePago());
                    System.out.println("Detalles de la reserva:\n" + reserva);
                } else {
                    System.out.println("\nLo sentimos, no hay disponibilidad para la fecha y hora seleccionada.");
                }

            } else if (opcion == 2) {
                System.out.println("\n------ Ver Reservas ------");
                if (gestorReservas.obtenerReservas().isEmpty()) {
                    System.out.println("\nNo hay reservas realizadas.");
                } else {
                    System.out.println("Reservas:");
                    for (Reserva reserva : gestorReservas.obtenerReservas()) {
                        System.out.println(reserva);
                    }
                }

            } else if (opcion == 3) {
                System.out.println("\nGracias por usar el sistema de reserva de canchas. ¡Hasta luego!");
                break;
            } else {
                System.out.println("\nOpción inválida. Por favor, intenta de nuevo con una opción válida.");
            }
        }
    }
}
