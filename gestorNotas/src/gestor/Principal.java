package gestor;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorNotas gestor = new GestorNotas();

        int opcion = 0;

        while (opcion != 6) {
            System.out.println("===== Gestor de Notas =====");
            System.out.println("1. Añadir nota");
            System.out.println("2. Mostrar promedio");
            System.out.println("3. Mostrar nota más alta");
            System.out.println("4. Eliminar última nota");
            System.out.println("5. Mostrar todas las notas");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("Introduce la nota: ");
                double nota = sc.nextDouble();
                gestor.agregarNota(nota);
            } else if (opcion == 2) {
                System.out.println("Promedio: " + gestor.calcularPromedio());
            } else if (opcion == 3) {
                System.out.println("Nota más alta: " + gestor.obtenerNotaMaxima());
            } else if (opcion == 4) {
                gestor.eliminarUltimaNota();
                System.out.println("Última nota eliminada.");
            } else if (opcion == 5) {
                System.out.println("Notas registradas:");
                gestor.mostrarNotas();
            } else if (opcion == 6) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opción inválida. Inténtalo de nuevo.");
            }

            System.out.println();
        }

        sc.close();
    }
}
