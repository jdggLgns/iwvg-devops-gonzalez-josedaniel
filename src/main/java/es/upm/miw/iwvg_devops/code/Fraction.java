package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.Optional;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
    public boolean isProper() {
        return numerator < denominator;
    }

    public boolean isImproper() {
        return numerator > denominator;
    }

    public boolean isEquivalent(Fraction fraction) {
        return numerator * fraction.getDenominator() == denominator * fraction.getNumerator();
    }

    public Fraction add(Fraction fraction) {
        int commonDenominator = this.denominator * fraction.getDenominator();
        int sumNumerator = this.numerator * fraction.getDenominator() + fraction.getNumerator() * this.denominator;
        return new Fraction(sumNumerator, commonDenominator);
    }

    public Fraction multiply(Fraction fraction) {
        int productNumerator = this.numerator * fraction.getNumerator();
        int productDenominator = this.denominator * fraction.getDenominator();
        return new Fraction(productNumerator, productDenominator);
    }

    public Fraction divide(Fraction fraction) {
        int quotientNumerator = this.numerator * fraction.getDenominator();
        int quotientDenominator = this.denominator * fraction.getNumerator();
        return new Fraction(quotientNumerator, quotientDenominator);
    }
    public static Double findFirstDecimalFractionByUserName(String name, UsersDatabase usersDatabase) {
        Optional<User> userOptional = usersDatabase.findAll()
                .filter(user -> user.getName().equals(name))
                .findFirst();

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Fraction> fractions = user.getFractions();
            if (!fractions.isEmpty()) {
                Fraction firstFraction = fractions.get(0);
                return firstFraction.decimal();
            }
        }
        return null;
    }

    public static Fraction findHighestFraction(List<Fraction> fractions) {
        if (fractions == null || fractions.isEmpty()) {
            throw new IllegalArgumentException("The list of fractions cannot be empty");
        }

        Fraction highestFraction = fractions.get(0);
        double highestDecimal = highestFraction.decimal();

        for (Fraction fraction : fractions) {
            double currentDecimal = fraction.decimal();
            if (currentDecimal > highestDecimal) {
                highestDecimal = currentDecimal;
                highestFraction = fraction;
            }
        }

        return highestFraction;
    }
}
