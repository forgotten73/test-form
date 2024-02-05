package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import helper.ConfProperties;
import pageObject.FormPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static FormPage formPage;
    public static WebDriver driver;

    public static String userName;
    public static String userSurname;
    public static String userEmail;
    public static String userGender;
    public static String userPhone;
    public static String userSubject;
    public static String userHobbies;
    public static String userAddress;
    public static String birthdayMonth;
    public static String birthdayYear;
    public static String birthdayDay;
    public static String userState;
    public static String userCity;

    @BeforeAll
    public static void initVars() {
        userName = "Sergey";
        userSurname = "Tsirkun";
        userEmail = "myTest@serega.com";
        userGender = "Male";
        userPhone = "9990006969";
        userSubject = "Computer Science";
        userHobbies = "Sports";
        userAddress = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        birthdayMonth = "January";
        birthdayYear = "1992";
        birthdayDay = "14";
        userState = "NCR";
        userCity = "Delhi";
    }

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        formPage = new FormPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("demoqapage"));

    }
    @AfterAll
    public static void close() {
        driver.quit();
    }

}
