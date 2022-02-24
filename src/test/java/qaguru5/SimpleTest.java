package qaguru5;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

@DisplayName("Класс с простыми тестами")
public class SimpleTest {

    @BeforeAll
    @DisplayName("Method was executed before all tests")
    static void beforeAll() {
        System.out.println("This method was executed before all test");
    }

    @BeforeEach
    @DisplayName("Method was executed before each test")
    void open() {
        Selenide.open("https://mafin.ru/");
        System.out.println("This method was executed before each test");
    }

    @AfterEach
    @DisplayName("Method was executed after each test")
    void closeBrowser() {
        Selenide.closeWebDriver();
        System.out.println("This method was executed after each test");
    }

    @AfterAll
    @DisplayName("Method was executed after all tests")
    static void afterAll() {
        System.out.println("This method was executed after all tests");
    }
}
