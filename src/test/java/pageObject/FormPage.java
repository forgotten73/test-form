package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;


public class FormPage {

    public WebDriver driver;
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

    @FindBy(xpath = "//*[contains(text(), 'Male')]")
    public WebElement radioGenderMale;

    @FindBy(id = "userNumber")
    public WebElement inputUserNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement inputDateOfBirth;

    @FindBy(id = "subjectsInput")
    public WebElement inputSubjects;

    @FindBy(xpath = "//*[contains(text(), 'Sports')]")
    public WebElement checkboxHobbies;

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

    public void setInputFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
    }

    public void setInputLastName(String lastName) {
        inputLastName.sendKeys(lastName);
    }

    public void setInputEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void choiceGender() {
        radioGenderMale.click();
    }

    public void setInputUserNumber(String telNumber) { inputUserNumber.sendKeys(telNumber); }

    public void setInputSubjects(String subjects) {
        inputSubjects.sendKeys(subjects);
        inputSubjects.sendKeys(Keys.ENTER);
    }

    public void choiceHobbies() {
        checkboxHobbies.click();
    }

    public void setInputAddress(String address) {
        inputAddressField.sendKeys(address);
    }

    public void clickDatePicker() {
        inputDateOfBirth.click();
    }

    public void setMonth (String month) {
        WebElement monthSelect = driver.findElement(By.className("react-datepicker__month-select"));
        monthSelect.click();
        List<WebElement> optionsMonth = monthSelect.findElements(By.tagName("option"));
        for (WebElement option : optionsMonth) {
            if(option.getText().trim().equals(month)) {
                option.click();
            }
        }
    }

    public void setYear(String year) {
        WebElement yearSelect = driver.findElement(By.className("react-datepicker__year-select"));
        yearSelect.click();
        List<WebElement> optionsYear = yearSelect.findElements(By.tagName("option"));
        for (WebElement option : optionsYear) {
            if(option.getText().trim().equals(year)) {
                new Actions(driver).scrollToElement(option);
                option.click();
            }
        }
    }

    public void setDay(String day) {
        WebElement monthDay = driver.findElement(By.className("react-datepicker__day--0" + day));
        monthDay.click();
    }

    public void uploadFile() {
        File imageFile = new File("src/test/resources/kity.jpg");
        uploadPicture.sendKeys(imageFile.getAbsolutePath());
    }

    public void selectState(String stateName) {
        selectState.click();
        WebElement state = driver.findElement(By.xpath(stateName));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> state.isDisplayed());
        state.click();
    }

    public void selectCity(String cityName) {
        selectCity.click();
        WebElement city = driver.findElement(By.xpath(cityName));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(d -> city.isDisplayed());
        city.click();
    }

    public void clickSubmit() {
        submitButton.sendKeys(Keys.ENTER);

    }
}

