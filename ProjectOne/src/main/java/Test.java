import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test {
    public static void main (String[]args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-1enofrn r-1ozqkpa']"));
        for(int i=0; i<radioButtons.size(); i++){
            String radioName= radioButtons.get(i).getText();
            if(radioName.equalsIgnoreCase("Armed Forces")){
                radioButtons.get(i).click();
                break;
            }
        }
        
        WebElement searchButton = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
        searchButton.click();
    }
}
