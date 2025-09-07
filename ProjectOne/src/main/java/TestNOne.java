import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNOne {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

        @Test
        public void searchSelenium() throws InterruptedException {
            driver.get("https://www.google.com/");

            WebElement search = driver.findElement(By.name("q"));
            search.sendKeys("Selenium");
            search.submit();
            Thread.sleep(5000);

    }
    @AfterMethod
    public void end(){
        driver.quit();

    }

}
