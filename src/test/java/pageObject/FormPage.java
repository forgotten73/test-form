package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class FormPage {

    public WebDriver driver;
    public String tdItem = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr/td[2]";
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement inputFirstName;

    @FindBy(id = "lastName")
    public WebElement inputLastName;

    @FindBy(id = "userEmail")
    public WebElement inputEmail;

    @FindBy(id = "userNumber")
    public WebElement inputUserNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement inputDateOfBirth;

    @FindBy(id = "subjectsInput")
    public WebElement inputSubjects;

    @FindBy(id = "currentAddress")
    public WebElement inputAddressField;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPicture;

    @FindBy(id = "state")
    public WebElement selectState;

    @FindBy(id = "city")
    public WebElement selectCity;

    @FindBy (id = "submit")
    public WebElement submitButton;
    @Step("input first name")
    public FormPage setInputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }
    @Step("input surname")
    public FormPage setInputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }
    @Step("input email")
    public FormPage setInputEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }
    @Step("choice gender")
    public FormPage choiceGender(String gender) {
        WebElement radioGender = driver.findElement(By.xpath("//*[contains(text(), '" + gender + "')]"));
        radioGender.click();
        return this;
    }
    @Step("input phone")
    public FormPage setInputUserNumber(String telNumber) {
        inputUserNumber.sendKeys(telNumber);
        return this;
    }
    @Step("input subject")
    public FormPage setInputSubjects(String subjects) {
        inputSubjects.sendKeys(subjects);
        inputSubjects.sendKeys(Keys.ENTER);
        return this;
    }
    @Step("choice hobbies")
    public FormPage choiceHobbies(String hobbies) {
        WebElement checkboxHobbies = driver.findElement(By.xpath("//*[contains(text(), '" + hobbies + "')]"));
        checkboxHobbies.click();
        return this;
    }
    @Step("input address")
    public FormPage setInputAddress(String address) {
        inputAddressField.sendKeys(address);
        return this;
    }
    @Step("open date picker")
    public FormPage clickDatePicker() {
        inputDateOfBirth.click();
        return this;
    }
    @Step("choice month")
    public FormPage setMonth (String month) {
        WebElement monthSelect = driver.findElement(By.className("react-datepicker__month-select"));
        monthSelect.click();
        List<WebElement> optionsMonth = monthSelect.findElements(By.tagName("option"));
        for (WebElement option : optionsMonth) {
            if(option.getText().trim().equals(month)) {
                option.click();
            }
        }
        return this;
    }
    @Step("choice year")
    public FormPage setYear(String year) {
        WebElement yearSelect = driver.findElement(By.className("react-datepicker__year-select"));
        yearSelect.click();
        List<WebElement> optionsYear = yearSelect.findElements(By.tagName("option"));
        for (WebElement option : optionsYear) {
            if(option.getText().trim().equals(year)) {
                new Actions(driver).scrollToElement(option);
                option.click();
            }
        }
        return this;
    }
    @Step("choice day")
    public FormPage setDay(String day) {
        WebElement monthDay = driver.findElement(By.className("react-datepicker__day--0" + day));
        monthDay.click();
        return this;
    }
    @Step("upload file")
    public FormPage uploadFile(String urlFile) {
        File imageFile = new File(urlFile);
        uploadPicture.sendKeys(imageFile.getAbsolutePath());
        return this;
    }
    @Step("choice state")
    public FormPage selectState(String stateName) {
        selectState.click();
        WebElement state = driver.findElement(By.xpath( "//*[text() = '" + stateName + "']"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> state.isDisplayed());
        state.click();
        return this;
    }
    @Step("choice city")
    public FormPage selectCity(String cityName) {
        selectCity.click();
        WebElement city = driver.findElement(By.xpath("//*[text() = '" + cityName + "']"));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> city.isDisplayed());
        city.click();
        return this;
    }
    @Step("click submit button")
    public FormPage clickSubmit() {
        submitButton.sendKeys(Keys.ENTER);
        return this;
    }
    @Step("Find tabular data")
    public List<String> findTabularData() {
        List<WebElement> tdList = driver.findElements(By.xpath(tdItem));
        List<String> list = new ArrayList<>();
        for (WebElement tdItem: tdList) {
            list.add(tdItem.getText());
        }
        return list;
    }
}

