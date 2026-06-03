import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IOEmpresaControl {

    public void registrarArchivoIngreso(String rut, String nombre, LocalTime horaIngresoEmpleado) {
        LocalDate fecha = LocalDate.now();
        DateTimeFormatter horaformato = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String nombreArchivo = "Ingreso_Empleados_Fecha_" + fecha.format(formatter) + ".txt";
        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            LocalTime horaIngreso = LocalTime.of(8, 30);
            DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");

            String linea = rut + " | " + nombre + " | " + horaIngresoEmpleado;
            if (horaIngresoEmpleado.isAfter(horaIngreso)) {
                linea += " <-ATRASO";
                System.out.println(linea);
            }
            bw.write(linea);
            bw.newLine();
            System.out.println("Se ha ingresado correctamente");

        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void registrarArchivoSalida(String rut, String nombre, LocalTime horaSalidaEmpleado) {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter horaformato = DateTimeFormatter.ofPattern("HH:mm:ss");
        String nombreArchivo = "Salida_Empleados_Fecha_" + fechaActual.format(fechaFormato) + ".txt";
        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            LocalTime horaSalida = LocalTime.of(17, 0);
            String linea = rut + " | " + nombre + " | " + horaSalidaEmpleado;
            if (horaSalidaEmpleado.isAfter(horaSalida)) {
                Duration duracion = Duration.between(horaSalida, horaSalidaEmpleado);
                long horasExtras = duracion.toHours();
                long minutosExtras = duracion.toMinutesPart();
                linea += " Tiempo Extra: " + horasExtras + "h " + minutosExtras +"m";
                System.out.println(linea);
            }
            bw.write(linea);
            bw.newLine();
            System.out.println("Registro de horario de salida exitosamente creado");
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }


    public void leerHorariosEntrada() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String nombreArchivo = "Ingreso_Empleados_Fecha_" + fechaActual.format(fechaFormato) + ".txt";
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            System.out.println("El archivo no existe");
            return;
        }
        if (file.length() == 0) {
            System.out.println("El archivo esta vacio");
            return;
        }
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            System.out.println("\n--- REGISTROS DE INGRESO DEL DÍA ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {

            System.out.println("Error : " + e.getMessage());
        }

    }

    public void leerHorariosSalidas() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String nombreArchivo = "Salida_Empleados_Fecha_" + fechaActual.format(fechaFormato) + ".txt";
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            System.out.println("El archivo no existe");
            return;
        }
        if (file.length() == 0) {
            System.out.println("El archivo esta vacio");
            return;
        }
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            System.out.println("\n--- REGISTROS DE SALIDA DEL DÍA ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            }
        } catch ( IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
