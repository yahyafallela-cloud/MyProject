package ShopApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Register {
    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/#/auth/register");
        driver.findElement(By.id("firstName")).sendKeys("yahia");
        driver.findElement(By.id("lastName")).sendKeys("Fallela");
        driver.findElement(By.id("userEmail")).sendKeys("yahyafallela@gmail.com");
        driver.findElement(By.id("userMobile")).sendKeys("2010922713");

        WebElement occupation = driver.findElement(By.cssSelector("select[formcontrolname='occupation']"));
        Select select = new Select(occupation);
        select.selectByVisibleText("Student");

        driver.findElement(By.cssSelector("input[value='Male']")).click();

        driver.findElement(By.id("userPassword")).sendKeys("Admin@123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Admin@123");

        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        driver.findElement(By.id("login")).click();
    }

}
