package programas;

import java.util.Scanner;

public class Aplicacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nombres = new String[10];
        String[] apellidos = new String[10];
        String[] dnis = new String[10];
        String[] celulares = new String[10];
        String[] fechas = new String[10];
        String[] horas = new String[10];
        int reservasHechas = 0;

        while (true) {
            System.out.println("1. Reservar Cancha");
            System.out.println("2. Ver Reservas");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opción:");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.println("Ingresa tu nombre:");
                String nombre = scanner.next();

                System.out.println("Ingresa tu apellido:");
                String apellido = scanner.next();

                System.out.println("Ingresa tu DNI:");
                String dni = scanner.next();

                System.out.println("Ingresa tu número de celular:");
                String celular = scanner.next();

                System.out.println("Ingresa la fecha de la reserva:");
                String fecha = scanner.next();

                System.out.println("Ingresa la hora de la reserva:");
                String hora = scanner.next();

                boolean reservaExistente = false;
                for (int i = 0; i < reservasHechas; i++) {
                    if (fechas[i].equals(fecha) && horas[i].equals(hora)) {
                        reservaExistente = true;
                        break;
                    }
                }

                if (reservaExistente) {
                    System.out.println("Lo sentimos, la cancha ya está reservada para esta fecha y hora.");
                } else {
                    nombres[reservasHechas] = nombre;
                    apellidos[reservasHechas] = apellido;
                    dnis[reservasHechas] = dni;
                    celulares[reservasHechas] = celular;
                    fechas[reservasHechas] = fecha;
                    horas[reservasHechas] = hora;
                    reservasHechas++;
                    System.out.println("Reserva realizada con éxito.");
                }
            } else if (opcion == 2) {
                for (int i = 0; i < reservasHechas; i++) {
                    System.out.println("Reserva " + (i + 1) + ":");
                    System.out.println("Nombre: " + nombres[i]);
                    System.out.println("Apellido: " + apellidos[i]);
                    System.out.println("DNI: " + dnis[i]);
                    System.out.println("Celular: " + celulares[i]);
                    System.out.println("Fecha: " + fechas[i]);
                    System.out.println("Hora: " + horas[i]);
                    System.out.println();
                }
            } else if (opcion == 3) {
                System.exit(0);
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
