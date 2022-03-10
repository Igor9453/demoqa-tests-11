package Tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "Safari";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successFillTest () {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice-Form"));

        $("#firstName").setValue("ROK");
        $("#userEmail").setValue("ROK@comp.su");
        $("#genterWrapper").setValue("gender-radio-1");
        $("#userNumber").setValue("+7-999-450-55-65");
        $("#dateOfBirthInput").setValue("11.01.1991");
        $("#subjectsContainer").setValue("history");
        $("#subjects-label").setValue("hobbies-checkbox-3");
        $("#currentAddress").setValue("Rok address 1");
        $("#submit").click();

        $("#output").shouldHave(text("ROK"), text("ROK@comp.su"), text("Male"),
                text("+7-999-450-55-65"), text("11.01.1991"), text("history"), text("music"), text("Rok address 1"));
    }
}