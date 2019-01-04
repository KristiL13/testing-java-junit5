package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexController.index(), "Wrong view is returned");
    }

    @Test
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> { // we make sure that when the exception is thrown we get that exact exception class
            indexController.oopsHandler();
        });

//        assertTrue("notimplemented".equals(indexController.oopsHandler()), () -> "This is some" +
//                " expensive message " +
//                "to build"); // this message only gets built if the assertion is not true. can use lambdas here in Junit 5
    }
}