package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue("ROK");
        $("#lastName").setValue("Rok-Hard");
        $("#userEmail").setValue("rok@inbox.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89994505565");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--012").click();

        $("#subjectsInput").setValue("Moto").click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/intro.jpg"));
        $("#currentAddress").setValue("ROK-Home");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave((textCaseSensitive("Thanks for submitting the form")));
        $(".table-responsive").shouldHave(
                textCaseSensitive("Student Name"),    textCaseSensitive("ROK Rok-Hard"),
                textCaseSensitive("Student Email"),   textCaseSensitive("rok@inbox.ru"),
                textCaseSensitive("Gender"),          textCaseSensitive("Male"),
                textCaseSensitive("Mobile"),          textCaseSensitive("89994505565"),
                textCaseSensitive("Date of Birth"),   textCaseSensitive("2 February,1992"),
                textCaseSensitive("Subjects"),        textCaseSensitive("Moto"),
                textCaseSensitive("Hobbies"),         textCaseSensitive("Reading"),
                textCaseSensitive("Picture"),         textCaseSensitive("intro.jpg"),
                textCaseSensitive("Address"),         textCaseSensitive("ROK-Home"),
                textCaseSensitive("State and City"),  textCaseSensitive("Haryana Panipat")
        );

        $("#closeLargeModal").click();
    }
}