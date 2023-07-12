package programas;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] canchas = { "Cancha 1", "Cancha 2", "Cancha 3", "Cancha 4", "Cancha 5" };
        boolean[] reservas = new boolean[5]; // False significa que la cancha está libre

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Reservar Cancha");
            System.out.println("2. Ver Canchas");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch(opcion) {
                case 1:
                    System.out.print("Reservar Cancha. Ingresa el número de la cancha (1-5): ");
                    int numeroCancha = scanner.nextInt() - 1; // Restamos 1 porque los arrays empiezan en 0

                    if(numeroCancha >= 0 && numeroCancha < 5) {
                        if(!reservas[numeroCancha]) {
                            reservas[numeroCancha] = true;
                            System.out.println("La " + canchas[numeroCancha] + " ha sido reservada exitosamente.");
                        } else {
                            System.out.println("Lo sentimos, la " + canchas[numeroCancha] + " ya ha sido reservada.");
                        }
                    } else {
                        System.out.println("Número de cancha inválido.");
                    }
                    break;
                case 2:
                    System.out.println("Lista de Canchas:");
                    for(int i = 0; i < 5; i++) {
                        System.out.println((i+1) + ". " + canchas[i] + (reservas[i] ? " (Reservada)" : " (Libre)"));
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, intenta de nuevo.");
            }
        }
    }
}
