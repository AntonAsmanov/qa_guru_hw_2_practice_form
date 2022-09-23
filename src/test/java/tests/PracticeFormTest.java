package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class PracticeFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successRegistration(){

        registrationFormPage
                .openPage()
                .setFirstName("Anton")
                .setLastName("Asmanov")
                .setEmail("antonasmanov@yandex.ru")
                .setGenderWrapper("Male")
                .setPhoneNumber("9221942060")
                .setBirthdate("1997","March","13")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadPicture("src/test/resources/selenide-logo-big.png")
                .setAddress("Some Address")
                .setState("NCR")
                .setCity("Delhi")
                .submit()

                .checkResultsVisible()
                .checkResult("Student Name","Anton Asmanov")
                .checkResult("Student Email","antonasmanov@yandex.ru")
                .checkResult("Gender","Male")
                .checkResult("Mobile","9221942060")
                .checkResult("Date of Birth", "13 March,1997")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports")
                .checkResult("Address", "Some Address")
                .checkResult("State and City", "NCR Delhi")
        ;


    }
}
