import java.util.Scanner;

/**
 * @autor Juan Solís
 * @description Clase que representa el controlador del programa
 * @version 1.0
 */

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean repetir = true;
        
        while (repetir) {
            System.out.println("\nDiccionario con Árbol BST:");
            System.out.println("1. Mostrar diccionario");
            System.out.println("2. Traducir archivo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    //controller.mostrarDiccionario();
                    break;

                case "2":
                    //controller.traducir();
                    break;

                case "3":
                    System.out.println("Programa finalizado");
                    repetir = false;
                    break;
                    
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}