package test;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PageTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Practice Form")
    public void pageTest() {
        List<String> outputData;
        formPage.setInputFirstName(userName);
        formPage.setInputLastName(userSurname);
        formPage.setInputEmail(userEmail);
        formPage.choiceGender(userGender);
        formPage.setInputUserNumber(userPhone);
        formPage.setInputSubjects(userSubject);
        formPage.choiceHobbies(userHobbies);
        formPage.setInputAddress(userAddress);
        formPage.clickDatePicker();
        formPage.setMonth(birthdayMonth);
        formPage.setYear(birthdayYear);
        formPage.setDay(birthdayDay);
        formPage.uploadFile("src/test/resources/kity.jpg");
        formPage.selectState(userState);
        formPage.selectCity(userCity);
        formPage.clickSubmit();
        outputData = formPage.findTabularData();
        Assertions.assertEquals(outputData.get(0), userName + " " + userSurname, "wrong name");
        Assertions.assertEquals(outputData.get(1), userEmail, "wrong email");
        Assertions.assertEquals(outputData.get(2), userGender, "wrong gender");
        Assertions.assertEquals(outputData.get(3), userPhone, "wrong phone");
        Assertions.assertEquals(outputData.get(4), birthdayDay + " " + birthdayMonth + "," + birthdayYear, "wrong date of birth");
        Assertions.assertEquals(outputData.get(5), userSubject, "wrong subject");
        Assertions.assertEquals(outputData.get(6), userHobbies, "wrong hobbies");
        Assertions.assertEquals(outputData.get(8), userAddress, "wrong address");
        Assertions.assertEquals(outputData.get(9), userState + " " + userCity, "wrong state and city");
    }
}
