package com.company;

import java.io.OutputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // initialises polynomial coefficients
        double a, b, c;

        // creates new scanner...
        Scanner sc = new Scanner(System.in);

        // ... to get user input for polynomial coefficients
        System.out.print("a : ");
        a = sc.nextInt();
        System.out.print("b : ");
        b = sc.nextInt();
        System.out.print("c : ");
        c = sc.nextInt();

        // creates the polynomial based on user input
        SecondDegreePolynomial Q = new SecondDegreePolynomial(a, b, c);

        // displays polynomial to user
        System.out.printf("(Q) : %sx^2 + %sx + %s%n", a, b, c);

        // tries to solve polynomial
        switch (Q.numSolutions()) {

            // if there are no solutions in the real plane...
            case 0:
                // solves the polynomial in the complex plane
                ComplexNumber[] complexSolutions = Q.complexSolve();

                // separates the positive and negative solutions
                ComplexNumber z1 = complexSolutions[0];
                ComplexNumber z2 = complexSolutions[1];

                // displays complex solutions
                System.out.printf("S = {%s, %s}%n", z1.arithmetic(), z2.arithmetic());
                break;
            // if there is only 1 solution
            case 1:

                // gets the solution
                double[] solution = Q.solve();

                // displays the solution to the user
                System.out.printf("S = %s%n", solution[0]);
                break;
            // if there are 2 solutions...
            case 2:
                // gets both solutions
                double[] solutions = Q.solve();

                // displays them to the user
                System.out.printf("S = {%s, %s}%n", solutions[0], solutions[1]);
        }

        /*// creates a new complex number
        // z = 1 + 2i
        ComplexNumber z = new ComplexNumber(1, 2);
        // precision of polar and exponential forms
        final int precision = 2;

        // displays arithmetic form
        System.out.println(String.format("z = %s", z.arithmetic()));
        // displays polar form
        System.out.println(String.format("z = %s", z.polar(precision)));
        // displays exponential form
        System.out.println(String.format("z = %s", z.exponential(precision)));*/
    }
}

