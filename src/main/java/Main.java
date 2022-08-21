import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C:\\Autotests\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        try{
            //Drag&Drop - for testing selenium drag&drop actions
            //Page&Wait - for testing selenium waiting of element to disappear
            //testng - work with testng
            //testTabs - windows and tabs
            String caseVariant = "testTabs";
            switch (caseVariant) {
                case ("Drag&Drop") -> {
                    driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
                    Thread.sleep(2000);

                    WebElement element1 = driver.findElement(By.id("draggable"));
                    WebElement element2 = driver.findElement(By.id("droppable"));

                    Actions action = new Actions(driver);

                    action.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform();
                }
                case ("Page&Wait") -> {
                    driver.get("https://pagination.js.org");
                    Thread.sleep(2000);

                    List<WebElement> elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
                    List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages']/ul/li"));
                    String text = elements.get(5).getText();
                    System.out.println(text);

                    pages.get(2).click();

                    wait.until(ExpectedConditions.stalenessOf(elements.get(5)));

                    elements = driver.findElements(By.xpath("//div[@class='data-container']/ul/li"));
                    text = elements.get(5).getText();
                    System.out.println(text);
                }
                case ("testng") -> {
                    driver.get("http://127.0.0.1:5500/alerts.html#");
                    Thread.sleep(2000);

                    String titleToBe = "TestAlert";
                    String title = driver.getTitle();
                    Assert.assertEquals(title, titleToBe);

                    WebElement element1_1 = driver.findElement(By.id("a"));
                    WebElement element1_2 = driver.findElement(By.id("b"));
                    WebElement element1_3 = driver.findElement(By.id("c"));

                    element1_1.click();

                    Alert alert = wait.until(alertIsPresent());
                    Thread.sleep(2000);
                    alert.accept();

                    element1_2.click();
                    Alert prompt = wait.until(alertIsPresent());
                    Thread.sleep(2000);

                    prompt.sendKeys("Super !!");
                    prompt.accept();

                    Alert alert2 = wait.until(alertIsPresent());
                    Thread.sleep(2000);
                    alert2.accept();

                    element1_3.click();
                    Alert alert3 = wait.until(alertIsPresent());
                    Thread.sleep(2000);
                    alert3.dismiss();
                }
                case ("testTabs") -> {
                    driver.get("http://127.0.0.1:5500/alerts.html#");
                    Thread.sleep(2000);

                    String window1 = driver.getWindowHandle();

                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("window.open()");

                    Set<String> currentWindows = driver.getWindowHandles();

                    String window2 = null;
                    for (String window : currentWindows) {
                        if (!window.equals(window1)) {
                            window2 = window;
                            break;
                        }
                    }

                    driver.switchTo().window(window2);
                    driver.get("http://127.0.0.1:5500/alerts.html#");
                }
                default -> {
                }
            }

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
        finally {
            Thread.sleep(20000);
            driver.quit();
        }



        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //WebElement element = (new WebDriverWait(Duration.ofSeconds(10))
        //        .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".link.parent.subcatBinded"))));

        //WebElement element = driver.findElement(By.cssSelector("[data-id='1944']"));
        //String par = element.getAttribute("href");
        //System.out.println(par);
        //input.click();
    }
}
