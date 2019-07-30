package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test proper view name is returned for index page")
    @Test
    void index() { // eri variandid
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), "Wrong view is returned");

        assertEquals("index", indexController.index(), () -> "Another Expensive Message " +
                "Make me only if you have to");

        assertThat(indexController.index()).isEqualTo("index"); // AssertJ näide L56
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

    @Disabled("Demo of timeout")
    @Test
    void testTimeOut() {
        // teeb testi läbi ja pärast hindab, kas see võttis kauem kui oli lubatud
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("I got here");
        });
    }

    @Disabled("Demo of timeout")
    @Test
    void testTimeOutPrempt() {
        // hakkab testi tegema teises threadis kui kus aega loeb. kui test võtab kauem, siis killib testi threadi ära.
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("I got here prempt");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("guru"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {
    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {
    }

    @EnabledOnJre(JRE.JAVA_10)
    @Test
    void testMeOnJava10() {
    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {
    }

    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "Kristi Laur")
    @Test
    void testIfUserKristiWindows() {
    }

    @EnabledIfEnvironmentVariable(named = "USER", matches = "Fred")
    @Test
    void testIfUserFredMac() {
    }
}