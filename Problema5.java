package Ejercicios;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Problema5 {
    public static void main(String[] args) {
        // Crear un nuevo empleado
        Empleado empleado = ingresarDatosEmpleado();

        // Mostrar opciones
        boolean continuar = true;
        while (continuar) {
            String opcion = JOptionPane.showInputDialog("""
                    Seleccione una opción:
                    1. Modificar Salario
                    2. Calcular Edad
                    3. Calcular Prestaciones
                    4. Mostrar Información
                    5. Salir
                    """);
            switch (opcion) {
                case "1" -> modificarSalario(empleado);
                case "2" -> calcularEdad(empleado);
                case "3" -> calcularPrestaciones(empleado);
                case "4" -> mostrarInformacionEmpleado(empleado);
                case "5" -> {
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación.");
                }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
            }
        }
    }

    // Método para ingresar datos del empleado
    public static Empleado ingresarDatosEmpleado() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del empleado:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado:");
        String genero = JOptionPane.showInputDialog("Ingrese el género del empleado (M/F):");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario del empleado:"));

        // Ingresar fecha de nacimiento y fecha de ingreso
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento (dd/MM/yyyy):"), formatter);
        LocalDate fechaIngreso = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de ingreso (dd/MM/yyyy):"), formatter);

        // Crear y retornar el objeto Empleado
        return new Empleado(cedula, nombre, apellido, genero, salario, fechaNacimiento, fechaIngreso);
    }

    // Método para modificar el salario del empleado
    public static void modificarSalario(Empleado empleado) {
        double nuevoSalario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo salario del empleado:"));
        empleado.setSalario(nuevoSalario);
        JOptionPane.showMessageDialog(null, "Salario actualizado correctamente.");
    }

    // Método para calcular y mostrar la edad del empleado
    public static void calcularEdad(Empleado empleado) {
        int edad = empleado.calcularEdad();
        JOptionPane.showMessageDialog(null, "La edad del empleado es: " + edad + " años.");
    }

    // Método para calcular y mostrar las prestaciones del empleado
    public static void calcularPrestaciones(Empleado empleado) {
        double prestaciones = empleado.calcularPrestaciones();
        JOptionPane.showMessageDialog(null, "Las prestaciones del empleado son: $" + prestaciones);
    }

    // Método para mostrar toda la información del empleado
    public static void mostrarInformacionEmpleado(Empleado empleado) {
        JOptionPane.showMessageDialog(null, empleado.toString());
    }
}

// Clase Empleado sin modificador de acceso (package-private)
class Empleado {
    private final String cedula;
    private final String nombre;
    private final String apellido;
    private final String genero;
    private double salario;
    private final LocalDate fechaNacimiento;
    private final LocalDate fechaIngreso;

    // Constructor
    public Empleado(String cedula, String nombre, String apellido, String genero, double salario, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters y setters
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método para calcular la edad del empleado
    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    // Método para calcular las prestaciones del empleado
    public double calcularPrestaciones() {
        int antiguedad = Period.between(fechaIngreso, LocalDate.now()).getYears();
        return (antiguedad * salario) / 12;
    }

    // Método para mostrar la información del empleado usando text blocks
    @Override
    public String toString() {
        return """
                Información del Empleado:
                Cédula: %s
                Nombre: %s
                Apellido: %s
                Género: %s
                Salario: $%.2f
                Fecha de Nacimiento: %s
                Fecha de Ingreso: %s
                """.formatted(cedula, nombre, apellido, genero, salario, fechaNacimiento, fechaIngreso);
    }
}
