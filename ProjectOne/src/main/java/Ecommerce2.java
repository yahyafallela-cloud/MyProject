import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Ecommerce2 {
    public static void main(String[]args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] targetProduct = {"Brocolli","Cucumber","Beetroot"};
        List<WebElement> productName = driver.findElements(By.xpath("//div[@class='product']/h4[@class='product-name']"));
        for(int i=0; i<productName.size(); i++){
            String name = productName.get(i).getText().split("-")[0].trim();
            List<String> targetP = Arrays.asList(targetProduct);
            if(targetP.contains(name)){
                driver.findElements(By.cssSelector(".product-action button")).get(i).click();
            }
        }
        WebElement cart = driver.findElement(By.cssSelector("img[alt='Cart']"));
        cart.click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\Options Store\\Downloads\\cart.png");
        FileUtils.copyFile(source,destination);
        System.out.println("the Screenshot Saved Successfully");
        driver.quit();
    }
}
