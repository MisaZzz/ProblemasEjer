package Ejercicios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Cálculo para el triángulo
        System.out.println("Cálculo del área y perímetro de un triángulo:");
        System.out.print("Ingrese la base del triángulo: ");
        double baseTriangulo = Double.parseDouble(br.readLine());
        System.out.print("Ingrese la altura del triángulo: ");
        double alturaTriangulo = Double.parseDouble(br.readLine());
        System.out.print("Ingrese el lado 1 del triángulo: ");
        double lado1Triangulo = Double.parseDouble(br.readLine());
        System.out.print("Ingrese el lado 2 del triángulo: ");
        double lado2Triangulo = Double.parseDouble(br.readLine());

        double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
        double perimetroTriangulo = baseTriangulo + lado1Triangulo + lado2Triangulo;

        System.out.println("Área del triángulo: " + areaTriangulo);
        System.out.println("Perímetro del triángulo: " + perimetroTriangulo);

        // Cálculo para el cuadrado
        System.out.println("\nCálculo del área y perímetro de un cuadrado:");
        System.out.print("Ingrese el lado del cuadrado: ");
        double ladoCuadrado = Double.parseDouble(br.readLine());

        double areaCuadrado = ladoCuadrado * ladoCuadrado;
        double perimetroCuadrado = 4 * ladoCuadrado;

        System.out.println("Área del cuadrado: " + areaCuadrado);
        System.out.println("Perímetro del cuadrado: " + perimetroCuadrado);

        System.out.println("\nCálculo del área y perímetro de un rectángulo:");
        System.out.print("Ingrese la base del rectángulo: ");
        double baseRectangulo = Double.parseDouble(br.readLine());
        System.out.print("Ingrese la altura del rectángulo: ");
        double alturaRectangulo = Double.parseDouble(br.readLine());

        double areaRectangulo = baseRectangulo * alturaRectangulo;
        double perimetroRectangulo = 2 * (baseRectangulo + alturaRectangulo);

        System.out.println("Área del rectángulo: " + areaRectangulo);
        System.out.println("Perímetro del rectángulo: " + perimetroRectangulo);
    }
}
