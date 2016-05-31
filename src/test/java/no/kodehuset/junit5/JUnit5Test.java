package no.kodehuset.junit5;

import org.junit.gen5.api.Test;
import org.junit.gen5.api.TestReporter;
import org.junit.gen5.api.extension.ExtendWith;
import org.junit.gen5.junit4.runner.JUnit5;
import org.junit.runner.RunWith;

import static org.junit.gen5.api.Assertions.*;

@RunWith(JUnit5.class)
@ExtendWith({TestBeforeAllExtension.class, OnlyThrowsTests.class})
public class JUnit5Test {

    @Test
    void equalsTest() {

        assertEquals(1, 1);
    }


    @Test
    void assertAllTest() {

        Person person = new Person("Jaran Flaath", 34, true);

        assertAll(
                () -> assertEquals("Jaran Flaath", person.name),
                () -> assertEquals(34, person.age),
                () -> assertEquals(true, person.isMale)
        );
    }


    @Test
    void assertThrowsTest() {

        assertThrows(IllegalArgumentException.class, this::throwIllegalArgumentException);

    }


    @Test
    void expectThrowsTest() {

        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, this::throwIllegalArgumentException);
        assertEquals("Fo'sho!", ex.getMessage());
    }


    @Test
    void injectTestReporter(TestReporter testReporter) {

        testReporter.publishEntry("status", "pass!");

        assertTrue(true);
    }


    private void throwIllegalArgumentException() {

        throw new IllegalArgumentException("Fo'sho!");

    }

}
