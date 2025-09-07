import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

public class Sell {
    public static void main(String[]args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        JavascriptExecutor js =(JavascriptExecutor)driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement men = driver.findElement(By.cssSelector("a[href='#Men']"));
        js.executeScript("arguments[0].scrollIntoView(true);",men);
        men.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/category_products/3']"))).click();

        List<WebElement> allProducts = driver.findElements(By.cssSelector(".productinfo"));
        for(WebElement product : allProducts){
            String productText = product.findElement(By.tagName("h2")).getText();
            int productPrice = Integer.parseInt(productText.replaceAll("[^0-9]",""));

            if (productPrice < 1000){
                WebElement btn =product.findElement(By.cssSelector(".btn.btn-default.add-to-cart"));
                js.executeScript("arguments[0].scrollIntoView(true);",btn);
                btn.click();

                WebElement successBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-success.close-modal.btn-block")));
                successBtn.click();
                wait.until(ExpectedConditions.invisibilityOf(successBtn));
            }
        }
        WebElement cart = driver.findElement(By.cssSelector("a[href='/view_cart']"));
        cart.click();

        TakesScreenshot ts =(TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\Options Store\\Downloads\\cart2.png");
        FileUtils.copyFile(source,destination);
    }

}
