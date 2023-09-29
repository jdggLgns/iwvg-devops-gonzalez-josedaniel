package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsersDatabaseTest {

    private UsersDatabase usersDatabase = new UsersDatabase();

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        Stream<String> expected = Stream.of("López", "Blanco");
        Stream<String> result = usersDatabase.findUserFamilyNameByAllNegativeSignFractionDistinct();
        List<String> expectedList = expected.collect(Collectors.toList());
        List<String> resultList = result.collect(Collectors.toList());
        assertEquals(expectedList.size(), resultList.size());
        for (String familyName : expectedList) {
            assertEquals(true, resultList.contains(familyName));
        }
    }

    @Test
    void testFindFractionAdditionByUserId() {
        UsersDatabase usersDatabase = mock(UsersDatabase.class);
        when(usersDatabase.findFractionAdditionByUserId("1"))
                .thenReturn(new Fraction(3, 4));
        Fraction result = usersDatabase.findFractionAdditionByUserId("1");

        assertEquals(3, result.getNumerator());
        assertEquals(4, result.getDenominator());

        verify(usersDatabase, times(1)).findFractionAdditionByUserId("1");
    }

    @Test
    void testFindFractionAdditionByUserIdUserNotFound() {
        UsersDatabase usersDatabase = mock(UsersDatabase.class);
        when(usersDatabase.findFractionAdditionByUserId("100")).thenThrow(new IllegalArgumentException("User not found with ID: 100"));

        assertThrows(IllegalArgumentException.class, () -> {
            usersDatabase.findFractionAdditionByUserId("100");
        });
        verify(usersDatabase, times(1)).findFractionAdditionByUserId("100");
    }
}
