package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.DataGen;


public class PracticeFormTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    String firstName = DataGen.firstName();
    String lastName = DataGen.lastName();
    String email = DataGen.email();
    String gender = DataGen.gender();
    String phone = DataGen.phone();
    String birthdateYear = DataGen.birthdateYear();
    String birthdateMonth = DataGen.birthdateMonth();
    String birthdateDay = DataGen.birthdateDay();
    String subject = DataGen.subject();
    String hobby = DataGen.hobby();
    String pictureName = DataGen.pictureName();
    String address = DataGen.address();
    String state = DataGen.state();
    String city = DataGen.city(state);


    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successRegistration(){

        registrationFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenderWrapper(gender)
                .setPhoneNumber(phone)
                .setBirthdate(birthdateYear,birthdateMonth,birthdateDay)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadPicture(pictureName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()

                .checkResultsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email",email)
                .checkResult("Gender",gender)
                .checkResult("Mobile",phone)
                .checkResult("Date of Birth", birthdateDay + " " + birthdateMonth + "," + birthdateYear)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city)
        ;
    }
}
