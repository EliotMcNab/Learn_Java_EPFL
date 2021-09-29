package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <h1>Complex Number</h1>
 * <p>Allows for the easy representation and manipulation of a complex number</p>
 */
public class ComplexNumber {

    // real and imaginary part of complex number
    private double Re, Im;

    // ===== CONSTRUCTOR ===== //

    /**
     * <h2>ComplexNumber Class constructor</h2>
     * <p>sets the real and imaginary part of a complex number</p>
     * @param a real part
     * @param b imaginary part
     */
    public ComplexNumber(double a, double b) {
        // sets real and imaginary parts
        Re = a;
        Im = b;
    }

    // ===== GETTERS ===== //

    /**
     * <h2>Re getter</h2>
     * @return Re
     */
    public double getRe() {
        return Re;
    }

    /**
     * <h2>Im getter</h2>
     * @return Im
     */
    public double getIm() {
        return Im;
    }

    // ===== Modules ==== //

    /**
     * <h2>conjugate</h2>
     * <p>determines the conjugate of a complex number</p>
     * @return the conjugate
     */
    public ComplexNumber conjugate(){
        // creates a new complex number which is conjugate to the current one
        return new ComplexNumber(Re, -Im);
    }

    /**
     * <h2>norm</h2>
     * <p>Calculates the norm of an imaginary number</p>
     * @return the norm
     */
    public double norm(){
        // uses Pythagores to calculate the norm
        return Math.sqrt(Math.pow(Im, 2) + Math.pow(Re, 2));
    }

    /**
     * <h2>norm</h2>
     * <p>Calculates the norm of an imaginary number to a set precision</p>
     * @param precision the precision of the norm
     * @return the norm to a set precision
     */
    public double norm(int precision){
        // uses Pythagores to calculate the norm
        double norm = Math.sqrt(Math.pow(Im, 2) + Math.pow(Re, 2));

        // sets the precision
        return BigDecimal.valueOf(norm).setScale(precision, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * <h2>argument</h2>
     * <p>determines the argument of a complex number</p>
     * @return the argument
     */
    public double argument(){
        return Math.atan(Im / Re);
    }

    /**
     * <h2>argument</h2>
     * <p>determines the argument of a complex number to a set precision</p>
     * @param precision the precision of the argument
     * @return the argument
     */
    public double argument(int precision){
        // uses trigonometry to determine the argument
        double argument = Math.atan(Im / Re);

        // sets the precision of the argument
        return BigDecimal.valueOf(argument).setScale(precision, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * <h2>arithmetic</h2>
     * <p>determines the arithmetic form of a complex number</p>
     * @return the arithmetic form
     */
    public String arithmetic(){
        // constructs the arithmetic form based on the
        // imaginary and real parts of the complex number
        return String.format("%s + i%s", Re, Im);
    }

    /**
     * <h2>polar</h2>
     * <p>determines the polar form of a complex number</p>
     * @return the polar form
     */
    public String polar() {
        // uses in built-functions to calculate the norm and argument
        // and constructs the polar form based on these
        return String.format("%s[cos(%s)+i*sin(%s)]", norm(), argument(), argument());
    }

    /**
     * <h2>polar</h2>
     * <p>determines the polar form of a complex number to a set precison</p>
     * @param precision the precision of the polar form
     * @return the polar form
     */
    public String polar(int precision) {
        // uses in built-functions to calculate the norm and argument
        // limiting the number of significant digits
        // and constructs the polar form based on these
        return String.format("%s[cos(%s)+i*sin(%s)]", norm(precision), argument(precision), argument(precision));
    }

    /**
     * <h2>exponential</h2>
     * <p>determines the exponential form of an imaginary number</p>
     * @return the exponential form
     */
    public String exponential() {
        // uses in built-functions to calculate the norm and argument
        // and constructs the exponential form based on these
        return String.format("%se^(i*pi*%s)", norm(), argument());
    }

    /**
     * <h2>exponential</h2>
     * <p>determines the exponential form of an imaginary number to a set precision</p>
     * @param precision the precision of the exponential form
     * @return the exponential form
     */
    public String exponential(int precision) {
        // uses in built-functions to calculate the norm and argument
        // limiting the number of significant digits
        // and constructs the exponential form based on these
        return String.format("%se^(i*pi*%s)", norm(precision), argument(precision));
    }
}
