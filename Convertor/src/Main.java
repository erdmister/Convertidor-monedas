import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConvertidorDeMoneda convertidor = new ConvertidorDeMoneda();
        HistorialDeConversion historial = new HistorialDeConversion();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Conversor de monedas");
            System.out.println("2. Consultar historial");
            System.out.println("3. Salir");
            System.out.println("Elige una opcion: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    convertidor.convertirMoneda(historial);
                    break;
                case 2:
                    historial.verHistorial();
                    break;
                case 3:
                    System.out.println("Hasta luego, vuleve pronto");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor seleccione una opción válida.");
            }
        }
    }
}
