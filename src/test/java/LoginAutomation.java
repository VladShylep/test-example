import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginAutomation {
    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/vlad/Documents/Selenium-drivers/Firefox/geckodriver");
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://automationpractice.com/index.php");
        WebElement product=driver.findElement(By.id("search_query_top"));
        product.sendKeys("Printed Chiffon Dress");
        WebElement search=driver.findElement(By.name("submit_search"));
        search.click();
        Thread.sleep(10000);
        List<WebElement> productCard = driver.findElement(By.className("product_list")).findElements(By.xpath("*"));
        Actions actions = new Actions(driver);
        actions.moveToElement(productCard.get(0)).click().build().perform();
        Thread.sleep(15000);
        WebElement color = driver.findElement(By.id("color_15"));
        actions.moveToElement(color).click().build().perform();
        WebElement addProduct = driver.findElement(By.name("Submit"));
        addProduct.click();
        WebElement dialog = driver.findElement(By.cssSelector("h2"));

        Assert.assertEquals(dialog.getText(), "");



    }
}