package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
}
