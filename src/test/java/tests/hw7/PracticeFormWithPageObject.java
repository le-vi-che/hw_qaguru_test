package tests.hw7;

import org.junit.jupiter.api.Test;
import pages.components.hw8.RegistrationPage;
import tests.hw3.TestBase;

public class PracticeFormWithPageObject extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

    private String firstName = "fill",
            lastName = "good",
            userEmail = "qwerty@ty.ru",
            genderUser = "Male",
            userNumber = "8888888888",
            dayBirth = "14",
            monthBirth = "July",
            yearBirth = "1992",
            subjects = "Hindi",
            hobbies = "Reading",
            picture = "picture2.png",
            currentAddres = "Spb, 363",
            state = "Haryana",
            city = "Karnal";

    @Test
    void fullCompleteFormTest() {

       registrationPage.openPage()
       .setFirstName(firstName)
       .setLastName(lastName)
       .setUserEmail(userEmail)
       .setGenterWrapper(genderUser)
       .setUserNumber(userNumber)
       .setDateOfBirth(dayBirth, monthBirth, yearBirth)
       .setSubjectsInput(subjects)
       .setHobbiesWrapperInput(hobbies)
       .setUploadPicture( picture)
       .setCurrentAddress(currentAddres)
       .setChooseState(state)
       .setChooseCity(city)
       .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " +lastName)
                  .checkResult("Student Email", userEmail)
                 .checkResult("Gender", genderUser)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayBirth +" " + monthBirth + "," + yearBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddres)
                .checkResult("State and City", state + " " + city);
    }


    @Test
    void partCompleteFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGenterWrapper(genderUser)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult("Student Name", firstName + " " +lastName)
                .checkResult("Gender", genderUser)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeCompleteFormTest() {

        registrationPage.openPage()
                 .pressSubmit()
                 .checkNotCompleteForm();
            }
}


