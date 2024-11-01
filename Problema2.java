package Ejercicios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calculadora calculadora = new Calculadora();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.\n");
                continue;
            }

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer número: ");
                double numero1 = Double.parseDouble(br.readLine());
                System.out.print("Ingrese el segundo número: ");
                double numero2 = Double.parseDouble(br.readLine());

                double resultado = 0;
                switch (opcion) {
                    case 1:
                        resultado = calculadora.sumar(numero1, numero2);
                        System.out.println("Resultado de la suma: " + resultado);
                        break;
                    case 2:
                        resultado = calculadora.restar(numero1, numero2);
                        System.out.println("Resultado de la resta: " + resultado);
                        break;
                    case 3:
                        resultado = calculadora.multiplicar(numero1, numero2);
                        System.out.println("Resultado de la multiplicación: " + resultado);
                        break;
                    case 4:
                        try {
                            resultado = calculadora.dividir(numero1, numero2);
                            System.out.println("Resultado de la división: " + resultado);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                }
            } else if (opcion == 5) {
                continuar = false;
                System.out.println("Saliendo del programa.");
            } else {
                System.out.println("Error: Opción no válida. Por favor, seleccione una opción entre 1 y 5.\n");
            }
            System.out.println();
        }
    }
}

class Calculadora {
    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }
        return a / b;
    }
}
