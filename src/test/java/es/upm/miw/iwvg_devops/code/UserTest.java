package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGetId() {
        User user = new User("1", "Dani", "Gonzalez", new ArrayList<>());
        assertEquals("1", user.getId());
    }

    @Test
    void testGetName() {
        User user = new User("1", "Dani", "Gonzalez", new ArrayList<>());
        assertEquals("Dani", user.getName());
    }

    @Test
    void testSetName() {
        User user = new User("1", "Dani", "Gonzalez", new ArrayList<>());
        user.setName("Alice");
        assertEquals("Alice", user.getName());
    }

    @Test
    void testGetFamilyName() {
        User user = new User("1", "Dani", "Gonzalez", new ArrayList<>());
        assertEquals("Gonzalez", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        User user = new User("1", "Dani", "Gonzalez", new ArrayList<>());
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        List<Fraction> fractions = Arrays.asList(new Fraction(1, 2), new Fraction(3, 4));
        User user = new User("1", "Dani", "Gonzalez", fractions);
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testAddFraction() {
        User user = new User("1", "Dani", "Gonzalez", new ArrayList<>());
        Fraction fraction = new Fraction(1, 2);
        user.addFraction(fraction);
        assertEquals(1, user.getFractions().size());
        assertEquals(fraction, user.getFractions().get(0));
    }

    @Test
    void testInitials() {
        User user = new User("1", "Dani", "Gonzalez", new ArrayList<>());
        assertEquals("D.", user.initials());
    }

    @Test
    void testToString() {
        User user = new User("1", "Dani", "Gonzalez", Arrays.asList(new Fraction(1, 2), new Fraction(3, 4)));
        assertEquals("User{id='1', name='Dani', familyName='Gonzalez', fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=3, denominator=4}]}", user.toString());
    }
    @Test
    void testFullName() {
        User user = new User("1", "Dani", "Gonzalez", null);
        assertEquals("Dani Gonzalez", user.fullName());
    }

    @Test
    void testSetFractions() {
        User user = new User("1", "Dani", "Gonzalez", new ArrayList<>());
        List<Fraction> fractions = Arrays.asList(new Fraction(1, 2), new Fraction(3, 4));
        user.setFractions(fractions);
        assertEquals(fractions, user.getFractions());
    }
}
