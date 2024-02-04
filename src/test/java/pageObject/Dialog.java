package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dialog {
    public WebDriver driver;

    public String tdItem = "/html/body/div[4]/div/div/div[2]/div/table/tbody/tr/td[2]";

    public Dialog(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> findTabularData() {
        List<WebElement> tdList = driver.findElements(By.xpath(tdItem));
        List<String> list = new ArrayList<>();
        for (WebElement tdItem: tdList) {
            list.add(tdItem.getText());
        }
        return list;
    }
}
