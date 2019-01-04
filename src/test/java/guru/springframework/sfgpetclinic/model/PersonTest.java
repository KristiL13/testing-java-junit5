package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        // given
        Person person = new Person(1L, "Joe", "Smith");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Smith", person.getLastName()));
    }


    @Test
    void groupedAssertionsMsgs() {
        // given
        Person person = new Person(1L, "Joe", "Smith");

        // then
        assertAll("Test Props Set",
                () -> assertEquals("Joe", person.getFirstName(), "First Name failed"),
                () -> assertEquals("Smith", person.getLastName(), "Last Name failed"));
    }
}