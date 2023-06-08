package lab02;

import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String [] args) {

        double[] c1 = {6, -2, 5};
        int[]    e1 = {0, 1, 3};
        Polynomial p1 = new Polynomial(c1, e1);

        double[] c2 = {5, 6};
        int[]    e2 = {0, 4};
        Polynomial p2 = new Polynomial(c2, e2);

        System.out.println("testing add");
        Polynomial r1 = p1.add(p2);

        for (int i = 0; i < r1.coefficients.length; i++)
            System.out.print(r1.coefficients[i] + " ");
        System.out.println();

        for (int i = 0; i < r1.exponents.length; i++)
            System.out.print(r1.exponents[i] + " ");
        System.out.println();

        System.out.println("testing multiply");
        Polynomial r2 = p1.multiply(p2);

        for (int i = 0; i < r2.coefficients.length; i++)
            System.out.print(r2.coefficients[i] + " ");
        System.out.println();

        for (int i = 0; i < r2.exponents.length; i++)
            System.out.print(r2.exponents[i] + " ");
        System.out.println();

        try {
            p1.saveToFile("output.txt");

            File file = new File("output.txt");
            Polynomial p3 = new Polynomial(file);

            System.out.println(p3); // toString()

        } catch (IOException ex1) {
            // TODO:
        }



    }
}
