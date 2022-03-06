package qaguru5;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ParametrizedTests {

    @BeforeEach
    void precondition() {
        Selenide.open("https://mafin.ru/");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }

    //1st
    @ValueSource(strings = {"А111АА777", "К367ММ777"})
    @ParameterizedTest(name = "Check mafin with GRZ {0}")
    void commonSearchTest(String grz) {
        $("input[data-testid='input-number']").setValue(grz);
        $("a[data-autotestid='desktop-button-0']").click();
        $("div h1").shouldHave(textCaseSensitive("Оформить КАСКО"));
    }

    //2nd
    @CsvSource(value = {
            "А111АА777, Toyota, RAV4",
            "К367ММ777, Volkswagen, Polo"
    })
    //3d
    @ParameterizedTest(name = "Check mafin, with mark of auto = {1}")
    void complexSearchTest(String grz, String mark, String model) {
        $("input[data-testid='input-number']").setValue(grz);
        $("a[data-autotestid='desktop-button-0']").click();
        $("div[data-testid='card-header'] h3").shouldHave(text("Данные автомобиля"));
        $("input[data-autotest-id='mark']").shouldHave(value(mark));
        $("input[data-autotest-id='model']").shouldHave(value(model));
    }

    @Disabled
    @ValueSource(strings = {"А214АА333", "А888ОО333"})
    @ParameterizedTest(name = "Check mafin with GRZ {0}")
    void disabledTest(String grz) {
        $("input[data-testid='input-number']").setValue(grz);
        $("a[data-autotestid='desktop-button-0']").click();
        $("div h1").shouldHave(textCaseSensitive("Оформить КАСКО"));
    }


    static Stream<Arguments> mixedArgumentsTestDataProvider() {
        return Stream.of(
                Arguments.of("А111АА777", "Toyota", "RAV4"),
                Arguments.of("К367ММ777", "Volkswagen", "Polo")
        );
    }

    @MethodSource(value = "mixedArgumentsTestDataProvider")
    @ParameterizedTest(name = "Check mafin")
    void mixedArgumentsTest(String grz, String mark, String model) {
        $("input[data-testid='input-number']").setValue(grz);
        $("a[data-autotestid='desktop-button-0']").click();
        $("div[data-testid='card-header'] h3").shouldHave(text("Данные автомобиля"));
        $("input[data-autotest-id='mark']").shouldHave(value(mark));
        $("input[data-autotest-id='model']").shouldHave(value(model));

    }

}