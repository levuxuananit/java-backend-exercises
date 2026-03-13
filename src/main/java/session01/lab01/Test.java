package session01.lab01;

import java.util.Scanner;

public class Test {
    public static void main (String[] args) {
        Circle circle = new Circle();
        Scanner sc = new Scanner(System.in);
        circle.radius = sc.nextDouble();
        System.out.println( String.format("Area of the circle: %.2f", circle.getArea(circle.radius)));
    }
}
