import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successRegistration(){

        open("/automation-practice-form");
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Asmanov");
        $("#userEmail").setValue("antonasmanov@yandex.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9221942060");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("English").pressTab();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/selenide-logo-big.png"));
        $("#currentAddress").setValue("Some Address");
        $("#react-select-3-input").setValue("NCR").pressTab();
        $("#react-select-4-input").setValue("Delhi").pressTab();
        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).parent().lastChild().shouldHave(text("Anton Asmanov"));
        $(".table").$(byText("Student Email")).parent().lastChild().shouldHave(text("antonasmanov@yandex.ru"));
        $(".table").$(byText("Gender")).parent().lastChild().shouldHave(text("Male"));
        $(".table").$(byText("Mobile")).parent().lastChild().shouldHave(text("9221942060"));
        $(".table").$(byText("Date of Birth")).parent().lastChild().shouldHave(text("13 March,1997"));
        $(".table").$(byText("Subjects")).parent().lastChild().shouldHave(text("English"));
        $(".table").$(byText("Hobbies")).parent().lastChild().shouldHave(text("Sports"));
        $(".table").$(byText("Picture")).parent().lastChild().shouldHave(text("selenide-logo-big.png"));
        $(".table").$(byText("Address")).parent().lastChild().shouldHave(text("Some Address"));
        $(".table").$(byText("State and City")).parent().lastChild().shouldHave(text("NCR Delhi"));
    }
}
