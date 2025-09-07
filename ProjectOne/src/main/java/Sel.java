import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Sel {
    public static void main (String[]args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");


        WebElement men = driver.findElement(By.cssSelector("a[href='#Men']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",men);
        men.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/category_products/3']"))).click();

        List<WebElement> allProducts = driver.findElements(By.cssSelector(".productinfo"));

        for(WebElement product : allProducts){
            String priceText = product.findElement(By.tagName("h2")).getText();
            int price = Integer.parseInt(priceText.replaceAll("[^0-9]",""));

            if(price <= 1000){
                String productName = product.findElement(By.tagName("p")).getText();

                // زرار add to cart جوه نفس المنتج
                WebElement addBtn = product.findElement(By.cssSelector(".btn.btn-default.add-to-cart"));

                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",addBtn);
                addBtn.click();

                WebElement continueBtn = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(".btn.btn-success.close-modal.btn-block")));
                continueBtn.click();
                wait.until(ExpectedConditions.invisibilityOf(continueBtn));

                System.out.println("✅ Added to cart: " + productName + " | Price: " + price);
            }
        }

    }
}
