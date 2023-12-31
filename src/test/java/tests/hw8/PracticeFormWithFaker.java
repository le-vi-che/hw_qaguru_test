package tests.hw8;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.components.hw8.RegistrationPage;
import tests.hw3.TestBase;
import tests.hw3.TestData;


public class PracticeFormWithFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    TestData testData = new TestData();
    @Test
    @DisplayName("Полное заполнение формы")
    void fullCompleteFormTest() {

       registrationPage.openPage()
       .setFirstName(testData.firstName)
       .setLastName(testData.lastName)
       .setUserEmail(testData.userEmail)
       .setGenterWrapper(testData.genderUser)
       .setUserNumber(testData.userNumber)
       .setDateOfBirth(testData.dayBirth, testData.monthBirth, testData.yearBirth)
       .setSubjectsInput(testData.subjects)
       .setHobbiesWrapperInput(testData.hobbies)
       .setUploadPicture(testData.picture)
       .setCurrentAddress(testData.currentAddres)
       .setChooseState(testData.state)
       .setChooseCity(testData.city)
       .pressSubmit();

        registrationPage.checkResult("Student Name", testData.firstName + " " +testData.lastName)
                  .checkResult("Student Email", testData.userEmail)
                 .checkResult("Gender", testData.genderUser)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.dayBirth +" " + testData.monthBirth + "," + testData.yearBirth)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.currentAddres)
                .checkResult("State and City", testData.state + " " + testData.city);
    }


    @Test
    void partCompleteFormTest() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenterWrapper(testData.genderUser)
                .setUserNumber(testData.userNumber)
                .pressSubmit();

        registrationPage.checkResult("Student Name", testData.firstName + " " +testData.lastName)
                .checkResult("Gender", testData.genderUser)
                .checkResult("Mobile", testData.userNumber);
    }

    @Test
    void negativeCompleteFormTest() {

        registrationPage.openPage()
                 .pressSubmit()
                 .checkNotCompleteForm();
            }
}




