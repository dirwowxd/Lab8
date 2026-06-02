import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IOEmpresaControl Control = new IOEmpresaControl();
        int opcion;
        do {
            System.out.println("MENU");
            System.out.println("1. Registrar entrada empleado");
            System.out.println("2. Registrar salida empleado");
            System.out.println("3. Leer entrada empleado");
            System.out.println("4. Leer salida empleado");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Rut");
                    String rut= sc.nextLine();
                    System.out.println("Nombre ");
                    String nombre= sc.nextLine();
                    System.out.println("Horario de entrada");
                    LocalTime horario= LocalTime.parse(sc.nextLine());
                    Control.registrarArchivoIngreso(rut, nombre, horario);
                    break;
                case 2:
                    System.out.println("Rut");
                    String rutSalida= sc.nextLine();
                    System.out.println("Nombre ");
                    String nombreSalida= sc.nextLine();
                    System.out.println("Horario de entrada");
                   LocalTime horarioSalida= LocalTime.parse(sc.nextLine());
                   Control.registrarArchivoSalida(rutSalida, nombreSalida, horarioSalida);
                    break;
                case 3:
                    Control.leerHorariosEntrada();
                    break;
                case 4:
                    Control.leerHorariosSalidas();
                    break;
                case 5:
                    System.out.println("Salida");

            }
        } while (opcion != 5);
        sc.close();
    }
}
