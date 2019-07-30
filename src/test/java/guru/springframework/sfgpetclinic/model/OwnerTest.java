package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1L, "Joe", "Smith");
        owner.setCity("Tallinn");
        owner.setTelephone("6555444");

        assertAll("Properties Test", // nested assertAll
                () -> assertAll("Person Properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First Name did not match"),
                        () -> assertEquals("Smith", owner.getLastName(), "Last Name did not match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Tallinn", owner.getCity(), "City did not match"),
                        () -> assertEquals("6555444", owner.getTelephone(), "Telephone did not match"))
                );

        // Hamcresti näide: Matchers and assertions, L57
        assertThat(owner.getCity(), is("Tallinn")); // annad enne selle, mis ta saab, siis võrdlus data
    }

}