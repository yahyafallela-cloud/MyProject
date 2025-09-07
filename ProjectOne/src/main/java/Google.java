import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
    public static void main(String[]args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://duckduckgo.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver" + Keys.ENTER);
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
    }

}
