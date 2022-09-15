import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void successRegistration(){

        open("/automation-practice-form");
        $("[id=firstName]").setValue("Ivan");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("ivan.ivanov@test.ru");
        $("[id=genterWrapper").find("[name=gender]").selectRadio("Male");
        $("[id=userNumber]").setValue("79221942060");
        $("[id=dateOfBirthInput]").setValue("13 mar 1997");
        $("[id=subjectsInput]").setValue("English");
        $("[id=subjectsContainer]").selectOptionContainingText("English");
    }
}
