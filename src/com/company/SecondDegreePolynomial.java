package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * <h1>Second Degree Polynomial</h1>
 * <p>
 *     Represents a second degree polynomial in C
 * </p>
 */
public class SecondDegreePolynomial {

    // polynomial variables
    private double polyA, polyB, polyC;

    // ===== CONSTRUCTOR ===== //

    /**
     * <h2>SecondDegreePolynomial Class Constructor</h2>
     * <p>
     *     Assigns the values of each polynomial variable <br>
     *     (P) : y = ax^2 + bx + c
     * </p>
     * @param a ax^2
     * @param b bx
     * @param c c
     */
    public SecondDegreePolynomial(double a, double b, double c) {
        polyA = a;
        polyB = b;
        polyC = c;
    }

    // ===== GETTERS ===== //

    /**
     * <h2>polyA getter</h2>
     * @return polyA
     */
    public double getA() {
        return  polyA;
    }
    /**
     * <h2>polyB getter</h2>
     * @return polyB
     */
    public double getB() {
        return polyB;
    }
    /**
     * <h2>polyC getter</h2>
     * @return polyC
     */
    public double getC() {
        return polyC;
    }

    // ===== METHODS ===== //

    /**
     * <h2>ComputeDelta</h2>
     * <p>
     *     Computes delta for the given polynomial values <br>
     *     delta = b^2 - 4ac
     * </p>
     *
     * @return delta
     */
    private double computeDelta() {
        // calculates delta
        return  Math.pow(polyB, 2) - 4 * polyA * polyC;
    }

    /**
     * <h2>numSolution</h2>
     * <p>
     *     Computes the number of solution for the polynomial depending on delta
     * </p>
     * <p>
     *     delta < 0 : no solutions in R <br>
     *     delta = 0 : 1 solution in R <br>
     *     delta > 0 : 2 solutions in R
     * </p>
     * @return the number of solutions of a second degree polynomial
     */
    public int numSolutions() {
        // computes delta for the polynomial
        double delta = computeDelta();

        // there are no solutions in R
        if (delta < 0) {
            return 0;
        }
        // there is 1 solution
        else if (delta == 0) {
            return  1;
        }
        // there are 2 solutions
        else if (delta > 0) {
            return 2;
        }
        // there is an error with computeDelta
        else {
            throw new ArithmeticException("Error computing Delta");
        }
    }

    /**
     * <h2>solve</h2>
     * <p>
     *     solves the polynomial
     * </p>
     * <p>
     *     no solutions : [-infinity, - infinity] <br>
     *     1 solution   : [x, x] <br>
     *     2 solutions  : [x1, x2]
     * </p>
     * @return solution to polynomial (if it exists)
     */
    public double[] solve() {
        // if solution are in the complex plane...
        if (numSolutions() == 0) {
            // returns negative infinity
            return new double[]{Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY};
        }

        // if there is only one solution
        else if (numSolutions() == 1) {
            // calculates the solutions
            double solution = polyB/2;

            // returns the solution twice under array form
            return new double[]{solution, solution};
        }

        // if there are two solutions
        else {
            // calculates delta
            double delta = computeDelta();

            // finds both solution
            double[] solutions = {(-polyB - Math.sqrt(delta))/(2*polyA),
                                  (-polyB + Math.sqrt(delta))/(2*polyA)};

            // sorts the solutions in order
            Arrays.sort(solutions);

            // returns the solutions under array form
            return solutions;
        }
    }

    /**
     * <h2>complexSolve</h2>
     * <p>solves the polynomial in the complex plane</p>
     * @return complex solutions
     */
    public ComplexNumber[] complexSolve(){
        // if the solutions are not in the complex plane...
        if (numSolutions() != 0) {
            // throws an error
            throw new ArithmeticException("Polynomial has no solution in the complex plane");
        }

        // if the solutions are in the complex plane
        // computes real and imaginary part of solutions
        double Re = (-polyB)/(2*polyA);

        double Im = Math.sqrt(-computeDelta())/(2*polyA);

        // returns solutions to polynomial in complex plane
        return new ComplexNumber[]{new ComplexNumber(Re, Im), new ComplexNumber(Re, -Im)};
    }

    /**
     * <h2>complexSolve</h2>
     * <p>solves the polynomial in the complex plane to a set precision</p>
     * @param precision the precision of the solutions
     * @return complex solutions
     */
    public ComplexNumber[] complexSolve(int precision){
        // if the solutions are not in the complex plane...
        if (numSolutions() != 0) {
            // throws an error
            throw new ArithmeticException("Polynomial has no solution in the complex plane");
        }

        // if the solutions are in the complex plane
        // computes real and imaginary part of solutions

        double Re = (-polyB)/(2*polyA);
        double Im = Math.sqrt(-computeDelta())/(2*polyA);

        // sets the precision of real and imaginary parts
        Re = BigDecimal.valueOf(Re).setScale(precision, RoundingMode.HALF_UP).doubleValue();
        Im = BigDecimal.valueOf(Im).setScale(precision, RoundingMode.HALF_UP).doubleValue();

        // returns solutions to polynomial in complex plane
        return new ComplexNumber[]{new ComplexNumber(Re, Im), new ComplexNumber(Re, -Im)};
    }
}
