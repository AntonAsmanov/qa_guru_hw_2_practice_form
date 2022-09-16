import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.clickViaJs = true;
    }

    @Test
    void successRegistration(){

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("ivan.ivanov@test.ru");
        $("[id=genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("79221942060");
        $("[id=dateOfBirthInput]").clear();
        $("[id=dateOfBirthInput]").setValue("");
        $("[class=react-datepicker__month]").find("[role=option").click();
        $("[id=subjectsInput]").setValue("English").pressTab();
        $("[id=hobbiesWrapper").find(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/selenide-logo-big.png"));
        $("[id=currentAddress").setValue("Something Address");
        $("#react-select-3-input").setValue("NCR").pressTab();
        $("#react-select-4-input").setValue("Delhi").pressTab();
        $("#submit").scrollTo();
        $("#submit").click();


    }
}
