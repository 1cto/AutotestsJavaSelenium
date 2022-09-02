package pages.olx_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Base.BasePage;

public class OlxHomePage extends BasePage {

    public OlxHomePage(WebDriver driver){
        super(driver);
    }

    private final By countRooms = By.xpath("//p[@class='css-1j2kr35-Text eu5v0x0'][text()='Кількість кімнат']");
    private final By option2rooms = By.xpath("//p[@class='css-1ukn2f9'][text()='2 кімнати']");
    private final By findButton = By.xpath("//button[@name='searchBtn']");

    public OlxHomePage enterCountRooms(){
        driver.findElement(countRooms).click();
        driver.findElement(option2rooms).click();

        return this;
    }

    public OlxHomePage clickToFind(){
        WebElement btnFind = driver.findElement(findButton);
        waitElementIsVisible(btnFind).click();

        return this;
    }

}
