package pages.olx_home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Base.BasePage;

public class OlxApartmentsPage extends BasePage {

    public OlxApartmentsPage(WebDriver driver){
        super(driver);
    }

    private final By countRooms = By.xpath("/html/body/div[1]/div[1]/div[2]/form/div[3]/div[1]/div/div[4]/div/div/div/div");
    private final By option2rooms = By.xpath("//p[@class='css-1ukn2f9'][text()='2 кімнати']");
    private final By findButton = By.xpath("//button[@name='searchBtn']");

    private final By card =  By.xpath("//div[@data-cy='l-card']");

    public OlxApartmentsPage enterCountRooms(){
        driver.findElement(countRooms).click();
        driver.findElement(option2rooms).click();

        return this;
    }

    public OlxApartmentsPage clickToFind(){
        WebElement btnFind = driver.findElement(findButton);
        waitElementIsVisible(btnFind).click();

        return this;
    }

    public OlxApartmentsPage checkCountCards() {
        int countCards = driver.findElements(card).size();

        Assert.assertTrue(countCards > 0);
        return this;
    }

}
