package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void testConstructorWithArguments() {
        Fraction fraction = new Fraction(3, 4);
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testSetNumerator() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(5);
        assertEquals(5, fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        Fraction fraction = new Fraction();
        fraction.setDenominator(6);
        assertEquals(6, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(0.5, fraction.decimal(), 0.001);
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(2, 3);
        assertEquals("Fraction{numerator=2, denominator=3}", fraction.toString());
    }

    @Test
    void testIsProper() {
        Fraction properFraction = new Fraction(2, 3);
        Fraction improperFraction = new Fraction(5, 2);

        assertTrue(properFraction.isProper());
        assertFalse(improperFraction.isProper());
    }

    @Test
    void testIsImproper() {
        Fraction properFraction = new Fraction(2, 3);
        Fraction improperFraction = new Fraction(5, 2);

        assertFalse(properFraction.isImproper());
        assertTrue(improperFraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 4);
        Fraction fraction3 = new Fraction(3, 5);

        assertTrue(fraction1.isEquivalent(fraction2));
        assertFalse(fraction1.isEquivalent(fraction3));
    }

    @Test
    void testAdd() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction sum = fraction1.add(fraction2);
        assertEquals(10, sum.getNumerator());
        assertEquals(8, sum.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction product = fraction1.multiply(fraction2);
        assertEquals(3, product.getNumerator());
        assertEquals(8, product.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(3, 4);
        Fraction quotient = fraction1.divide(fraction2);
        assertEquals(4, quotient.getNumerator());
        assertEquals(6, quotient.getDenominator());
    }

    @Test
    void testFindHighestFractionThrowsExceptionWhenEmptyList() {
        List<Fraction> emptyFractions = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Fraction.findHighestFraction(emptyFractions));
    }

    @Test
    void testFindFirstDecimalFractionByUserName() {
        UsersDatabase usersDatabase = new UsersDatabase();
        Double result = Fraction.findFirstDecimalFractionByUserName("Dani", usersDatabase);
        assertNull(result);
    }

    @Test
    void testFindHighestFraction() {
        List<Fraction> fractions = List.of(
                new Fraction(1, 2),
                new Fraction(3, 4),
                new Fraction(1, 3),
                new Fraction(5, 6)
        );

        Fraction highestFraction = Fraction.findHighestFraction(fractions);

        assertEquals(5, highestFraction.getNumerator());
        assertEquals(6, highestFraction.getDenominator());
    }
}
