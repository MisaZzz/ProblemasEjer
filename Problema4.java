package Ejercicios;
import javax.swing.JOptionPane;

public class Problema4 {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));

        int tieneIVA = JOptionPane.showConfirmDialog(null, "¿El producto tiene IVA?", "IVA", JOptionPane.YES_NO_OPTION);

        double porcentajeIVA = 0;
        double valorIVA = 0;
        double precioFinal = precio;

        if (tieneIVA == JOptionPane.YES_OPTION) {
            if (precio <= 500) {
                porcentajeIVA = 0.12;
            } else if (precio <= 1500) {
                porcentajeIVA = 0.14;
            } else {
                porcentajeIVA = 0.15;
            }
            valorIVA = precio * porcentajeIVA;
            precioFinal = precio + valorIVA;
        }

        String informacion = "Información del Producto:\n" +
                "Nombre: " + nombre + "\n" +
                "Precio: $" + precio + "\n" +
                (tieneIVA == JOptionPane.YES_OPTION ?
                        "Porcentaje de IVA: " + (porcentajeIVA * 100) + "%\n" +
                                "Valor de IVA: $" + valorIVA + "\n" : "Producto sin IVA\n") +
                "Precio Final: $" + precioFinal;

        JOptionPane.showMessageDialog(null, informacion);
    }
}
